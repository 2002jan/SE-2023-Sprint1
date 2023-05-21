package pl.put.poznan.building.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class representing a location container
 * It is treated as a container in composite design pattern
 */
public abstract class LocationContainer extends Location {

    private final List<Location> locations = new ArrayList<>();

    /**
     * Constructor of LocationContainer
     * @param id id of the location
     * @param name name of the location
     */
    public LocationContainer(int id, String name) {
        super(id, name);
    }


    /**
     * Adds a location to the container
     * @param location location to be added
     */
    protected void addLocation(Location location) {
        locations.add(location);
    }


    protected List<Location> getLocations() {
        return locations;
    }


    /**
     * @return summed area for all locations that are inside a given location container
     */
    public int getArea() {

        return locations.stream()
                .mapToInt(Location::getArea)
                .sum();
    }

    /**
     * @return summed volume for all locations that are inside a given location container
     */
    public int getVolume() {

        return locations.stream()
                .mapToInt(Location::getVolume)
                .sum();
    }


    /**
     *
     * @return average heating energy per cubic meter of a given location container
     */
    public float getHeatingEnergy() {
        double energy = locations.stream()
                .mapToDouble(Location::getHeatingEnergy)
                .sum();

        return ((float) energy) / locations.size();
    }


    /**
     *
     * @return average lighting power per square meter of a given location container
     */
    public float getLightingPower() {

        double power = locations.stream()
                .mapToDouble(Location::getLightingPower)
                .sum();

        return ((float) power) / locations.size();
    }

    /**
     * Returns a list of rooms exceeding the heating energy limit
     * @param limit heating energy limit
     */
    public List<Room> getRoomsExceedingHeatingEnergy(float limit) {
        List<Room> roomsExceeding = new ArrayList<>();

        for (Location l : locations) {
            Optional.ofNullable(l.getRoomsExceedingHeatingEnergy(limit)).ifPresent(roomsExceeding::addAll);
        }

        return roomsExceeding;
    }

}
