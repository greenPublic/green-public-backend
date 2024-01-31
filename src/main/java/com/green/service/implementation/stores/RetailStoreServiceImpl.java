package com.green.service.implementation.stores;

import com.green.dto.stores.RetailStoreDto;
import com.green.entity.stores.RetailStore;
import com.green.entity.translation.Language;
import com.green.repository.LanguageRepository;
import com.green.repository.RetailStoreRepository;
import com.green.service.abstraction.stores.RetailStoreService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RetailStoreServiceImpl implements RetailStoreService {

    private final RetailStoreRepository retailStoreRepository;
    private final LanguageRepository languageRepository;
    private final ModelMapper modelMapper;


    public RetailStoreDto createRetailStore(RetailStoreDto retailStoreDto, String lang) {
        RetailStore retailStore = modelMapper.map(retailStoreDto, RetailStore.class);

        Language byLanguageAbbr = languageRepository.findByLanguageAbbr(lang);
        String languageAbbrId = byLanguageAbbr.getId();

        RetailStore savedRetailStore = retailStoreRepository.save(retailStore);
        return modelMapper.map(savedRetailStore, RetailStoreDto.class);
    }

    public RetailStoreDto getRetailStoreById(String id) {
        RetailStore retailStore = retailStoreRepository.findById(id).get();
        return modelMapper.map(retailStore, RetailStoreDto.class);
    }

    public List<RetailStoreDto> getAllRetailStores(String lang) {
        List<RetailStore> retailStores = retailStoreRepository.findAll();

        Language byLanguageAbbr = languageRepository.findByLanguageAbbr(lang);
        String languageAbbrId = byLanguageAbbr.getId();

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

