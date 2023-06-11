package pl.put.poznan.building.classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class RoomTest {

    private Room room;

    @BeforeEach
    void setUp() {
        room = new Room(1, "Room", 1, 1, 29, 2);
    }

    @Test
    void getRoomsExceedingHeatingEnergyWhenRoomExceeds(){
        List<Room> roomList = room.getRoomsExceedingHeatingEnergy(4f);

        assertNotNull(roomList);
        assertSame(room, roomList.get(0));
    }

    @Test
    void getRoomsExceedingHeatingEnergyWhenRoomDoesNotExceed(){
        List<Room> roomList = room.getRoomsExceedingHeatingEnergy(40f);

        assertNull(roomList);
    }
}
