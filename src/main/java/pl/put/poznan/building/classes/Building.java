package pl.put.poznan.building.classes;

import java.util.ArrayList;
import java.util.List;

public class Building extends Location {

    private final List<Level> levels;

    public Building(int id, String name, List<Level> levels) {
        super(id, name);
        this.levels = new ArrayList<Level>();
    }


    public void addLevel(Level level) {
        levels.add(level);
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void removeLevel(Level level) {
        levels.remove(level);
    }

    @Override
    public int getArea() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getVolume() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public float getHeatingEnergy() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getLightingPower() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
