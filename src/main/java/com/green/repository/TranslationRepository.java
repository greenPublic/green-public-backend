package com.green.repository;

import com.green.entity.translation.Language;
import com.green.entity.translation.Translation;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranslationRepository extends MongoRepository<Translation, UUID> {
    Translation save(Translation translation);

    Optional<Translation> findById(UUID id);

    List<Translation> findAll();

    void deleteById(UUID id);

    void delete(Translation translation);
}