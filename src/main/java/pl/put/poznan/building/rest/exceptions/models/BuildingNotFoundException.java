package pl.put.poznan.building.rest.exceptions.models;

import pl.put.poznan.building.rest.exceptions.NotFoundException;

/**
 * This exception indicates that given Building does not exist
 */
public class BuildingNotFoundException extends NotFoundException {
    public BuildingNotFoundException() {
        super("Building not found");
    }
}
