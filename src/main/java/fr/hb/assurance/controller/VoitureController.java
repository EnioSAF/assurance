package fr.hb.assurance.controller;

import fr.hb.assurance.model.Voiture;
import fr.hb.assurance.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/voitures")
public class VoitureController {

    @Autowired
    private VoitureService voitureService;

    // Affiche la liste des voitures
    @GetMapping
    public String listeVoitures(Model model) {
        model.addAttribute("voitures", voitureService.findAll());
        return "voitures/list";
    }

    // Affiche le formulaire d'ajout de voiture
    @GetMapping("/ajouter")
    public String ajouterVoitureForm(Model model) {
        model.addAttribute("voiture", new Voiture());
        return "voitures/form";
    }

    // Affiche le formulaire de modification d'une voiture
    @GetMapping("/modifier/{id}")
    public String modifierVoitureForm(@PathVariable int id, Model model) {
        Voiture voiture = voitureService.findById(id);
        if (voiture == null) {
            throw new IllegalArgumentException("Voiture introuvable avec l'ID : " + id);
        }
        model.addAttribute("voiture", voiture);
        return "voitures/form";
    }

    // Ajoute ou met à jour une voiture
    @PostMapping("/sauvegarder")
    public String sauvegarderVoiture(@ModelAttribute Voiture voiture) {
        voitureService.save(voiture);
        return "redirect:/voitures";
    }

    // Supprime une voiture
    @GetMapping("/supprimer/{id}")
    public String supprimerVoiture(@PathVariable int id) {
        voitureService.delete(id);
        return "redirect:/voitures";
    }
}
