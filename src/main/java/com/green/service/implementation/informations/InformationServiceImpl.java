package com.green.service.implementation.informations;

import com.green.dto.informations.InformationDto;
import com.green.entity.informations.Information;
import com.green.entity.translation.Language;
import com.green.repository.InformationRepository;
import com.green.repository.LanguageRepository;
import com.green.service.abstraction.informations.InformationService;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InformationServiceImpl implements InformationService {

    private final InformationRepository informationRepository;
    private final ModelMapper modelMapper;
    private final LanguageRepository languageRepository;


    public List<InformationDto> getAllInformation(String lang) {
        Language byLanguageAbbr = languageRepository.findByLanguageAbbr(lang);
        String languageAbbrId = byLanguageAbbr.getId();

        List<Information> informationList = informationRepository.findByLanguage(languageAbbrId);
        return informationList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public Optional<InformationDto> getInformationById(String id) {
        return informationRepository.findById(id)
                .map(this::convertToDto);
    }

    public InformationDto createInformation(InformationDto informationDto, String lang) {
        Information information = convertToEntity(informationDto);

        Language byLanguageAbbr = languageRepository.findByLanguageAbbr(lang);
        information.setLanguage(byLanguageAbbr);
        Information savedInformation = informationRepository.save(information);
        return convertToDto(savedInformation);
    }

    public InformationDto updateInformation(InformationDto informationDto) {
        Information information = convertToEntity(informationDto);
        Information updatedInformation = informationRepository.save(information);
        return convertToDto(updatedInformation);
    }

    public void deleteInformation(String id) {
        informationRepository.deleteById(id);
    }

    public InformationDto getInformationByHeader(String header) {
        Information information = informationRepository.findByHeader(header);
        return convertToDto(information);
    }

    public List<InformationDto> getInformationByLanguage(String language) {
        List<Information> informationList = informationRepository.findByLanguage(language);
        return informationList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public List<InformationDto> getInformationByDescriptionContaining(String keyword) {
        List<Information> informationList =
                informationRepository.findByDescriptionContaining(keyword);
        return informationList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public void deleteInformationByHeader(String header) {
        informationRepository.deleteByHeader(header);
    }

    private InformationDto convertToDto(Information information) {
        return modelMapper.map(information, InformationDto.class);
    }

    private Information convertToEntity(InformationDto informationDto) {
        return modelMapper.map(informationDto, Information.class);
    }
}
