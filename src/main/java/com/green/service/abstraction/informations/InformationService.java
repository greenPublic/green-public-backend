package com.green.service.abstraction.informations;

import com.green.dto.informations.InformationDto;
import com.green.entity.informations.Information;
import com.green.entity.translation.Language;
import com.green.repository.InformationRepository;
import com.green.repository.LanguageRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface InformationService {

    List<InformationDto> getAllInformation(String lang);

    Optional<InformationDto> getInformationById(String id);

    InformationDto createInformation(InformationDto informationDto, String lang);

    InformationDto updateInformation(InformationDto informationDto);

    void deleteInformation(String id);

    InformationDto getInformationByHeader(String header);

    List<InformationDto> getInformationByLanguage(String language);

    List<InformationDto> getInformationByDescriptionContaining(String keyword);

    void deleteInformationByHeader(String header);
}

