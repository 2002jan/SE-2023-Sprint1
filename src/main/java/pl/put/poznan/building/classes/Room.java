package pl.put.poznan.building.classes;

import java.util.HashMap;
import java.util.List;

/**
 * This is a class representing a room in a building.
 * It extends the Location class.
 * It contains information about room's area, volume, heating energy and lighting power.
 * It is treated as a leaf in the composite pattern.
 */

public class Room extends Location {

    public static HashMap<Integer, Room> roomMap = new HashMap<>();

    private int area;
    private int cube;
    private float heating;
    private int lighting;

    /**
     * Constructor of Room class.
     *
     * @param id       id of the room
     * @param name     name of the room
     * @param area     area of the room
     * @param cube     volume of the room
     * @param heating  heating energy of the room
     * @param lighting lighting power of the room
     */
    public Room(int id, String name, int area, int cube, float heating, int lighting) {
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.lighting = lighting;
    }


    @Override
    public int getArea() {
        return area;
    }


    @Override
    public int getVolume() {
        return cube;
    }


    @Override
    public float getHeatingEnergy() {
        return heating;
    }


    @Override
    public int getLightingPower() {
        return lighting;
    }

    /**
     *
     *
     * @param limit heating energy limit
     * @return list of rooms exceeding a given heating energy limit
     */
    @Override
    public List<Room> getRoomsExceedingHeatingEnergy(float limit) {
        return null; //TODO: implement logic
    }

}
