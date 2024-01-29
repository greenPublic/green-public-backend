package com.green.service.implementation;

import com.green.dto.TreeDto;
import com.green.entity.translation.Language;
import com.green.entity.tree.TreeDocument;
import com.green.repository.LanguageRepository;
import com.green.repository.TreeRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TreeService {

    private final TreeRepository treeRepository;
    private final LanguageRepository languageRepository;
    private final ModelMapper modelMapper;

    public TreeDto save(TreeDto treeDto, String lang) {

        TreeDocument treeDocument = modelMapper.map(treeDto, TreeDocument.class);
        Language byLanguageAbbr = languageRepository.findByLanguageAbbr(lang);

        treeDocument.setLanguage(byLanguageAbbr);

        TreeDocument saved = treeRepository.save(treeDocument);
        return modelMapper.map(saved, TreeDto.class);
    }

    public Optional<TreeDocument> findById(String id) {
        return treeRepository.findById(id);
    }

    public List<TreeDocument> findAll() {
        return treeRepository.findAll();
    }

    public void deleteById(String id) {
        treeRepository.deleteById(id);
    }

    public void delete(TreeDocument treeDocument) {
        treeRepository.delete(treeDocument);
    }
}
