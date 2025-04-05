package isis.projet.backend.service;

import isis.projet.backend.dao.UtilisateurRepository;
import isis.projet.backend.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UtilisateurRepository adminRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Utilisateur authenticate(String email, String password) {
        Optional<Utilisateur> optionalAdmin = adminRepository.findByEmail(email);
        System.out.println("Tentative de connexion pour l'email : " + email);

        if (optionalAdmin.isPresent()) {
            System.out.println("Utilisateur trouvé en base de données");
            Utilisateur utilisateur = optionalAdmin.get();
            // Débogage de la vérification de mot de passe
            boolean passwordMatches = passwordEncoder.matches(password, utilisateur.getPassword());
            System.out.println("Résultat de la vérification du mot de passe : " + passwordMatches);

            if (passwordMatches) {
                return utilisateur;
            }
        } else {
            System.out.println("Aucun utilisateur trouvé avec cet email");
        }

        return null; // Authentification échouée
    }
}