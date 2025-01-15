package fr.hb.assurance.controller;

import fr.hb.assurance.model.Contrat;
import fr.hb.assurance.service.ContratService;
import fr.hb.assurance.service.ClientService;
import fr.hb.assurance.service.VoitureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contrats")
public class ContratController {

    @Autowired
    private ContratService contratService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private VoitureService voitureService;

    // Affiche la liste des contrats
    @GetMapping
    public String listeContrats(Model model) {
        model.addAttribute("contrats", contratService.findAll());
        return "contrats/list";
    }

    // Affiche le formulaire d'ajout de contrat
    @GetMapping("/ajouter")
    public String ajouterContratForm(Model model) {
        model.addAttribute("contrat", new Contrat());
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("voitures", voitureService.findAll());
        return "contrats/form";
    }

    // Affiche le formulaire de modification d'un contrat
    @GetMapping("/modifier/{id}")
    public String modifierContratForm(@PathVariable int id, Model model) {
        Contrat contrat = contratService.findById(id); // Méthode pour trouver le contrat par ID
        if (contrat == null) {
            throw new IllegalArgumentException("Contrat introuvable avec l'ID : " + id);
        }
        model.addAttribute("contrat", contrat);
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("voitures", voitureService.findAll());
        return "contrats/form"; // Réutilise le formulaire pour l'ajout/modification
    }

    // Ajoute ou met à jour un contrat
    @PostMapping("/sauvegarder")
    public String sauvegarderContrat(@ModelAttribute Contrat contrat) {
        contratService.save(contrat);
        return "redirect:/contrats";
    }

    // Supprime un contrat
    @GetMapping("/supprimer/{id}")
    public String supprimerContrat(@PathVariable int id) {
        contratService.delete(id);
        return "redirect:/contrats";
    }
}
