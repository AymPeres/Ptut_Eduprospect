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

    // Récupérer tous les salons
    public List<Salon> getAllSalons() {
        return salonRepository.findAll();
    }

    // Créer un nouveau salon
    public Salon createSalon(Salon salon) {
        return salonRepository.save(salon);
    }

    // Récupérer un salon par son ID
    public Optional<Salon> getSalonById(Integer id) {
        return salonRepository.findById(id);
    }

    // Mettre à jour un salon existant
    public Salon updateSalon(Salon salon) {
        return salonRepository.save(salon);
    }

    // Supprimer un salon par son ID
    public void deleteSalon(Integer id) {
        salonRepository.deleteById(id);
    }
}
