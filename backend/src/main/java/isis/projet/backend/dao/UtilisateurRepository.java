package isis.projet.backend.dao;

import isis.projet.backend.entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Inscription, Integer> {
}