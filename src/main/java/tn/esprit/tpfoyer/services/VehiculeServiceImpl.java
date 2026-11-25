package tn.esprit.tpfoyer.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entities.Vehicule;
import tn.esprit.tpfoyer.repository.IVehiculeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final IVehiculeRepository vehiculeRepository;
    private final VehiculeValidator vehiculeValidator;
    private final JournalisationService journalisationService;

    @Override
    public Vehicule ajouter(Vehicule vehicule) {
        vehiculeValidator.valider(vehicule);
        journalisationService.journaliser("Ajout du véhicule " + vehicule.getImmatriculation());
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> listerTous() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule trouverParId(Long id) {
        return vehiculeRepository.findById(id).orElseThrow();
    }

    @Override
    public void supprimer(Long id) {
        vehiculeRepository.deleteById(id);
    }
}