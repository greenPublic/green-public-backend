package com.green.repository;

import com.green.entity.translation.Language;
import com.green.entity.tree.WateringFrequency;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WateringFrequencyRepository extends MongoRepository<WateringFrequency, String> {

    WateringFrequency save(WateringFrequency wateringFrequency);

    List<WateringFrequency> findAll();

    List<WateringFrequency> findByFrequencyName(String frequencyName);

    List<WateringFrequency> findByLanguage_Id(String language);

    void deleteById(String id);

    void delete(WateringFrequency wateringFrequency);

    void deleteAll();

}

