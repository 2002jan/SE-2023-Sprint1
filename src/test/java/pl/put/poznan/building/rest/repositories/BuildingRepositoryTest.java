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
import pl.put.poznan.building.rest.exceptions.models.LevelNotFoundException;
import pl.put.poznan.building.rest.exceptions.models.RoomNotFoundException;

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

        Level level = new Level(1, "name");

        when(levelMap.containsKey(anyInt())).thenReturn(true);
        when(levelMap.get(anyInt())).thenReturn(level);

        assertEquals(level, buildingRepository.getLevelById(1));
    }

    @Test
    void levelNotFoundException() {

        when(levelMap.containsKey(anyInt())).thenReturn(false);

        assertThrows(LevelNotFoundException.class, () -> buildingRepository.getLevelById(1));

    }

    @Test
    void getRoomById() {

        Room room = new Room(1, "name", 15, 25, 1, 11);

        when(roomMap.containsKey(anyInt())).thenReturn(true);
        when(roomMap.get(anyInt())).thenReturn(room);

        assertEquals(room, buildingRepository.getRoomById(1));
    }

    @Test
    void roomNotFoundException() {

        when(roomMap.containsKey(anyInt())).thenReturn(false);

        assertThrows(RoomNotFoundException.class, () -> buildingRepository.getRoomById(1));
    }

}
