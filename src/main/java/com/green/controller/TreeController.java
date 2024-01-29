package com.green.controller;

import com.green.entity.tree.TreeDocument;
import com.green.service.implementation.TreeService;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
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
@RequestMapping("/api/trees")
public class TreeController {

    private final TreeService treeService;

    @Autowired
    public TreeController(TreeService treeService) {
        this.treeService = treeService;
    }

    @PostMapping
    public ResponseEntity<TreeDocument> saveTree(@RequestBody TreeDocument treeDocument) {
        TreeDocument savedTree = treeService.save(treeDocument);
        return new ResponseEntity<>(savedTree, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreeDocument> getTreeById(@PathVariable UUID id) {
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
    public ResponseEntity<Void> deleteTreeById(@PathVariable UUID id) {
        treeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTree(@RequestBody TreeDocument treeDocument) {
        treeService.delete(treeDocument);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

