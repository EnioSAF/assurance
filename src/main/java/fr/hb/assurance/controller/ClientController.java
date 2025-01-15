package fr.hb.assurance.controller;

import fr.hb.assurance.model.Client;
import fr.hb.assurance.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    // Affiche la liste des clients
    @GetMapping
    public String listeClients(Model model) {
        model.addAttribute("clients", clientService.findAll());
        return "clients/list";
    }

    // Affiche le formulaire d'ajout de client
    @GetMapping("/ajouter")
    public String ajouterClientForm(Model model) {
        model.addAttribute("client", new Client());
        return "clients/form";
    }

    // Affiche le formulaire de modification d'un client
    @GetMapping("/modifier/{id}")
    public String modifierClientForm(@PathVariable int id, Model model) {
        Client client = clientService.findById(id);
        if (client == null) {
            throw new IllegalArgumentException("Client introuvable avec l'ID : " + id);
        }
        model.addAttribute("client", client);
        return "clients/form";
    }

    // Ajoute ou met à jour un client
    @PostMapping("/sauvegarder")
    public String sauvegarderClient(@ModelAttribute Client client) {
        clientService.save(client);
        return "redirect:/clients";
    }

    // Supprime un client
    @GetMapping("/supprimer/{id}")
    public String supprimerClient(@PathVariable int id) {
        clientService.delete(id);
        return "redirect:/clients";
    }
}
