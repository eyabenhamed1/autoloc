package tn.esprit.tpfoyer.services;

import org.springframework.stereotype.Component;
import tn.esprit.tpfoyer.entities.Vehicule;

@Component
public class VehiculeValidator {

    public void valider(Vehicule vehicule) {
        if (vehicule.getTarifJournalier() == null
                || vehicule.getTarifJournalier().signum() <= 0) {
            throw new IllegalArgumentException("Le tarif doit être positif");
        }
    }
}