package tn.esprit.tpfoyer.strategies;

import org.springframework.stereotype.Component;

@Component("ENTREPRISE")
public class TarificationEntreprise implements StrategieTarification {
    public double calculer(double tarifJournalier, int jours) {
        return tarifJournalier * jours * 0.85;
    }
}