package isis.projet.backend.dao;

import isis.projet.backend.entity.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Integer> {
    // Récupérer toutes les années distinctes
    @Query("SELECT DISTINCT s.annee FROM Salon s ORDER BY s.annee DESC")
    List<Integer> findDistinctAnnees();

    // Récupérer toutes les villes distinctes pour une année donnée
    @Query("SELECT DISTINCT s.ville FROM Salon s WHERE s.annee = :annee ORDER BY s.ville")
    List<String> findDistinctVillesByAnnee(@Param("annee") Integer annee);

    // Récupérer tous les salons pour une année et une ville données
    List<Salon> findByAnneeAndVilleOrderByNom(Integer annee, String ville);
}