package pl.put.poznan.building.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class LocationContainer extends Location {

    private final List<Location> locations = new ArrayList<>();

    public LocationContainer(int id, String name) {
        super(id, name);
    }


    protected void addLocation(Location location) {
        locations.add(location);
    }


    protected List<Location> getLocations() {
        return locations;
    }


    public int getArea() {

        return locations.stream()
                .mapToInt(Location::getArea)
                .sum();
    }

    public int getVolume() {

        return locations.stream()
                .mapToInt(Location::getVolume)
                .sum();
    }

    public float getHeatingEnergy() {
        double energy = locations.stream()
                .mapToDouble(Location::getHeatingEnergy)
                .sum();

        return ((float) energy) / locations.size();
    }

    public float getLightingPower() {

        double power = locations.stream()
                .mapToDouble(Location::getLightingPower)
                .sum();

        return ((float) power) / locations.size();
    }

    public List<Room> getRoomsExceedingHeatingEnergy(float limit) {
        List<Room> roomsExceeding = new ArrayList<>();

        for (Location l : locations) {
            Optional.ofNullable(l.getRoomsExceedingHeatingEnergy(limit)).ifPresent(roomsExceeding::addAll);
        }

        return roomsExceeding;
    }

}
