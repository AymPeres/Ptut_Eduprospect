package isis.projet.backend.controller;

import isis.projet.backend.entity.Inscription;
import isis.projet.backend.service.ExportService;
import isis.projet.backend.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/export")
public class ExportController {

    @Autowired
    private InscriptionService inscriptionService;

    @Autowired
    private ExportService exportService;

    // Endpoint pour exporter en CSV les inscriptions d'un salon spécifique
    @GetMapping("/csv/salon/{salonId}")
    public ResponseEntity<String> exportInscriptionsBySalonToCSV(@PathVariable Integer salonId) {
        List<Inscription> inscriptions = inscriptionService.getInscriptionsBySalonId(salonId);
        String csvData = exportService.exportInscriptionsToCSV(inscriptions);

        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"inscriptions.csv\"");
        headers.set(HttpHeaders.CONTENT_TYPE, "text/csv");

        return ResponseEntity.ok()
                .headers(headers)
                .body(csvData);
    }
}
