package pl.put.poznan.building.rest.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import pl.put.poznan.building.classes.Building;
import pl.put.poznan.building.classes.Level;
import pl.put.poznan.building.classes.Room;
import pl.put.poznan.building.rest.exceptions.models.BuildingNotFoundException;
import pl.put.poznan.building.rest.exceptions.models.LevelNotFoundException;
import pl.put.poznan.building.rest.exceptions.models.RoomNotFoundException;

/**
 * This repository is used to query Locations based on their IDs
 */
@Service
public class BuildingRepository {

    /**
     * Stores application logger
     */
    private static Logger logger = LoggerFactory.getLogger(Room.class);

    /**
     * Retrieves building based on its ID
     *
     * @param id ID of a Building
     * @return Building model with a given ID
     */
    public Building getBuildingById(int id) {
        if (!Building.buildingMap.containsKey(id)) {
            logger.warn("Building with ID {} was not found", id);
            throw new BuildingNotFoundException();
        }

        logger.info("Found building with ID {}", id);
        return Building.buildingMap.get(id);
    }

    /**
     * Retrieves level based on its ID
     *
     * @param id ID of a Level
     * @return Level model with a given ID
     */
    public Level getLevelById(int id) {
        if (!Level.levelMap.containsKey(id)) {
            logger.warn("Level with ID {} was not found", id);
            throw new LevelNotFoundException();
        }
        logger.info("Found level with ID {}", id);
        return Level.levelMap.get(id);
    }

    /**
     * Retrieves room based on its ID
     *
     * @param id ID of a room
     * @return Room model with a given ID
     */
    public Room getRoomById(int id) {
        if (!Room.roomMap.containsKey(id)) {
            logger.warn("Room with ID {} was not found", id);
            throw new RoomNotFoundException();
        }
        logger.info("Found room with ID {}", id);
        return Room.roomMap.get(id);
    }

}
