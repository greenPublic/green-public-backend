package com.green.repository;

import com.green.entity.informations.Information;
import com.green.entity.translation.Language;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InformationRepository extends MongoRepository<Information, String> {

    Information findByHeader(String header);

    List<Information> findByLanguage(Language language);

    List<Information> findByDescriptionContaining(String keyword);

    void deleteByHeader(String header);
}

