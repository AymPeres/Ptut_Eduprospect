package isis.projet.backend.service;

import isis.projet.backend.dao.UtilisateurRepository;
import isis.projet.backend.entity.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UtilisateurService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    // Récupérer un utilisateur par son email (utile pour l'authentification)
    public Optional<Utilisateur> getUtilisateurByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    // Créer un nouvel utilisateur (n'oublie pas de hacher le mot de passe avant)
    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }
}
