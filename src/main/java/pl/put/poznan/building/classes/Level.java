package pl.put.poznan.building.classes;

import java.util.List;

public class Level extends Location{

    private List<Room> rooms;

    public Level(int id, String name, List<Room> rooms) {
        super(id, name);
        this.rooms = rooms;
    }

    @Override
    public String toString() {
        return "Level{" +
                "rooms=" + rooms +
                '}';
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
