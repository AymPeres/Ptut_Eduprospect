package isis.projet.backend.controller;

import isis.projet.backend.controller.LoginRequest;
import isis.projet.backend.controller.LoginResponse;
import isis.projet.backend.entity.Utilisateur;
import isis.projet.backend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UtilisateurController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        Utilisateur Utilisateur = authService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());

        if (Utilisateur != null) {
            // Générer un JWT token (à implémenter selon votre méthode d'authentification)
            String token = generateToken(Utilisateur);

            return ResponseEntity.ok(new LoginResponse(token, Utilisateur.getEmail()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Identifiants invalides");
        }
    }

    // Méthode à implémenter pour générer un token JWT
    private String generateToken(Utilisateur utilisateur) {
        // Implémentez cette méthode selon votre système d'authentification
        // Par exemple avec JWT
        return "jwt";
    }
}