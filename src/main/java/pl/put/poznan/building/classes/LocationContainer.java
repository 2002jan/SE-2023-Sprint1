package pl.put.poznan.building.classes;


import java.util.List;

public abstract class LocationContainer extends Location {

    public LocationContainer(int id, String name) {
        super(id, name);
    }

    protected void addLocation(Location location){
        throw new UnsupportedOperationException("Not implemented yet");
    }


    protected List<Location> getLocations(){
        throw new UnsupportedOperationException("Not implemented yet");
    }


    public  int getArea(){
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

    public List<Room> getRoomsExceedingHeatingEnergy(float limit) {
        return null;
    }


}
