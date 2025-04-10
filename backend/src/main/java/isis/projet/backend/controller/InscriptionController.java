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
        if (inscription.getSalon() == null || inscription.getSalon().getId() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Optional<Salon> salonOpt = salonRepository.findById(inscription.getSalon().getId());
        if (!salonOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        inscription.setSalon(salonOpt.get());
        Inscription saved = inscriptionService.createInscription(inscription);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Inscription>> getInscriptions(@RequestParam(required = false) Integer salonId) {
        if (salonId != null) {
            List<Inscription> inscriptions = inscriptionService.getInscriptionsBySalonId(salonId);
            return ResponseEntity.ok(inscriptions);
        } else {
            List<Inscription> inscriptions = inscriptionService.findAll();
            return ResponseEntity.ok(inscriptions);
        }
    }

}
