package com.green.service.implementation;

import com.green.entity.translation.Translation;
import com.green.repository.TranslationRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TranslationService {

    private final TranslationRepository translationRepository;

    public Translation saveTranslation(Translation translation) {
        return translationRepository.save(translation);
    }

    public Optional<Translation> findTranslationById(UUID id) {
        return translationRepository.findById(id);
    }

    public List<Translation> findAllTranslations() {
        return translationRepository.findAll();
    }

    public void deleteTranslationById(UUID id) {
        translationRepository.deleteById(id);
    }

    public void deleteTranslation(Translation translation) {
        translationRepository.delete(translation);
    }

}
