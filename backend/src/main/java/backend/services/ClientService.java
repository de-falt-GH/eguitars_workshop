package backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import backend.models.Client;
import backend.repos.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clients;

    @Transactional(readOnly = true)
    public List<Client> getAll() {
        return clients.findAll();
    }

    @Transactional
    public void save(Client client) {
        clients.save(client);
    }

    @Transactional
    public void deleteById(long id) {
        clients.deleteById(id);
    }
}