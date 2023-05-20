package pl.put.poznan.building.classes;

import java.util.HashMap;

/**
 * Class representing a building.
 * It extends LocationContainer class.
 */
public class Building extends LocationContainer {

    public static HashMap<Integer, Building> buildingMap = new HashMap<>();

    /**
     * Constructor of Building class.
     *
     * @param id   id of the building
     * @param name name of the building
     */
    public Building(int id, String name) {
        super(id, name);
    }

    /**
     * This method adds a level to the building.
     *
     * @param level level to be added
     */
    public void addLevel(Level level) {
        this.addLocation(level);
    }

}
