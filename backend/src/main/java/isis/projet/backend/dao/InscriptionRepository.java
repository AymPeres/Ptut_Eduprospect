package isis.projet.backend.dao;

import isis.projet.backend.entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Integer> {
    List<Inscription> findBySalonId(Integer salonId); // Récupérer toutes les inscriptions d'un salon
}
