package backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import backend.models.Client;
import backend.repos.ClientRepository;
import backend.repos.OrderRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clients;
    @Autowired
    private OrderRepository orders;

    @Transactional(readOnly = true)
    public List<Client> getAll() {
        var client_list = clients.findAll();
        for (Client client : client_list) {
            client.setOrder_ids(orders.findAllOrderIdsByUserId(client.getId()));
        }

        return client_list;
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