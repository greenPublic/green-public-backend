package com.green.controller.informations;

import com.green.entity.informations.Information;
import com.green.entity.translation.Language;
import com.green.service.implementation.informations.InformationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/information")
public class InformationController {

    private final InformationService informationService;

    @Autowired
    public InformationController(InformationService informationService) {
        this.informationService = informationService;
    }

    @GetMapping
    public ResponseEntity<List<Information>> getAllInformation() {
        List<Information> informationList = informationService.getAllInformation();
        return new ResponseEntity<>(informationList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Information> getInformationById(@PathVariable String id) {
        Optional<Information> information = informationService.getInformationById(id);
        return information.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Information> createInformation(@RequestBody Information information) {
        Information createdInformation = informationService.createInformation(information);
        return new ResponseEntity<>(createdInformation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Information> updateInformation(@PathVariable String id,
                                                         @RequestBody Information information) {
        Optional<Information> existingInformation = informationService.getInformationById(id);
        if (existingInformation.isPresent()) {
            information.setId(id);
            Information updatedInformation = informationService.updateInformation(information);
            return new ResponseEntity<>(updatedInformation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInformation(@PathVariable String id) {
        informationService.deleteInformation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/header/{header}")
    public ResponseEntity<Information> getInformationByHeader(@PathVariable String header) {
        Information information = informationService.getInformationByHeader(header);
        return new ResponseEntity<>(information, HttpStatus.OK);
    }

    @GetMapping("/language/{language}")
    public ResponseEntity<List<Information>> getInformationByLanguage(@PathVariable
                                                                      Language language) {
        List<Information> informationList = informationService.getInformationByLanguage(language);
        return new ResponseEntity<>(informationList, HttpStatus.OK);
    }

    @GetMapping("/description/{keyword}")
    public ResponseEntity<List<Information>> getInformationByDescriptionContaining(
            @PathVariable String keyword) {
        List<Information> informationList =
                informationService.getInformationByDescriptionContaining(keyword);
        return new ResponseEntity<>(informationList, HttpStatus.OK);
    }

    @DeleteMapping("/header/{header}")
    public ResponseEntity<Void> deleteInformationByHeader(@PathVariable String header) {
        informationService.deleteInformationByHeader(header);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

