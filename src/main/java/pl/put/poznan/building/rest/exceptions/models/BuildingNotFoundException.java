package pl.put.poznan.building.rest.exceptions.models;

import pl.put.poznan.building.rest.exceptions.NotFoundException;

public class BuildingNotFoundException extends NotFoundException {
    public BuildingNotFoundException() {
        super("Building not found");
    }
}
