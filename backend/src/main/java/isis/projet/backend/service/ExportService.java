package isis.projet.backend.service;

import isis.projet.backend.entity.Inscription;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.io.PrintWriter;
import java.util.List;

@Service
public class ExportService {

    public String exportInscriptionsToCSV(List<Inscription> inscriptions) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);

        // Écrire l'en-tête du CSV
        pw.println("ID,Nom,Prenom,Formation,Ville,CodePostal,Email,Telephone,Sexe,Statut,Interet,OrigineContact,SalonId");

        // Écrire chaque inscription
        for (Inscription inscription : inscriptions) {
            pw.printf("%d,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%d%n",
                    inscription.getId(),
                    escapeCsv(inscription.getNom()),
                    escapeCsv(inscription.getPrenom()),
                    escapeCsv(inscription.getFormation()),
                    escapeCsv(inscription.getVille()),
                    escapeCsv(inscription.getCodePostal()),
                    escapeCsv(inscription.getEmail()),
                    escapeCsv(inscription.getTelephone()),
                    escapeCsv(inscription.getSexe()),
                    escapeCsv(inscription.getStatut()),
                    escapeCsv(inscription.getInteret()),
                    escapeCsv(inscription.getOrigineContact()),
                    inscription.getSalon().getId()
            );
        }
        pw.flush();
        return sw.toString();
    }

    // Méthode simple d'échappement CSV
    private String escapeCsv(String input) {
        if (input.contains(",") || input.contains("\"") || input.contains("\n")) {
            input = input.replace("\"", "\"\"");
            return "\"" + input + "\"";
        }
        return input;
    }
}
