package isis.projet.backend.controller;

import isis.projet.backend.entity.Salon;
import isis.projet.backend.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/navigation")
public class NavigationController {

    @Autowired
    private SalonService salonService;

    @GetMapping("/annees")
    public ResponseEntity<List<Integer>> getAllAnnees() {
        List<Integer> annees = salonService.getAllAnnees();
        return ResponseEntity.ok(annees);
    }

    // Récupérer toutes les villes pour une année donnée
    @GetMapping("/annees/{annee}/villes")
    public ResponseEntity<List<String>> getVillesByAnnee(@PathVariable Integer annee) {
        List<String> villes = salonService.getVillesByAnnee(annee);
        return ResponseEntity.ok(villes);
    }

    // Récupérer tous les salons pour une année et une ville données
    @GetMapping("/annees/{annee}/villes/{ville}/salons")
    public ResponseEntity<List<Salon>> getSalonsByAnneeAndVille(
            @PathVariable Integer annee,
            @PathVariable String ville) {
        List<Salon> salons = salonService.getSalonsByAnneeAndVille(annee, ville);
        return ResponseEntity.ok(salons);
    }
}