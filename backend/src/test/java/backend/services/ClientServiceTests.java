package backend.services;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import backend.models.Client;
import backend.repos.ClientRepository;
import backend.services.ClientService;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTests {
    @Mock
    private ClientRepository clients;

    @Captor
    private ArgumentCaptor<Client> captor;

    @Test
    void findAll() {
        var client1 = new Client();
        client1.setName("Name1");
        var client2 = new Client();
        client1.setName("Name2");
        var client3 = new Client();
        client1.setName("Name3");

        Mockito.when(clients.findAll()).thenReturn(List.of(client1, client2, client3));
        var postService = new ClientService();

        Assertions.assertEquals(3, postService.getAll().size());
        Assertions.assertEquals(client1.getName(), postService.getAll().get(0).getName());
    }

    @Test
    void save() {
        var client = new Client();
        client.setName("name");

        var service = new ClientService();
        service.save(client);
        Mockito.verify(clients).save(captor.capture());
        var client1 = captor.getValue();

        Assertions.assertEquals("name", client1.getName());
    }
}