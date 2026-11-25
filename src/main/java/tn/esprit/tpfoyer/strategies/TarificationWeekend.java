package tn.esprit.tpfoyer.strategies;

import org.springframework.stereotype.Component;

@Component("WEEKEND")
public class TarificationWeekend implements StrategieTarification {
    public double calculer(double tarifJournalier, int jours) {
        return tarifJournalier * jours * 0.90;
    }
}