package tn.esprit.tpfoyer.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entities.Vehicule;
import tn.esprit.tpfoyer.services.IVehiculeService;

import java.util.List;

@RestController
@RequestMapping("/vehicules")
@RequiredArgsConstructor
public class VehiculeController {

    private final IVehiculeService vehiculeService; // injection par constructeur

    @PostMapping
    public Vehicule ajouter(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouter(vehicule);
    }

    @GetMapping
    public List<Vehicule> lister() {
        return vehiculeService.listerTous();
    }

    @GetMapping("/{id}")
    public Vehicule trouver(@PathVariable("id") Long id) {
        return vehiculeService.trouverParId(id);
    }

    @DeleteMapping("/{id}")
    public void supprimer(@PathVariable("id") Long id) {
        vehiculeService.supprimer(id);
    }
}