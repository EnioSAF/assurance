package fr.hb.assurance.controller;

import fr.hb.assurance.service.ClientService;
import fr.hb.assurance.service.ContratService;
import fr.hb.assurance.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccueilController {

    @Autowired
    private VoitureService voitureService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ContratService contratService;

    @GetMapping("/")
    public String accueil(Model model) {
        // Calculer les données pour le récapitulatif
        long voituresDisponibles = voitureService.findAll().stream()
                .filter(v -> "Disponible".equals(v.getStatut()))
                .count();
        long contratsEnCours = contratService.findAll().stream()
                .filter(c -> "En cours".equals(c.getEtat()))
                .count();
        long nombreClients = clientService.findAll().size();

        // Ajouter les données au modèle
        model.addAttribute("voituresDisponibles", voituresDisponibles);
        model.addAttribute("contratsEnCours", contratsEnCours);
        model.addAttribute("nombreClients", nombreClients);

        return "accueil"; // Retourne le template accueil.html
    }
}
