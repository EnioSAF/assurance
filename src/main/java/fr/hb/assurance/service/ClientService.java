package fr.hb.assurance.service;

import fr.hb.assurance.model.Client;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private static final List<Client> clients = new ArrayList<>();

    static {
        clients.add(new Client(1, "SADFLOWER", "Enio", "enio.sadflower@email.com", "Permis B", "Homme", false));
        clients.add(new Client(2, "TEST", "TEST", "test.test@email.com", "Permis B", "Femme", true));
    }

    public List<Client> findAll() {
        return clients;
    }

    public Client findById(int id) {
        return clients.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void save(Client client) {
        if (client.getId() == 0) {
            int newId = clients.stream()
                    .mapToInt(Client::getId)
                    .max()
                    .orElse(0) + 1;
            client.setId(newId);
            clients.add(client);
        } else {
            Client existing = findById(client.getId());
            if (existing != null) {
                existing.setNom(client.getNom());
                existing.setPrenom(client.getPrenom());
                existing.setEmail(client.getEmail());
                existing.setPermis(client.getPermis());
                existing.setGenre(client.getGenre());
                existing.setBloque(client.isBloque());
            }
        }
    }

    public void delete(int id) {
        clients.removeIf(c -> c.getId() == id);
    }
}
