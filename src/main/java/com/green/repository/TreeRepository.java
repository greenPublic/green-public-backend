package com.green.repository;

import com.green.entity.translation.Language;
import com.green.entity.tree.TreeDocument;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository extends MongoRepository<TreeDocument, UUID> {
    Language save(Language language);

    Optional<TreeDocument> findById(UUID id);

    List<TreeDocument> findAll();

    void deleteById(UUID id);

    void delete(TreeDocument treeDocument);
}