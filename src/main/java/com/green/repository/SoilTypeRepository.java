package com.green.repository;

import com.green.entity.tree.SoilType;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoilTypeRepository extends MongoRepository<SoilType, String> {
    SoilType findByName(String name);

    List<SoilType> findAllByLanguage(String language);

    List<SoilType> findByNameContaining(String partialName);

    List<SoilType> findByDescription(String description);

    void deleteByName(String name);
}

