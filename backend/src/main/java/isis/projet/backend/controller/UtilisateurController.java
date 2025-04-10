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
        // On ne prend en compte que le mot de passe
        Utilisateur user = authService.authenticate(loginRequest.getPassword());

        if (user != null) {
            String token = generateToken(user);
            return ResponseEntity.ok(new LoginResponse(token, user.getEmail()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Mot de passe invalide");
        }
    }

    private String generateToken(Utilisateur utilisateur) {
        return "jwt";
    }
}
