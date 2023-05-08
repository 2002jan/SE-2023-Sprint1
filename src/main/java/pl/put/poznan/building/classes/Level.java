package pl.put.poznan.building.classes;

import java.util.ArrayList;
import java.util.List;

public class Level extends Location {

    private List<Room> rooms;

    public Level(int id, String name, List<Room> rooms) {
        super(id, name);
        this.rooms = new ArrayList<Room>();
    }


    public List<Room> getRooms() {
        return rooms;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(Room room) {
        rooms.remove(room);
    }

    @Override
    public int getArea() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getVolume() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public float getHeatingEnergy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getLightingPower() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
