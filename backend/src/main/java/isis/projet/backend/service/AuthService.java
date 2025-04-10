
package isis.projet.backend.service;

import isis.projet.backend.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    private final String storedHash = "$2a$10$dxp9dePzf7aOofBRzAP6su6R15ns7gqqHGvG46iAS6nsF4FzXVEQe";

    public Utilisateur authenticate(String password) {
        System.out.println("Tentative de connexion avec le mot de passe fourni");
        if (passwordEncoder.matches(password, storedHash)) {
            Utilisateur user = new Utilisateur();

            user.setEmail("default@domain.com");
            user.setPassword(storedHash);
            return user;
        }
        return null; // Authentification échouée
    }
}
