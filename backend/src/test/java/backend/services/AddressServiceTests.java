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

import backend.models.Address;
import backend.repos.AddressRepository;
import backend.services.ClientService;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTests {
    @Mock
    private AddressRepository addressRepository;

    @Captor
    private ArgumentCaptor<Address> captor;

    @Test
    void findAll() {
        var address1 = new Address();
        address1.setAddressText("addressText1");
        var address2 = new Address();
        address1.setAddressText("addressText2");
        var address3 = new Address();
        address1.setAddressText("addressText3");

        Mockito.when(addressRepository.findAll()).thenReturn(List.of(address1, address2, address3));
        var postService = new ClientService(addressRepository);

        Assertions.assertEquals(3, postService.getAll().size());
        Assertions.assertEquals(address1.getAddressText(), postService.getAll().get(0).getAddressText());
    }

    @Test
    void save() {
        var address = new Address();
        address.setAddressText("testText");

        var service = new ClientService(addressRepository);
        service.save(address);
        Mockito.verify(addressRepository).save(captor.capture());
        var address1 = captor.getValue();

        Assertions.assertEquals("testText", address1.getAddressText());
    }
}