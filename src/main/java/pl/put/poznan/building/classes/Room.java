package pl.put.poznan.building.classes;

import java.lang.reflect.Array;
import java.util.*;

public class Room extends Location {

    public static HashMap<Integer, Room> roomMap = new HashMap<>();

    private int area;
    private int cube;
    private float heating;
    private int lighting;

    public Room(int id, String name, int area, int cube, float heating, int lighting) {
        super(id, name);
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.lighting = lighting;
    }

    @Override
    public int getArea() {
        return area;
    }

    @Override
    public int getVolume() {
        return cube;
    }

    @Override
    public float getHeatingEnergy() {
        return heating;
    }

    @Override
    public int getLightingPower() {
        return lighting;
    }

    @Override
    public List<Room> getRoomsExceedingHeatingEnergy(float limit) {
        return getHeatingEnergy() / getVolume() > limit
                ? List.of(this)
                : null;
    }



}
