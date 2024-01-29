package com.green.controller;

import com.green.dto.TreeDto;
import com.green.entity.tree.TreeDocument;
import com.green.service.implementation.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trees")
public class TreeController {

    private final TreeService treeService;

    @Autowired
    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    @PostMapping
    public ResponseEntity<TreeDto> saveTree(@RequestBody TreeDto treeDto, String lang) {
        TreeDto savedTree = treeService.save(treeDto, lang);
        return new ResponseEntity<>(savedTree, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreeDocument> getTreeById(@PathVariable String id) {
        Optional<TreeDocument> treeOptional = treeService.findById(id);
        return treeOptional.map(tree -> new ResponseEntity<>(tree, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<TreeDocument>> getAllTrees() {
        List<TreeDocument> trees = treeService.findAll();
        return new ResponseEntity<>(trees, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTreeById(@PathVariable String id) {
        treeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTree(@RequestBody TreeDocument treeDocument) {
        treeService.delete(treeDocument);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

