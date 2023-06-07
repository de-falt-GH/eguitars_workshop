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

import backend.models.Building;
import backend.repos.BuildingRepository;
import backend.services.OrderService;

@ExtendWith(MockitoExtension.class)
public class BuildingServiceTests {
    @Mock
    private BuildingRepository buildingRepository;

    @Captor
    private ArgumentCaptor<Building> captor;

    @Test
    void findAll() {
        var building1 = new Building();
        building1.setCreationDate("date1");
        var building2 = new Building();
        building2.setCreationDate("date2");
        var building3 = new Building();
        building3.setCreationDate("date3");

        Mockito.when(buildingRepository.findAll()).thenReturn(List.of(building1, building2, building3));
        var postService = new OrderService(buildingRepository);

        Assertions.assertEquals(3, postService.getAll().size());
        Assertions.assertEquals(building1.getCreationDate(), postService.getAll().get(0).getCreationDate());
    }

    @Test
    void save() {
        var building = new Building();
        building.setCreationDate("testDate");

        var service = new OrderService(buildingRepository);
        service.save(building);
        Mockito.verify(buildingRepository).save(captor.capture());
        var building1 = captor.getValue();

        Assertions.assertEquals("testName", building1.getCreationDate());
    }
}