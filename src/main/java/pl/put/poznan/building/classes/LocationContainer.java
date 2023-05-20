package pl.put.poznan.building.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * This is an abstract class representing a location container.
 * It extends Location class.
 * It is treated as a container in composite design pattern.
 */
public abstract class LocationContainer extends Location {

    private final List<Location> locations = new ArrayList<>();

    /**
     * Constructor of LocationContainer class.
     *
     * @param id   id of the location container
     * @param name name of the location container
     */
    public LocationContainer(int id, String name) {
        super(id, name);
    }


    /**
     * This protected method adds a location to the locations list.
     *
     * @param location location to be added
     */
    protected void addLocation(Location location) {
        locations.add(location);
    }


    protected List<Location> getLocations() {
        return locations;
    }


    /**
     * This method returns area of a location.
     *
     * @return area of the location container
     */
    public int getArea() {

        return locations.stream()
                .mapToInt(Location::getArea)
                .sum();
    }

    /**
     * This method returns volume of a location.
     *
     * @return volume of the location container
     */
    public int getVolume() {

        return locations.stream()
                .mapToInt(Location::getVolume)
                .sum();
    }

    /**
     * This method returns heating energy of a location.
     *
     * @return heating energy of the location container
     */
    public float getHeatingEnergy() {
        double energy = locations.stream()
                .mapToDouble(Location::getHeatingEnergy)
                .sum();

        return (float) energy;
    }

    /**
     * This method returns lighting power of a location.
     *
     * @return lighting power of the location container
     */
    public int getLightingPower() {

        return locations.stream()
                .mapToInt(Location::getLightingPower)
                .sum();
    }

    /**
     * This method returns a list of rooms exceeding a given heating energy.
     *
     * @param limit heating energy limit
     * @return list of rooms exceeding a given heating energy limit
     */
    public List<Room> getRoomsExceedingHeatingEnergy(float limit) {

        List<Room> rooms_exceeding = new ArrayList<>();

        for (Location l : locations) {
            rooms_exceeding.addAll(l.getRoomsExceedingHeatingEnergy(limit));
        }

        return rooms_exceeding;
    }

}
