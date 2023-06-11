package pl.put.poznan.building.rest.repositories;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import pl.put.poznan.building.classes.Building;
import pl.put.poznan.building.classes.Level;
import pl.put.poznan.building.classes.Room;
import pl.put.poznan.building.rest.exceptions.models.BuildingNotFoundException;

import java.util.HashMap;

public class BuildingRepositoryTest {

    private BuildingRepository buildingRepository;

    private HashMap<Integer, Building> buildingMap;

    private HashMap<Integer, Level> levelMap;

    private HashMap<Integer, Room> roomMap;

    @BeforeEach
    void setUp() {
        buildingMap = mock(HashMap.class);
        Building.buildingMap = buildingMap;
        levelMap = mock(HashMap.class);
        Level.levelMap = levelMap;
        roomMap = mock(HashMap.class);
        Room.roomMap = roomMap;

        buildingRepository = new BuildingRepository();
    }

    @Test
    void getBuildingById() {
        Building building = new Building(1, "name");

        when(buildingMap.containsKey(anyInt())).thenReturn(true);
        when(buildingMap.get(anyInt())).thenReturn(building);

        assertEquals(building, buildingRepository.getBuildingById(1));
    }

    @Test
    void buildingNotFoundException() {
        when(buildingMap.containsKey(anyInt())).thenReturn(false);

        assertThrows(BuildingNotFoundException.class, () -> buildingRepository.getBuildingById(1));
    }

    @Test
    void getLevelById() {
        //TODO: Implement
    }

    @Test
    void levelNotFoundException() {
        //TODO: Implement
    }

    @Test
    void getRoomById() {
        //TODO: Implement
    }

    @Test
    void roomNotFoundException() {
        //TODO: Implement
    }

}
