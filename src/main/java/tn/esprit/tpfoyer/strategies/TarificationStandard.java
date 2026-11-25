package tn.esprit.tpfoyer.strategies;

import org.springframework.stereotype.Component;

@Component("STANDARD")
public class TarificationStandard implements StrategieTarification {
    public double calculer(double tarifJournalier, int jours) {
        return tarifJournalier * jours;
    }
}