package isis.projet.backend.controller;

import isis.projet.backend.entity.Utilisateur;
import isis.projet.backend.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    // Récupérer un utilisateur par email (via un paramètre de requête)
    @GetMapping("/byEmail")
    public ResponseEntity<Utilisateur> getUtilisateurByEmail(@RequestParam String email) {
        return utilisateurService.getUtilisateurByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer un nouvel utilisateur
    @PostMapping
    public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur) {
        // Pense à hacher le mot de passe avant de sauvegarder
        Utilisateur created = utilisateurService.createUtilisateur(utilisateur);
        return ResponseEntity.ok(created);
    }
}
