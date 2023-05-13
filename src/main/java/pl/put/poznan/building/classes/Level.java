package pl.put.poznan.building.classes;

import java.util.HashMap;

public class Level extends LocationContainer {

    public static HashMap<Integer, Level> levelMap = new HashMap<>();

    public Level(int id, String name) {
        super(id, name);
    }

    public void addRoom(Room room) {
        this.addLocation(room);
    }

}
