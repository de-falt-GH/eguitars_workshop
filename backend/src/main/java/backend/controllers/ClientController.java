package backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import backend.models.Client;
import backend.services.ClientService;

@RestController
public class ClientController {
    @Autowired
    private ClientService clients;

    @GetMapping("/clients")
    public List<Client> getAllClients() {
        return clients.getAll();
    }

    @PostMapping("/clients")
    public Client createClient(@RequestBody Client client) {
        clients.save(client);
        return client;
    }

    @DeleteMapping("/clients/{id}")
    public HttpStatus deleteMarket(@PathVariable long id) {
        clients.deleteById(id);
        return HttpStatus.OK;
    }
}
