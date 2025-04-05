package isis.projet.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Entity
@Table(name = "utilisateurs")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Email  // Vérifie que l'email est valide
    @Column(unique = true, nullable = false)
    @NonNull
    private String email;

    @NotBlank
    @Column(name = "mot_de_passe", nullable = false)
    @NonNull
    private String Password;  // ⚠ Il faudra le hacher avant de l'enregistrer

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.user;  // Par défaut, un utilisateur est "user"

    public enum Role {
        admin, user
    }
}
