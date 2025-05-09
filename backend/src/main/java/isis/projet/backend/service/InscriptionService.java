package isis.projet.backend.service;

import isis.projet.backend.dao.InscriptionRepository;
import isis.projet.backend.entity.Inscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionService {

    @Autowired
    private InscriptionRepository inscriptionRepository;

    public List<Inscription> findAll() {
        return inscriptionRepository.findAll();
    }

    public List<Inscription> getInscriptionsBySalonId(Integer salonId) {
        return inscriptionRepository.findBySalonId(salonId);
    }

    public Inscription createInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }
}
