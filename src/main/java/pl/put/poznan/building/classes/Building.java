package pl.put.poznan.building.classes;

import java.util.HashMap;


/**
 * Class representing a building.
 */
public class Building extends LocationContainer {

    /**
     * Stores all buildings mapped by their IDs
     */
    public static HashMap<Integer, Building> buildingMap = new HashMap<>();

    /**
     * Constructor of the building class
     * @param id building id
     * @param name building name
     */
    public Building(int id, String name) {
        super(id, name);
    }

    /**
     * Method adding a level to the building
     * @param level level to be added
     */
    public void addLevel(Level level) {
        this.addLocation(level);
    }

}
