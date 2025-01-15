package fr.hb.assurance.service;

import fr.hb.assurance.model.Contrat;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContratService {

    private static final List<Contrat> contrats = new ArrayList<>();

    static {
        contrats.add(new Contrat(1, 1, "AB-123-CD", "2023-01-01", "2023-03-01", 500.0, "En cours"));
        contrats.add(new Contrat(2, 2, "EF-456-GH", "2023-02-01", "2023-05-01", 700.0, "Terminé"));
    }

    public List<Contrat> findAll() {
        return contrats;
    }

    public Contrat findById(int id) {
        return contrats.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(Contrat contrat) {
        Contrat existing = findById(contrat.getId());
        if (existing != null) {
            existing.setDateDebut(contrat.getDateDebut());
            existing.setDateFin(contrat.getDateFin());
            existing.setPrixTotal(contrat.getPrixTotal());
            existing.setEtat(contrat.getEtat());
        } else {
            contrats.add(contrat);
        }
    }

    public void delete(int id) {
        contrats.removeIf(c -> c.getId() == id);
    }
}
