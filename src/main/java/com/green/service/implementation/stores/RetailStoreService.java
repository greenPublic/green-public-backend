package com.green.service.implementation.stores;

import com.green.dto.stores.RetailStoreDto;
import com.green.entity.stores.RetailStore;
import com.green.repository.RetailStoreRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RetailStoreService {

    private final RetailStoreRepository retailStoreRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public RetailStoreService(RetailStoreRepository retailStoreRepository,
                              ModelMapper modelMapper) {
        this.retailStoreRepository = retailStoreRepository;
        this.modelMapper = modelMapper;
    }

    public RetailStoreDto createRetailStore(RetailStoreDto retailStoreDto) {
        RetailStore retailStore = modelMapper.map(retailStoreDto, RetailStore.class);
        RetailStore savedRetailStore = retailStoreRepository.save(retailStore);
        return modelMapper.map(savedRetailStore, RetailStoreDto.class);
    }

    public RetailStoreDto getRetailStoreById(String id) {
        RetailStore retailStore = retailStoreRepository.findById(id).get();
        return modelMapper.map(retailStore, RetailStoreDto.class);
    }

    public List<RetailStoreDto> getAllRetailStores() {
        List<RetailStore> retailStores = retailStoreRepository.findAll();
        return retailStores.stream()
                .map(retailStore -> modelMapper.map(retailStore, RetailStoreDto.class))
                .collect(Collectors.toList());
    }

    public RetailStoreDto updateRetailStore(String id, RetailStoreDto retailStoreDto) {
        RetailStore existingRetailStore = retailStoreRepository.findById(id).get();
        if (existingRetailStore != null) {
            modelMapper.map(retailStoreDto, existingRetailStore);
            RetailStore updatedRetailStore = retailStoreRepository.save(existingRetailStore);
            return modelMapper.map(updatedRetailStore, RetailStoreDto.class);
        }
        return null;
    }

    public void deleteRetailStoreById(String id) {
        retailStoreRepository.deleteById(id);
    }
}

