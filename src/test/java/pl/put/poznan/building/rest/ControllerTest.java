package pl.put.poznan.building.rest;

import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import pl.put.poznan.building.rest.repositories.BuildingRepository;

public abstract class ControllerTest {

    protected BuildingRepository buildingRepository;

    @BeforeEach
    void setUp(){
        buildingRepository = mock(BuildingRepository.class);
    }

}
