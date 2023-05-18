package pl.put.poznan.building.rest.exceptions.models;

import pl.put.poznan.building.rest.exceptions.NotFoundException;

public class LevelNotFoundException extends NotFoundException {
    public LevelNotFoundException() {
        super("Level not found");
    }
}
