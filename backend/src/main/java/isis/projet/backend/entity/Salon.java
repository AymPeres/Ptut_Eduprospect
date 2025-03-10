package isis.projet.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "inscriptions")
@Entity
@Table(name = "salons")
public class Salon {
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
    private String ville;

    @Column(nullable = false)
    @NonNull
    private Integer annee;

    @OneToMany(mappedBy = "salon", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore  // Évite la boucle infinie dans les réponses JSON
    private List<Inscription> inscriptions;
}
