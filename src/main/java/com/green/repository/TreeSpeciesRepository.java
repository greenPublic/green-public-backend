package com.green.repository;

import com.green.entity.translation.Language;
import com.green.entity.tree.TreeSpecies;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeSpeciesRepository extends MongoRepository<TreeSpecies, String> {

    TreeSpecies findByName(String name);

    TreeSpecies findByScientificName(String scientificName);

    List<TreeSpecies> findByLanguage(String language);

    void deleteByName(String name);
}

