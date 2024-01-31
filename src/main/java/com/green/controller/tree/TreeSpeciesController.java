package com.green.controller.tree;

import com.green.dto.tree.TreeSpeciesDto;
import com.green.service.implementation.tree.TreeSpeciesServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tree-species")
public class TreeSpeciesController {

    private final TreeSpeciesServiceImpl treeSpeciesServiceImpl;

    @Autowired
    public TreeSpeciesController(TreeSpeciesServiceImpl treeSpeciesServiceImpl) {
        this.treeSpeciesServiceImpl = treeSpeciesServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<TreeSpeciesDto>> getAllTreeSpecies(@RequestHeader String lang) {
        List<TreeSpeciesDto> treeSpeciesList = treeSpeciesServiceImpl.getAllTreeSpecies(lang);
        return new ResponseEntity<>(treeSpeciesList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreeSpeciesDto> getTreeSpeciesById(@PathVariable String id) {
        return treeSpeciesServiceImpl.getTreeSpeciesById(id)
                .map(treeSpeciesDto -> new ResponseEntity<>(treeSpeciesDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<TreeSpeciesDto> saveTreeSpecies(
            @RequestBody TreeSpeciesDto treeSpeciesDto, @RequestHeader String lang) {
        TreeSpeciesDto savedTreeSpecies = treeSpeciesServiceImpl.saveTreeSpecies(treeSpeciesDto, lang);
        return new ResponseEntity<>(savedTreeSpecies, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTreeSpecies(@PathVariable String id) {
        treeSpeciesServiceImpl.deleteTreeSpecies(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<TreeSpeciesDto> getTreeSpeciesByName(@PathVariable String name) {
        TreeSpeciesDto treeSpeciesDto = treeSpeciesServiceImpl.getTreeSpeciesByName(name);
        return new ResponseEntity<>(treeSpeciesDto, HttpStatus.OK);
    }

    @GetMapping("/scientific-name/{scientificName}")
    public ResponseEntity<TreeSpeciesDto> getTreeSpeciesByScientificName(
            @PathVariable String scientificName) {
        TreeSpeciesDto treeSpeciesDto =
                treeSpeciesServiceImpl.getTreeSpeciesByScientificName(scientificName);
        return new ResponseEntity<>(treeSpeciesDto, HttpStatus.OK);
    }

    @DeleteMapping("/name/{name}")
    public ResponseEntity<Void> deleteTreeSpeciesByName(@PathVariable String name) {
        treeSpeciesServiceImpl.deleteTreeSpeciesByName(name);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

