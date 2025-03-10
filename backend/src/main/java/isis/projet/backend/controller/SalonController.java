package isis.projet.backend.controller;

import isis.projet.backend.entity.Salon;
import isis.projet.backend.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salons")
public class SalonController {

    @Autowired
    private SalonService salonService;

    // Récupérer tous les salons
    @GetMapping
    public ResponseEntity<List<Salon>> getAllSalons() {
        List<Salon> salons = salonService.getAllSalons();
        return ResponseEntity.ok(salons);
    }

    // Récupérer un salon par ID
    @GetMapping("/{id}")
    public ResponseEntity<Salon> getSalonById(@PathVariable Integer id) {
        return salonService.getSalonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Créer un nouveau salon
    @PostMapping
    public ResponseEntity<Salon> createSalon(@RequestBody Salon salon) {
        Salon created = salonService.createSalon(salon);
        return ResponseEntity.ok(created);
    }

    // Mettre à jour un salon existant
    @PutMapping("/{id}")
    public ResponseEntity<Salon> updateSalon(@PathVariable Integer id, @RequestBody Salon salon) {
        salon.setId(id);
        Salon updated = salonService.updateSalon(salon);
        return ResponseEntity.ok(updated);
    }

    // Supprimer un salon par ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalon(@PathVariable Integer id) {
        salonService.deleteSalon(id);
        return ResponseEntity.noContent().build();
    }
}
