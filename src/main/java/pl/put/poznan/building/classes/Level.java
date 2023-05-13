package pl.put.poznan.building.classes;

public class Level extends LocationContainer {

    public Level(int id, String name) {
        super(id, name);
    }

    public void addRoom(Room room) {
        this.addLocation(room);
    }

}
