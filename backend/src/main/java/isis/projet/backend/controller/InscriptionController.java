package isis.projet.backend.controller;

import isis.projet.backend.entity.Inscription;
import isis.projet.backend.entity.Salon;
import isis.projet.backend.dao.SalonRepository;
import isis.projet.backend.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/inscriptions")
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionService;

    @Autowired
    private SalonRepository salonRepository;

    @PostMapping
    public ResponseEntity<Inscription> createInscription(@RequestBody Inscription inscription) {
        // Vérifier que l'inscription contient un salon avec un ID renseigné
        if (inscription.getSalon() == null || inscription.getSalon().getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        // Récupérer l'entité Salon depuis la BDD
        Optional<Salon> salonOpt = salonRepository.findById(inscription.getSalon().getId());
        if (!salonOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        // Associer l'entité Salon à l'inscription
        inscription.setSalon(salonOpt.get());
        // Sauvegarder l'inscription
        Inscription saved = inscriptionService.createInscription(inscription);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Inscription>> getInscriptions(@RequestParam(required = false) Integer salonId) {
        if (salonId != null) {
            // Utiliser la méthode findBySalonId
            List<Inscription> inscriptions = inscriptionService.getInscriptionsBySalonId(salonId);
            return ResponseEntity.ok(inscriptions);
        } else {
            // Sinon, renvoyer toutes les inscriptions
            List<Inscription> inscriptions = inscriptionService.findAll();
            return ResponseEntity.ok(inscriptions);
        }
    }

}
