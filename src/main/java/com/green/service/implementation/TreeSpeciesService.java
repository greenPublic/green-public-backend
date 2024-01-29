package com.green.service.implementation;


import com.green.dto.language.LanguageDto;
import com.green.dto.tree.TreeSpeciesDto;
import com.green.entity.translation.Language;
import com.green.entity.tree.TreeSpecies;
import com.green.repository.TreeSpeciesRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreeSpeciesService {

    private final TreeSpeciesRepository treeSpeciesRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TreeSpeciesService(TreeSpeciesRepository treeSpeciesRepository,
                              ModelMapper modelMapper) {
        this.treeSpeciesRepository = treeSpeciesRepository;
        this.modelMapper = modelMapper;
    }

    public List<TreeSpeciesDto> getAllTreeSpecies() {
        List<TreeSpecies> treeSpeciesList = treeSpeciesRepository.findAll();
        return treeSpeciesList.stream()
                .map(treeSpecies -> modelMapper.map(treeSpecies, TreeSpeciesDto.class))
                .collect(Collectors.toList());
    }

    public Optional<TreeSpeciesDto> getTreeSpeciesById(String id) {
        Optional<TreeSpecies> treeSpeciesOptional = treeSpeciesRepository.findById(id);
        return treeSpeciesOptional.map(
                treeSpecies -> modelMapper.map(treeSpecies, TreeSpeciesDto.class));
    }

    public TreeSpeciesDto saveTreeSpecies(TreeSpeciesDto treeSpeciesDto) {
        TreeSpecies treeSpecies = modelMapper.map(treeSpeciesDto, TreeSpecies.class);
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

    public List<TreeSpeciesDto> getTreeSpeciesByLanguage(LanguageDto languageDto) {
        Language language = modelMapper.map(languageDto, Language.class);
        List<TreeSpecies> treeSpeciesList = treeSpeciesRepository.findByLanguage(language);
        return treeSpeciesList.stream()
                .map(treeSpecies -> modelMapper.map(treeSpecies, TreeSpeciesDto.class))
                .collect(Collectors.toList());
    }

    public void deleteTreeSpeciesByName(String name) {
        treeSpeciesRepository.deleteByName(name);
    }
}

