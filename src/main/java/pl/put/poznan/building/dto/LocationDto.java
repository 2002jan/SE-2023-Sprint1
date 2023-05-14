package pl.put.poznan.building.dto;

import pl.put.poznan.building.classes.Location;

public class LocationDto {

    private final int id;

    private final String name;

    public LocationDto(Location location)
    {
        id = location.getId();
        name = location.getName();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
