package com.green.service.implementation.tree;


import com.green.dto.language.LanguageDto;
import com.green.dto.tree.TreeSpeciesDto;
import com.green.entity.translation.Language;
import com.green.entity.tree.TreeSpecies;
import com.green.repository.LanguageRepository;
import com.green.repository.TreeSpeciesRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TreeSpeciesService {

    private final TreeSpeciesRepository treeSpeciesRepository;
    private final ModelMapper modelMapper;
    private final LanguageRepository languageRepository;


    public List<TreeSpeciesDto> getAllTreeSpecies(String lang) {
        Language byLanguageAbbr = languageRepository.findByLanguageAbbr(lang);
        String languageAbbrId = byLanguageAbbr.getId();

        List<TreeSpecies> treeSpeciesList = treeSpeciesRepository.findByLanguage(languageAbbrId);
        return treeSpeciesList.stream()
                .map(treeSpecies -> modelMapper.map(treeSpecies, TreeSpeciesDto.class))
                .collect(Collectors.toList());
    }

    public Optional<TreeSpeciesDto> getTreeSpeciesById(String id) {
        Optional<TreeSpecies> treeSpeciesOptional = treeSpeciesRepository.findById(id);
        return treeSpeciesOptional.map(
                treeSpecies -> modelMapper.map(treeSpecies, TreeSpeciesDto.class));
    }

    public TreeSpeciesDto saveTreeSpecies(TreeSpeciesDto treeSpeciesDto, String lang) {

        Language byLanguageAbbr = languageRepository.findByLanguageAbbr(lang);
        String languageAbbrId = byLanguageAbbr.getId();

        TreeSpecies treeSpecies = modelMapper.map(treeSpeciesDto, TreeSpecies.class);
        treeSpecies.setLanguage(byLanguageAbbr);
        TreeSpecies savedTreeSpecies = treeSpeciesRepository.save(treeSpecies);
        return modelMapper.map(savedTreeSpecies, TreeSpeciesDto.class);
    }

    public void deleteTreeSpecies(String id) {
        treeSpeciesRepository.deleteById(id);
    }

    public TreeSpeciesDto getTreeSpeciesByName(String name) {
        TreeSpecies treeSpecies = treeSpeciesRepository.findByName(name);
        return modelMapper.map(treeSpecies, TreeSpeciesDto.class);
    }

    public TreeSpeciesDto getTreeSpeciesByScientificName(String scientificName) {
        TreeSpecies treeSpecies = treeSpeciesRepository.findByScientificName(scientificName);
        return modelMapper.map(treeSpecies, TreeSpeciesDto.class);
    }

    public void deleteTreeSpeciesByName(String name) {
        treeSpeciesRepository.deleteByName(name);
    }
}

