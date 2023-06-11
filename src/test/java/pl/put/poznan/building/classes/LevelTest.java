package pl.put.poznan.building.classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.building.rest.BuildingsController;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LevelTest {

    private Level level;

    private Room room;
    private Room room2;
    private Room room3;

    @BeforeEach
    void setUp() {

        room = new Room(1, "name", 1, 1, 5, 1);
        room2 = new Room(2, "name2", 1, 1, 6, 1);
        room3 = new Room(3, "name3", 1, 1, 1, 1);
        level = new Level(1, "name");
        level.addRoom(room);
        level.addRoom(room2);
        level.addRoom(room3);

    }

    @Test
    void addRoom() {

        Room testRoom = new Room(1, "test", 1, 1, 1, 1);
        level.addRoom(testRoom);

        assertTrue(level.getLocations().contains(testRoom));

    }

    @Test
    void getArea() {
        assertEquals(3, level.getArea());

    }

    @Test
    void getVolume() {
        assertEquals(3, level.getVolume());
    }

    @Test
    void getHeatingEnergy() {
        assertEquals(4, level.getHeatingEnergy());
    }

    @Test
    void getLightingPower() {
        assertEquals(1.0, level.getLightingPower());
    }

    @Test
    void getRoomsExceedingHeatingEnergy() {
        List<Room> testRooms = level.getRoomsExceedingHeatingEnergy(2.5F);

        assertTrue(testRooms.contains(room));
        assertTrue(testRooms.contains(room2));
        assertTrue(!testRooms.contains(room3));

    }

}
