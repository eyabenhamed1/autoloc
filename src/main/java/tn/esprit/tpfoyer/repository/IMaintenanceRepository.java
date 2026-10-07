package tn.esprit.tpfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.tpfoyer.entities.Maintenance;

public interface IMaintenanceRepository extends JpaRepository<Maintenance, Long> { }