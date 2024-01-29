package com.green.service.implementation;

import com.green.entity.tree.TreeDocument;
import com.green.repository.TreeRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TreeService {

    private final TreeRepository treeRepository;

    public TreeDocument save(TreeDocument treeDocument) {
        return treeRepository.save(treeDocument);
    }

    public Optional<TreeDocument> findById(UUID id) {
        return treeRepository.findById(id);
    }

    public List<TreeDocument> findAll() {
        return treeRepository.findAll();
    }

    public void deleteById(UUID id) {
        treeRepository.deleteById(id);
    }

    public void delete(TreeDocument treeDocument) {
        treeRepository.delete(treeDocument);
    }
}
