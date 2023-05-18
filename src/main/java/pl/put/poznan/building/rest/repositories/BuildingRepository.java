package pl.put.poznan.building.rest.repositories;

import org.springframework.stereotype.Service;
import pl.put.poznan.building.classes.Building;
import pl.put.poznan.building.classes.Level;
import pl.put.poznan.building.classes.Room;
import pl.put.poznan.building.rest.exceptions.models.BuildingNotFoundException;
import pl.put.poznan.building.rest.exceptions.models.LevelNotFoundException;
import pl.put.poznan.building.rest.exceptions.models.RoomNotFoundException;

@Service
public class BuildingRepository {

    public Building getBuildingById(int id) {
        if (!Building.buildingMap.containsKey(id)) {
            throw new BuildingNotFoundException();
        }

        return Building.buildingMap.get(id);
    }

    public Level getLevelById(int id) {
        if (!Level.levelMap.containsKey(id)) {
            throw new LevelNotFoundException();
        }

        return Level.levelMap.get(id);
    }

    public Room getRoomById(int id) {
        if (!Room.roomMap.containsKey(id)) {
            throw new RoomNotFoundException();
        }

        return Room.roomMap.get(id);
    }

}
