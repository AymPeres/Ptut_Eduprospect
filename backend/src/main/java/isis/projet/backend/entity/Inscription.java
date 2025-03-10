package isis.projet.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "salon")
@Entity
@Table(name = "inscriptions")
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(nullable = false)
    @NonNull
    private String nom;

    @NotBlank
    @Column(nullable = false)
    @NonNull
    private String prenom;

    @NotBlank
    @Column(nullable = false)
    @NonNull
    private String formation;

    @NotBlank
    @Column(nullable = false)
    @NonNull
    private String ville;

    @NotBlank
    @Column(name = "code_postal", nullable = false)
    @NonNull
    private String codePostal;

    @NotBlank
    @Column(nullable = false)
    @NonNull
    private String email;

    @NotBlank
    @Column(nullable = false)
    @NonNull
    private String telephone;

    @NotBlank
    @Column(nullable = false)
    @NonNull
    private String sexe;

    @NotBlank
    @Column(nullable = false)
    @NonNull
    private String statut;

    @NotBlank
    @Column(nullable = false)
    @NonNull
    private String interet;

    @NotBlank
    @Column(name = "origine_contact", nullable = false)
    @NonNull
    private String origineContact;

    @ManyToOne
    @JoinColumn(name = "salon_id", nullable = false)
    @NotNull
    @JsonIgnore  // Évite la boucle infinie en JSON
    @NonNull
    private Salon salon;
}
