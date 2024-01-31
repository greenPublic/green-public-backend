package com.green.service.abstraction.tree;

import com.green.dto.tree.TreeDto;
import com.green.entity.tree.TreeDocument;
import java.util.List;
import java.util.Optional;

public interface TreeService {

    TreeDto save(TreeDto treeDto, String lang);

    Optional<TreeDocument> findById(String id);

    List<TreeDocument> findAll(String lang);

    void deleteById(String id);

    void delete(TreeDocument treeDocument);
}
