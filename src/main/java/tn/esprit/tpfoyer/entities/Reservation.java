package tn.esprit.tpfoyer.entities;

import tn.esprit.tpfoyer.enums.StatutReservation;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private LocalDate dateDebut;
    private LocalDate dateFin;

    @Enumerated(EnumType.STRING)
    private StatutReservation statut;

    // N reservations -> 1 client
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    // N reservations -> 1 vehicule
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicule_id")
    private Vehicule vehicule;

    // 1 reservation <-> 1 contrat (cote inverse)
    @OneToOne(mappedBy = "reservation")
    @ToString.Exclude
    private Contrat contrat;
}