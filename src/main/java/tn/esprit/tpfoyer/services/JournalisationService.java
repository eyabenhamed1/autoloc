package tn.esprit.tpfoyer.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JournalisationService {
    public void journaliser(String message) {
        log.info(message);
    }
}