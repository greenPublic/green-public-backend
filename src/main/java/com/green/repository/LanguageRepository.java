package com.green.repository;

import com.green.entity.translation.Language;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends MongoRepository<Language, UUID> {
    Language save(Language language);

    Optional<Language> findById(UUID id);

    List<Language> findAll();

    void deleteById(UUID id);

    void delete(Language language);
}