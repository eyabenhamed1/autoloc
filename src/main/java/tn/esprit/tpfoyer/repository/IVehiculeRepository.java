package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entities.Vehicule;

public interface IVehiculeRepository extends JpaRepository<Vehicule, Long> { }