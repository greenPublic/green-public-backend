package com.green.controller.stores;

import com.green.dto.stores.RetailStoreDto;
import com.green.service.implementation.stores.RetailStoreService;
import java.util.List;
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
@RequestMapping("/api/retailStores")
public class RetailStoreController {

    private final RetailStoreService retailStoreService;

    @Autowired
    public RetailStoreController(RetailStoreService retailStoreService) {
        this.retailStoreService = retailStoreService;
    }

    @PostMapping
    public ResponseEntity<RetailStoreDto> createRetailStore(
            @RequestBody RetailStoreDto retailStoreDto, @RequestHeader String lang) {
        RetailStoreDto createdRetailStore = retailStoreService.createRetailStore(retailStoreDto, lang);
        return new ResponseEntity<>(createdRetailStore, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RetailStoreDto> getRetailStoreById(@PathVariable String id) {
        RetailStoreDto retailStoreDto = retailStoreService.getRetailStoreById(id);
        if (retailStoreDto != null) {
            return new ResponseEntity<>(retailStoreDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<RetailStoreDto>> getAllRetailStores(@RequestHeader String lang) {
        List<RetailStoreDto> retailStores = retailStoreService.getAllRetailStores(lang);
        return new ResponseEntity<>(retailStores, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RetailStoreDto> updateRetailStore(@PathVariable String id, @RequestBody
    RetailStoreDto retailStoreDto) {
        RetailStoreDto updatedRetailStore =
                retailStoreService.updateRetailStore(id, retailStoreDto);
        if (updatedRetailStore != null) {
            return new ResponseEntity<>(updatedRetailStore, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRetailStoreById(@PathVariable String id) {
        retailStoreService.deleteRetailStoreById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
