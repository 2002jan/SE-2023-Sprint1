package pl.put.poznan.building.classes;

import java.util.ArrayList;
import java.util.List;

public abstract class LocationContainer extends Location {

    private List<Location> locations;

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

        return (float) energy;
    }

    public int getLightingPower() {

        return locations.stream()
                .mapToInt(Location::getLightingPower)
                .sum();
    }

    public List<Room> getRoomsExceedingHeatingEnergy(float limit) {

        List<Room> rooms_exceeding = new ArrayList<>();

        for (Location l : locations) {
            rooms_exceeding.addAll(l.getRoomsExceedingHeatingEnergy(limit));
        }

        return rooms_exceeding;
    }

}