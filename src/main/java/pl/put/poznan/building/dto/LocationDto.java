package pl.put.poznan.building.dto;

import pl.put.poznan.building.classes.Location;

/**
 * This DTO is used to limit information returned in API responses
 */
public class LocationDto {

    /**
     * ID of a Location
     */
    private final int id;

    /**
     * Name of a Location
     */
    private final String name;

    /**
     * Creates new LocationDto instance based on Location instance
     *
     * @param location Location instance that will be used to create instance of this class
     */
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
