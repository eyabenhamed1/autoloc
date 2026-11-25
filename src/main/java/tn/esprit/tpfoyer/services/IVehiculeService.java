package tn.esprit.tpfoyer.services;

import tn.esprit.tpfoyer.entities.Vehicule;
import java.util.List;

public interface IVehiculeService {
    Vehicule ajouter(Vehicule vehicule);
    List<Vehicule> listerTous();
    Vehicule trouverParId(Long id);
    void supprimer(Long id);
}