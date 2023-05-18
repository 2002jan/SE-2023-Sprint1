package pl.put.poznan.building.classes;

import java.util.HashMap;

public class Building extends LocationContainer {

    public static HashMap<Integer, Building> buildingMap = new HashMap<>();

    public Building(int id, String name) {
        super(id, name);
    }

    public void addLevel(Level level) {
        this.addLocation(level);
    }

}
