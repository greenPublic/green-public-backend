package com.green.repository;

import com.green.entity.translation.Language;
import com.green.entity.tree.TreeDocument;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.mongodb.repository .MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreeRepository extends MongoRepository<TreeDocument, String> {
    Language save(Language language);

    Optional<TreeDocument> findById(String id);

    List<TreeDocument> findAll();

    void deleteById(String id);

    void delete(TreeDocument treeDocument);
}