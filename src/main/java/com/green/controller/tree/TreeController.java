package com.green.controller.tree;

import com.green.dto.tree.TreeDto;
import com.green.entity.tree.TreeDocument;
import com.green.service.implementation.tree.TreeServiceImpl;
import java.util.List;
import java.util.Optional;
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
@RequestMapping("/api/trees")
public class TreeController {

    private final TreeServiceImpl treeServiceImpl;

    @Autowired
    public TreeController(TreeServiceImpl treeServiceImpl) {
        this.treeServiceImpl = treeServiceImpl;
    }

    @PostMapping
    public ResponseEntity<TreeDto> saveTree(@RequestBody TreeDto treeDto, @RequestHeader String lang) {
        TreeDto savedTree = treeServiceImpl.save(treeDto, lang);
        return new ResponseEntity<>(savedTree, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreeDocument> getTreeById(@PathVariable String id) {
        Optional<TreeDocument> treeOptional = treeServiceImpl.findById(id);
        return treeOptional.map(tree -> new ResponseEntity<>(tree, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public ResponseEntity<List<TreeDocument>> getAllTrees(@RequestHeader String lang) {
        List<TreeDocument> trees = treeServiceImpl.findAll(lang);
        return new ResponseEntity<>(trees, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTreeById(@PathVariable String id) {
        treeServiceImpl.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteTree(@RequestBody TreeDocument treeDocument) {
        treeServiceImpl.delete(treeDocument);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

