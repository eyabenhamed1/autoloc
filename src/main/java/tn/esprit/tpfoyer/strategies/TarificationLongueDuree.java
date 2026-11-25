package tn.esprit.tpfoyer.strategies;

import org.springframework.stereotype.Component;

@Component("LONGUE_DUREE")
public class TarificationLongueDuree implements StrategieTarification {
    public double calculer(double tarifJournalier, int jours) {
        return tarifJournalier * jours * 0.80;
    }
}