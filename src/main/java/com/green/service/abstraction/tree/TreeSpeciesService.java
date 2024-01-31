package com.green.service.abstraction.tree;


import com.green.dto.tree.TreeSpeciesDto;
import java.util.List;
import java.util.Optional;

public interface TreeSpeciesService {

    List<TreeSpeciesDto> getAllTreeSpecies(String lang);

    Optional<TreeSpeciesDto> getTreeSpeciesById(String id);

    TreeSpeciesDto saveTreeSpecies(TreeSpeciesDto treeSpeciesDto, String lang);

    void deleteTreeSpecies(String id);

    TreeSpeciesDto getTreeSpeciesByName(String name);

    TreeSpeciesDto getTreeSpeciesByScientificName(String scientificName);

    void deleteTreeSpeciesByName(String name);
}

