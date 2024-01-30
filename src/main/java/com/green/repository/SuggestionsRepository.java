package com.green.repository;

import com.green.entity.suggestions.Suggestions;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuggestionsRepository extends MongoRepository<Suggestions, String> {

    List<Suggestions> findByTitle(String title);

    List<Suggestions> findByCreatedBy(String createdBy);

    List<Suggestions> findByCreatedAtAfter(LocalDateTime date);

    void deleteByTitle(String title);

    void deleteByCreatedBy(String createdBy);

    void deleteByCreatedAtAfter(LocalDateTime date);
}

