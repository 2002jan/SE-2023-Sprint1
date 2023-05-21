package pl.put.poznan.building.rest.exceptions.models;

import pl.put.poznan.building.rest.exceptions.NotFoundException;

/**
 * This exception indicates that given Room does not exist
 */
public class RoomNotFoundException extends NotFoundException {
    public RoomNotFoundException() {
        super("Room not found");
    }
}
