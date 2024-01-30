package com.green.service.implementation.informations;

import com.green.entity.informations.Information;
import com.green.entity.translation.Language;
import com.green.repository.InformationRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InformationService {

    private final InformationRepository informationRepository;

    public List<Information> getAllInformation() {
        return informationRepository.findAll();
    }

    public Optional<Information> getInformationById(String id) {
        return informationRepository.findById(id);
    }

    public Information createInformation(Information information) {
        return informationRepository.save(information);
    }

    public Information updateInformation(Information information) {
        return informationRepository.save(information);
    }

    public void deleteInformation(String id) {
        informationRepository.deleteById(id);
    }

    public Information getInformationByHeader(String header) {
        return informationRepository.findByHeader(header);
    }

    public List<Information> getInformationByLanguage(Language language) {
        return informationRepository.findByLanguage(language);
    }

    public List<Information> getInformationByDescriptionContaining(String keyword) {
        return informationRepository.findByDescriptionContaining(keyword);
    }

    public void deleteInformationByHeader(String header) {
        informationRepository.deleteByHeader(header);
    }
}

