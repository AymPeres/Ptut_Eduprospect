package isis.projet.backend.controller;

import isis.projet.backend.entity.Inscription;
import isis.projet.backend.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscriptions")
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionService;

    // Récupérer toutes les inscriptions
    @GetMapping
    public ResponseEntity<List<Inscription>> getAllInscriptions() {
        List<Inscription> inscriptions = inscriptionService.getAllInscriptions();
        return ResponseEntity.ok(inscriptions);
    }

    // Récupérer une inscription par ID
    @GetMapping("/{id}")
    public ResponseEntity<Inscription> getInscriptionById(@PathVariable Integer id) {
        return inscriptionService.getInscriptionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer une nouvelle inscription
    @PostMapping
    public ResponseEntity<Inscription> createInscription(@RequestBody Inscription inscription) {
        Inscription created = inscriptionService.createInscription(inscription);
        return ResponseEntity.ok(created);
    }

    // Supprimer une inscription par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInscription(@PathVariable Integer id) {
        inscriptionService.deleteInscription(id);
        return ResponseEntity.noContent().build();
    }
}
