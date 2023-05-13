package pl.put.poznan.building.classes;

public class Building extends LocationContainer {


    public Building(int id, String name) {
        super(id, name);
    }

    public void addLevel(Level level) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
