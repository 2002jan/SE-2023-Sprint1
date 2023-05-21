package pl.put.poznan.building.classes;


import java.util.*;

/**
 * This class represents a room in a building.
 * In the composite design pattern, it is a leaf.
 */
public class Room extends Location {

    public static HashMap<Integer, Room> roomMap = new HashMap<>();

    private int area;
    private int cube;
    private float heating;
    private int lighting;

    /**
     * Constructor for Room class.
     * @param id identifier of the room
     * @param name name of the room
     * @param area area of the room in square meters
     * @param cube volume of the room in cubic meters
     * @param heating heating energy of the room (per cubic meter)
     * @param lighting lighting power of the room (per square meter)
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

    /**
     * @return heating energy per cubic meter
     */
    @Override
    public float getHeatingEnergy() {
        return heating / getVolume();
    }

    /**
     * @return lighting power per square meter
     */
    @Override
    public float getLightingPower() {
        return (float) lighting / getArea();
    }


    /**
     * @param limit heating energy limit
     * @return list containing this room if it exceeds limit or null otherwise
     */
    @Override
    public List<Room> getRoomsExceedingHeatingEnergy(float limit) {
        return getHeatingEnergy() > limit
                ? List.of(this)
                : null;
    }



}
