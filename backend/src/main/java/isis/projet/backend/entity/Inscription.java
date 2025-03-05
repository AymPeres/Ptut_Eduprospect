package isis.projet.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "inscriptions")
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @NotEmpty
    @Column(nullable = false)
    @NonNull
    private String nom;

    @NotBlank
    @NotEmpty
    @Column(nullable = false)
    @NonNull
    private String prenom;

    @NotBlank
    @NotEmpty
    @Column(nullable = false)
    @NonNull
    private String formation;

    @NotBlank
    @NotEmpty
    @Column(nullable = false)
    @NonNull
    private String ville;

    @NotBlank
    @NotEmpty
    @Column(name = "code_postal", nullable = false)
    @NonNull
    private String codePostal;

    @NotBlank
    @NotEmpty
    @Column(nullable = false)
    @NonNull
    private String email;

    @NotBlank
    @NotEmpty
    @Column(nullable = false)
    @NonNull
    private String telephone;

    @NotBlank
    @NotEmpty
    @Column(nullable = false)
    @NonNull
    private String sexe;

    @NotBlank
    @NotEmpty
    @Column(nullable = false)
    @NonNull
    private String statut;

    @NotBlank
    @NotEmpty
    @Column(nullable = false)
    @NonNull
    private String interet;

    @NotBlank
    @NotEmpty
    @Column(name = "origine_contact", nullable = false)
    @NonNull
    private String origineContact;

    @ManyToOne
    @JoinColumn(name = "salon_id", nullable = false)
    @NonNull
    private Salon salon;
}
