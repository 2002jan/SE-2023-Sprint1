package pl.put.poznan.building.classes;

import java.util.List;

public abstract class Location {

    private final int id;
    private final String name;


    public Location(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract int getArea();

    public abstract int getVolume();

    public abstract float getHeatingEnergy();

    public abstract int getLightingPower();

    public List<Room> getRoomsExceedingHeatingEnergy(float limit) {
        return null;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
