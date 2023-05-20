package pl.put.poznan.building.classes;

import java.util.List;

/**
 * This is an abstract class representing a location.
 *
 */
public abstract class Location {

    private final int id;
    private final String name;


    /**
     * Constructor of Location class.
     *
     * @param id   id of the location
     * @param name name of the location
     */
    public Location(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract int getArea();

    public abstract int getVolume();

    public abstract float getHeatingEnergy();

    public abstract int getLightingPower();

    public abstract List<Room> getRoomsExceedingHeatingEnergy(float limit);

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
