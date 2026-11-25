package tn.esprit.tpfoyer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import tn.esprit.tpfoyer.enums.CategorieVehicule;
import tn.esprit.tpfoyer.enums.StatutVehicule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Vehicule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;
    private String immatriculation;
    private String marque;
    private String modele;

    @Enumerated(EnumType.STRING)
    private CategorieVehicule categorie;

    private BigDecimal tarifJournalier;

    @Enumerated(EnumType.STRING)
    private StatutVehicule statut;

    // N vehicules -> 1 agence
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agence_id")
    private Agence agence;

    // N <-> N equipements (cote proprietaire : @JoinTable)
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "vehicule_equipement",
            joinColumns = @JoinColumn(name = "vehicule_id"),
            inverseJoinColumns = @JoinColumn(name = "equipement_id"))
    @ToString.Exclude
    private List<Equipement> equipements = new ArrayList<>();

    // 1 vehicule -> N maintenances
    @JsonIgnore
    @OneToMany(mappedBy = "vehicule", cascade = CascadeType.PERSIST)
    @ToString.Exclude
    private List<Maintenance> maintenances = new ArrayList<>();

    // 1 vehicule -> N reservations
    @JsonIgnore
    @OneToMany(mappedBy = "vehicule", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Reservation> reservations = new ArrayList<>();
}