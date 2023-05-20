package pl.put.poznan.building.classes;

import java.util.HashMap;

/**
 * Class representing a level.
 * It extends LocationContainer class.
 *
 */
public class Level extends LocationContainer {


    public static HashMap<Integer, Level> levelMap = new HashMap<>();

    /**
     * Constructor of Level class.
     *
     * @param id   id of the level
     * @param name name of the level
     */
    public Level(int id, String name) {
        super(id, name);
    }

    /**
     * This method adds a room to the level.
     *
     * @param room room to be added
     */
    public void addRoom(Room room) {
        this.addLocation(room);
    }

}
