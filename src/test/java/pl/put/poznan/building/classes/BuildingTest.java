package pl.put.poznan.building.classes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class BuildingTest {

    @Test
    void addLevel() {
        Building building = new Building(1, "a");
        Level level1 = new Level(2, "b");
        Level level2 = new Level(3, "c");
        building.addLevel(level1);
        building.addLevel(level2);
        List<Location> locations = building.getLocations();
        assertSame(locations.get(0), level1);
        assertSame(locations.get(1), level2);
    }

    @Test
    void getArea() {
        Building building = new Building(1, "a");
        Level level = new Level(2, "b");
        Room room1 = new Room(3, "c", 10, 0, 0, 0);
        Room room2 = new Room(4, "d", 20, 0, 0, 0);
        level.addRoom(room1);
        level.addRoom(room2);
        building.addLevel(level);
        assertEquals(30, building.getArea());
    }

    @Test
    void getVolume() {
        Building building = new Building(1, "a");
        Level level = new Level(2, "b");
        Room room1 = new Room(3, "c", 0, 100, 0, 0);
        Room room2 = new Room(4, "d", 0, 200, 0, 0);
        level.addRoom(room1);
        level.addRoom(room2);
        building.addLevel(level);
        assertEquals(300, building.getVolume());
    }

    @Test
    void getHeatingEnergy() {
        Building building = new Building(1, "a");
        Level level = new Level(2, "b");
        Room room1 = new Room(3, "c", 0, 1, 20, 0);
        Room room2 = new Room(4, "d", 0, 2, 20, 0);
        level.addRoom(room1);
        level.addRoom(room2);
        building.addLevel(level);
        assertEquals(15, building.getHeatingEnergy());
    }

    @Test
    void getLightingPower() {
        Building building = new Building(1, "a");
        Level level = new Level(2, "b");
        Room room1 = new Room(3, "c", 1, 0, 0, 10);
        Room room2 = new Room(4, "d", 2, 0, 0, 20);
        level.addRoom(room1);
        level.addRoom(room2);
        building.addLevel(level);
        assertEquals(10, building.getLightingPower());
    }

    @Test
    void getRoomsExceedingHeatingEnergy() {
        Building building = new Building(1, "a");
        Level level = new Level(2, "b");
        Room room1 = new Room(3, "c", 0, 1, 20, 0);
        Room room2 = new Room(4, "d", 0, 2, 20, 0);
        Room room3 = new Room(5, "e", 0, 3, 20, 0);
        level.addRoom(room1);
        level.addRoom(room2);
        level.addRoom(room3);
        building.addLevel(level);
        List<Room> rooms = building.getRoomsExceedingHeatingEnergy(9);
        assertSame(rooms.get(0), room1);
        assertSame(rooms.get(1), room2);
    }
}
