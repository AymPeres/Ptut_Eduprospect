package isis.projet.backend.dao;

import isis.projet.backend.entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Salon, Integer> {
}