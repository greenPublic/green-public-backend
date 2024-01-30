package com.green.controller.tree;

import com.green.dto.language.LanguageDto;
import com.green.dto.tree.TreeSpeciesDto;
import com.green.service.implementation.tree.TreeSpeciesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tree-species")
public class TreeSpeciesController {

    private final TreeSpeciesService treeSpeciesService;

    @Autowired
    public TreeSpeciesController(TreeSpeciesService treeSpeciesService) {
        this.treeSpeciesService = treeSpeciesService;
    }

    @GetMapping
    public ResponseEntity<List<TreeSpeciesDto>> getAllTreeSpecies() {
        List<TreeSpeciesDto> treeSpeciesList = treeSpeciesService.getAllTreeSpecies();
        return new ResponseEntity<>(treeSpeciesList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreeSpeciesDto> getTreeSpeciesById(@PathVariable String id) {
        return treeSpeciesService.getTreeSpeciesById(id)
                .map(treeSpeciesDto -> new ResponseEntity<>(treeSpeciesDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TreeSpeciesDto> saveTreeSpecies(
            @RequestBody TreeSpeciesDto treeSpeciesDto) {
        TreeSpeciesDto savedTreeSpecies = treeSpeciesService.saveTreeSpecies(treeSpeciesDto);
        return new ResponseEntity<>(savedTreeSpecies, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTreeSpecies(@PathVariable String id) {
        treeSpeciesService.deleteTreeSpecies(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<TreeSpeciesDto> getTreeSpeciesByName(@PathVariable String name) {
        TreeSpeciesDto treeSpeciesDto = treeSpeciesService.getTreeSpeciesByName(name);
        return new ResponseEntity<>(treeSpeciesDto, HttpStatus.OK);
    }

    @GetMapping("/scientific-name/{scientificName}")
    public ResponseEntity<TreeSpeciesDto> getTreeSpeciesByScientificName(
            @PathVariable String scientificName) {
        TreeSpeciesDto treeSpeciesDto =
                treeSpeciesService.getTreeSpeciesByScientificName(scientificName);
        return new ResponseEntity<>(treeSpeciesDto, HttpStatus.OK);
    }

    @GetMapping("/language/{language}")
    public ResponseEntity<List<TreeSpeciesDto>> getTreeSpeciesByLanguage(
            @PathVariable String language) {
        LanguageDto languageDto = new LanguageDto();
        List<TreeSpeciesDto> treeSpeciesList =
                treeSpeciesService.getTreeSpeciesByLanguage(languageDto);
        return new ResponseEntity<>(treeSpeciesList, HttpStatus.OK);
    }

    @DeleteMapping("/name/{name}")
    public ResponseEntity<Void> deleteTreeSpeciesByName(@PathVariable String name) {
        treeSpeciesService.deleteTreeSpeciesByName(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

