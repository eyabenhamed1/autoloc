package tn.esprit.tpfoyer.entities;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Contrat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContrat;
    private LocalDate dateSignature;
    private BigDecimal montantTotal;
    private boolean valide;

    // 1 contrat <-> 1 reservation (cote proprietaire)
    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    // 1 contrat -> N paiements (cascade ALL)
    @OneToMany(mappedBy = "contrat", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Paiement> paiements = new ArrayList<>();
}