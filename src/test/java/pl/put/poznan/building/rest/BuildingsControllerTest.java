package pl.put.poznan.building.rest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.building.classes.Building;
import pl.put.poznan.building.dto.LocationDto;

public class BuildingsControllerTest extends ControllerTest {

    private BuildingsController buildingsController;

    @Override
    @BeforeEach
    void setUp() {
        super.setUp();

        buildingsController = new BuildingsController(buildingRepository);
    }

    @Test
    void getBuilding() {
        Building building = new Building(2, "mocked");

        when(buildingRepository.getBuildingById(2)).thenReturn(building);

        LocationDto response = buildingsController.getBuilding(2);

        assertEquals(building.getId(), response.getId());
        assertEquals(building.getName(), response.getName());
    }

    @Test
    void getLevelsFromBuilding() {
        //TODO: Implement
    }

    @Test
    void getAreaForBuilding(){
        //TODO: Implement
    }

    @Test
    void getVolumeForBuilding(){
        //TODO: Implement
    }

    @Test
    void getHeatingEnergyForBuilding(){
        //TODO: Implement
    }

    @Test
    void getLightingPowerForBuilding(){
        //TODO: Implement
    }

    @Test
    void getRoomsExceedingHeatingEnergyForBuilding(){
        //TODO: Implement
    }

}
