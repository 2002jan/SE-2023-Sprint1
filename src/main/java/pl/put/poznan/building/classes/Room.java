package pl.put.poznan.building.classes;

public class Room extends Location {


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
    public String toString() {
        return "Room{" +
                "area=" + area +
                ", cube=" + cube +
                ", heating=" + heating +
                ", lighting=" + lighting +
                '}';
    }

    @Override
    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getCube() {
        return cube;
    }

    public void setCube(int cube) {
        this.cube = cube;
    }

    public float getHeating() {
        return heating;
    }

    public void setHeating(float heating) {
        this.heating = heating;
    }

    public int getLighting() {
        return lighting;
    }

    public void setLighting(int lighting) {
        this.lighting = lighting;
    }
}
