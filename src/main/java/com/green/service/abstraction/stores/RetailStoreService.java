package com.green.service.abstraction.stores;

import com.green.dto.stores.RetailStoreDto;
import java.util.List;

public interface RetailStoreService {

    RetailStoreDto createRetailStore(RetailStoreDto retailStoreDto, String lang);

    RetailStoreDto getRetailStoreById(String id);

    List<RetailStoreDto> getAllRetailStores(String lang);

    RetailStoreDto updateRetailStore(String id, RetailStoreDto retailStoreDto);

    void deleteRetailStoreById(String id);
}

