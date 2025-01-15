package fr.hb.assurance.service;

import fr.hb.assurance.model.Voiture;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VoitureService {

    private static final List<Voiture> voitures = new ArrayList<>();

    static {
        voitures.add(new Voiture(1, "AB-123-CD", "Clio", "Renault", "Berline", "Disponible"));
        voitures.add(new Voiture(2, "EF-456-GH", "308", "Peugeot", "Berline", "En maintenance"));
        voitures.add(new Voiture(3, "IJ-789-KL", "Tiguan", "Volkswagen", "SUV", "Disponible"));
    }

    public List<Voiture> findAll() {
        return voitures;
    }

    public Voiture findById(int id) {
        return voitures.stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(Voiture voiture) {
        if (voiture.getId() == 0) {
            int newId = voitures.stream()
                    .mapToInt(Voiture::getId)
                    .max()
                    .orElse(0) + 1;
            voiture.setId(newId);
            voitures.add(voiture);
        } else {
            Voiture existing = findById(voiture.getId());
            if (existing != null) {
                existing.setImmatriculation(voiture.getImmatriculation());
                existing.setModele(voiture.getModele());
                existing.setMarque(voiture.getMarque());
                existing.setCategorie(voiture.getCategorie());
                existing.setStatut(voiture.getStatut());
            }
        }
    }

    public void delete(int id) {
        voitures.removeIf(v -> v.getId() == id);
    }
}
