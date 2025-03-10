package isis.projet.backend.service;

import isis.projet.backend.dao.InscriptionRepository;
import isis.projet.backend.entity.Inscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    // Récupérer toutes les inscriptions
    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    // Récupérer les inscriptions d'un salon spécifique
    public List<Inscription> getInscriptionsBySalonId(Integer salonId) {
        return inscriptionRepository.findBySalonId(salonId);
    }

    // Créer une nouvelle inscription
    public Inscription createInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    // Récupérer une inscription par son ID
    public Optional<Inscription> getInscriptionById(Integer id) {
        return inscriptionRepository.findById(id);
    }

    // Supprimer une inscription par son ID
    public void deleteInscription(Integer id) {
        inscriptionRepository.deleteById(id);
    }
}
