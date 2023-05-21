package pl.put.poznan.building.rest.exceptions.models;

import pl.put.poznan.building.rest.exceptions.NotFoundException;

/**
 * This exception indicates that given Level does not exist
 */
public class LevelNotFoundException extends NotFoundException {
    public LevelNotFoundException() {
        super("Level not found");
    }
}
