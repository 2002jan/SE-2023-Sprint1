package pl.put.poznan.building.rest.exceptions.models;

import pl.put.poznan.building.rest.exceptions.NotFoundException;

public class RoomNotFoundException extends NotFoundException {
    public RoomNotFoundException() {
        super("Room not found");
    }
}
