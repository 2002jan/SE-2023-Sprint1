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

    /**
     * @return Area of a Location instance
     */
    public abstract int getArea();

    /**
     * @return Volume of a Location instance
     */
    public abstract int getVolume();

    /**
     * @return Average heating energy per m^3 of a Location instance
     */
    public abstract float getHeatingEnergy();

    /**
     * @return Average lighting power per m^2 of a Location instance
     */
    public abstract float getLightingPower();

    /**
     * Returns list of all rooms that exceeds given level of heating energy per m^2
     *
     * @param limit Limit of heating energy
     * @return List of rooms that use more heating energy per m^2 than that of a limit
     */
    public abstract List<Room> getRoomsExceedingHeatingEnergy(float limit);

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
