package pl.put.poznan.building.classes;

import java.util.List;

public abstract class Location {

    private int id;
    private String name;


    public Location(int id, String name) {
        this.id = id;
        this.name = name;
    }




    public int getArea(){
        return 0;
    }

    public int getVolume(){
        return 0;
    }

    public float getHeatingEnergy(){
        return 0;
    }

    public int getLightingPower(){
        return 0;
    }

    public List<Room> getRoomsExceedingHeatingEnergy(float limit){
        return null;
    }



    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
