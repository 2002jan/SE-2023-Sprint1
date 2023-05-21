package pl.put.poznan.building.classes;

import java.util.List;

/**
 * Class representing a location
 */
public abstract class Location {

    private final int id;
    private final String name;


    /**
     * Constructor of Location
     * @param id id of the location
     * @param name name of the location
     */
    public Location(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract int getArea();

    public abstract int getVolume();

    public abstract float getHeatingEnergy();

    public abstract float getLightingPower();

    public abstract List<Room> getRoomsExceedingHeatingEnergy(float limit);

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
