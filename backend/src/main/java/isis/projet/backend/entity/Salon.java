package isis.projet.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "salons")
public class Salon {
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
    private String ville;

    @Column(nullable = false)
    @NonNull
    private Integer annee;

    @OneToMany(mappedBy = "salon", cascade = CascadeType.ALL)
    private List<Inscription> inscriptions;
}
