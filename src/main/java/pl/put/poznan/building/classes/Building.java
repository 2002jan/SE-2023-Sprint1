package pl.put.poznan.building.classes;

import java.util.List;

public class Building extends Location{

    private List<Level> levels;

    public Building(int id, String name, List<Level> levels) {
        super(id, name);
        this.levels = levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    @Override
    public String toString() {
        return "Building{" +
                "levels=" + levels +
                '}';
    }


    public void addLevel(Level level){
        throw new UnsupportedOperationException("Not supported yet.");
    }


    public void removeLevel(Level level){
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Level> getLevels() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
