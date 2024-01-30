package com.green.repository;

import com.green.entity.stores.RetailStore;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetailStoreRepository extends MongoRepository<RetailStore, String> {

    // Create
    RetailStore save(RetailStore retailStore);

    List<RetailStore> findAll();

    void deleteById(String id);

    void delete(RetailStore retailStore);

    // Additional custom query methods (example)
    List<RetailStore> findByName(String name);

    List<RetailStore> findByAddress(String address);
    // Add more custom query methods as needed

}

