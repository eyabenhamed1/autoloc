package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entities.Paiement;

public interface IPaiementRepository extends JpaRepository<Paiement, Long> { }