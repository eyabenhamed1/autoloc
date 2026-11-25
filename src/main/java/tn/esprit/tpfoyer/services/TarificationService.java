package tn.esprit.tpfoyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.strategies.StrategieTarification;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TarificationService {

    private final Map<String, StrategieTarification> strategies;

    public double calculer(String type, double tarifJournalier, int jours) {
        if (tarifJournalier <= 0 || jours <= 0) {
            throw new IllegalArgumentException("Le tarif et le nombre de jours doivent être positifs");
        }
        StrategieTarification strategie = strategies.get(type);
        if (strategie == null) {
            throw new IllegalArgumentException("Type de tarif inconnu : " + type);
        }
        return strategie.calculer(tarifJournalier, jours);
    }
}