package pl.put.poznan.building.rest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.building.classes.Building;
import pl.put.poznan.building.classes.Level;
import pl.put.poznan.building.classes.Location;
import pl.put.poznan.building.classes.Room;
import pl.put.poznan.building.dto.LocationDto;

import java.util.Arrays;
import java.util.List;

public class BuildingsControllerTest extends ControllerTest {

    private BuildingsController buildingsController;

    private Building building;

    @Override
    @BeforeEach
    void setUp() {
        super.setUp();

        buildingsController = new BuildingsController(buildingRepository);

        building = mock(Building.class);
        when(buildingRepository.getBuildingById(anyInt())).thenReturn(building);
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
        List<Location> levels = Arrays.asList(new Level(1, "A"), new Level(2, "A"), new Level(3, "A"));
        when(building.getLocations()).thenReturn(levels);

        Object[] response = buildingsController.getLevelsFromBuilding(1);

        assertEquals(levels.size(), response.length);

        for (int i = 0; i < levels.size(); i++) {
            if (response[i] instanceof LocationDto) {
                LocationDto dto = (LocationDto) response[i];

                assertEquals(levels.get(i).getId(), dto.getId());
                assertEquals(levels.get(i).getName(), dto.getName());
            }
        }
    }

    @Test
    void getAreaForBuilding() {
        when(building.getArea()).thenReturn(2);

        int area = buildingsController.getAreaForBuilding(1);

        assertEquals(2, area);
    }

    @Test
    void getVolumeForBuilding() {
        when(building.getVolume()).thenReturn(10);

        int volume = buildingsController.getVolumeForBuilding(1);

        assertEquals(10, volume);
    }

    @Test
    void getHeatingEnergyForBuilding() {
        when(building.getHeatingEnergy()).thenReturn(5f);

        float heating = buildingsController.getHeatingEnergyForBuilding(1);

        assertEquals(5f, heating);
    }

    @Test
    void getLightingPowerForBuilding() {
        when(building.getLightingPower()).thenReturn(5f);

        float lighting = buildingsController.getLightingPowerForBuilding(1);

        assertEquals(5f, lighting);
    }

    @Test
    void getRoomsExceedingHeatingEnergyForBuilding() {
        List<Room> rooms = Arrays.asList(new Room(1, "1", 1, 1, 1, 1), new Room(2, "2", 2, 2, 2, 2), new Room(2, "2", 2, 2, 2, 2));
        when(building.getRoomsExceedingHeatingEnergy(anyFloat())).thenReturn(rooms);

        Object[] response = buildingsController.getRoomsExceedingHeatingEnergyForBuilding(1, 1);

        assertEquals(rooms.size(), response.length);

        for (int i = 0; i < rooms.size(); i++) {
            if (response[i] instanceof LocationDto) {
                LocationDto dto = (LocationDto) response[i];

                assertEquals(rooms.get(i).getId(), dto.getId());
                assertEquals(rooms.get(i).getName(), dto.getName());
            }
        }
    }

}
