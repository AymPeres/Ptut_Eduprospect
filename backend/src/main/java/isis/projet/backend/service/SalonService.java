package isis.projet.backend.service;

import isis.projet.backend.dao.SalonRepository;
import isis.projet.backend.entity.Salon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalonService {

    @Autowired
    private SalonRepository salonRepository;

    public List<Salon> getAllSalons() {
        return salonRepository.findAll();
    }

    public Salon createSalon(Salon salon) {
        return salonRepository.save(salon);
    }

    public Optional<Salon> getSalonById(Integer id) {
        return salonRepository.findById(id);
    }

    public Salon updateSalon(Salon salon) {
        return salonRepository.save(salon);
    }

    public void deleteSalon(Integer id) {
        salonRepository.deleteById(id);
    }
    // Récupérer toutes les années distinctes
    public List<Integer> getAllAnnees() {
        return salonRepository.findDistinctAnnees();
    }

    // Récupérer toutes les villes pour une année donnée
    public List<String> getVillesByAnnee(Integer annee) {
        return salonRepository.findDistinctVillesByAnnee(annee);
    }

    // Récupérer tous les salons pour une année et une ville
    public List<Salon> getSalonsByAnneeAndVille(Integer annee, String ville) {
        return salonRepository.findByAnneeAndVilleOrderByNom(annee, ville);
    }
}

