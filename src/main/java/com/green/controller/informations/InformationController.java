package com.green.controller.informations;

import com.green.dto.informations.InformationDto;
import com.green.service.implementation.informations.InformationServiceImpl;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/information")
public class InformationController {

    private final InformationServiceImpl informationServiceImpl;

    @Autowired
    public InformationController(InformationServiceImpl informationServiceImpl) {
        this.informationServiceImpl = informationServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<InformationDto>> getAllInformation(@RequestHeader String lang) {
        List<InformationDto> informationList = informationServiceImpl.getAllInformation(lang);
        return new ResponseEntity<>(informationList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InformationDto> getInformationById(@PathVariable String id) {
        Optional<InformationDto> information = informationServiceImpl.getInformationById(id);
        return information.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<InformationDto> createInformation(
            @RequestBody InformationDto information, @RequestHeader String lang) {
        InformationDto createdInformation = informationServiceImpl.createInformation(information, lang);
        return new ResponseEntity<>(createdInformation, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InformationDto> updateInformation(@PathVariable String id,
                                                            @RequestBody
                                                            InformationDto information) {
        Optional<InformationDto> existingInformation = informationServiceImpl.getInformationById(id);
        if (existingInformation.isPresent()) {
            InformationDto updatedInformation = informationServiceImpl.updateInformation(information);
            return new ResponseEntity<>(updatedInformation, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInformation(@PathVariable String id) {
        informationServiceImpl.deleteInformation(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/header/{header}")
    public ResponseEntity<InformationDto> getInformationByHeader(@PathVariable String header) {
        InformationDto information = informationServiceImpl.getInformationByHeader(header);
        return new ResponseEntity<>(information, HttpStatus.OK);
    }

    @GetMapping("/language/{language}")
    public ResponseEntity<List<InformationDto>> getInformationByLanguage(@PathVariable
                                                                         String language) {
        List<InformationDto> informationList =
                informationServiceImpl.getInformationByLanguage(language);
        return new ResponseEntity<>(informationList, HttpStatus.OK);
    }

    @GetMapping("/description/{keyword}")
    public ResponseEntity<List<InformationDto>> getInformationByDescriptionContaining(
            @PathVariable String keyword) {
        List<InformationDto> informationList =
                informationServiceImpl.getInformationByDescriptionContaining(keyword);
        return new ResponseEntity<>(informationList, HttpStatus.OK);
    }

    @DeleteMapping("/header/{header}")
    public ResponseEntity<Void> deleteInformationByHeader(@PathVariable String header) {
        informationServiceImpl.deleteInformationByHeader(header);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

