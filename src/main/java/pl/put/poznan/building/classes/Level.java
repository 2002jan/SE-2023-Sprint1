package pl.put.poznan.building.classes;

import java.util.HashMap;

/**
 * Class representing a level of a building.
 */
public class Level extends LocationContainer {

    /**
     * Stores all levels mapped by their IDs
     */
    public static HashMap<Integer, Level> levelMap = new HashMap<>();

    /**
     * Constructor for Level class.
     * @param id Level's id
     * @param name Level's name
     */
    public Level(int id, String name) {
        super(id, name);
    }

    /**
     * Adds a room to the level.
     * @param room Room to be added
     */
    public void addRoom(Room room) {
        this.addLocation(room);
    }

}
