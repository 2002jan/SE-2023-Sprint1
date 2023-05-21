package pl.put.poznan.building.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.building.classes.Room;
import pl.put.poznan.building.dto.LocationDto;
import pl.put.poznan.building.rest.repositories.BuildingRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/rooms")
public class RoomsController {
    private static Logger logger = LoggerFactory.getLogger(Room.class);

    private final BuildingRepository repository;

    @Autowired
    public RoomsController(BuildingRepository repository) {
        this.repository = repository;
    }

    /**
     * @return Array of all rooms in the system
     */
    @RequestMapping(method = RequestMethod.GET)
    public Object[] getAllRooms() {
        logger.debug("Getting all rooms");
        return Room.roomMap
                .values()
                .stream()
                .map(LocationDto::new)
                .toArray();
    }

    /**
     * Retrieves information about room with given ID
     *
     * @param id ID of a Room
     * @return Information about room with given ID
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public LocationDto getRoom(@PathVariable int id) {
        logger.debug("Getting room with id: {}", id);
        return new LocationDto(repository.getRoomById(id));
    }

    /**
     * Retrieves total area of a room with given ID
     *
     * @param id ID of a Room
     * @return Total area of a Room
     */
    @RequestMapping(value = "/{id}/area", method = RequestMethod.GET)
    public int getAreaForRoom(@PathVariable int id) {
        logger.debug("Getting area from room with id: {}", id);
        return repository.getRoomById(id).getArea();

    }

    /**
     * Retrieves total volume of a room with given ID
     *
     * @param id ID of a Room
     * @return Total volume of a Room
     */
    @RequestMapping(value = "/{id}/volume", method = RequestMethod.GET)
    public int getVolumeForRoom(@PathVariable int id) {
        logger.debug("Getting volume from room with id: {}", id);
        return repository.getRoomById(id).getVolume();
    }

    /**
     * Retrieves heating energy per m^3 of a room with given ID
     *
     * @param id ID of a Room
     * @return Heating energy of a Room
     */
    @RequestMapping(value = "/{id}/heating_energy", method = RequestMethod.GET)
    public float getHeatingEnergyForRoom(@PathVariable int id) {
        logger.debug("Getting heating energy from room with id: {}", id);
        return repository.getRoomById(id).getHeatingEnergy();
    }

    /**
     * Retrieves lighting power per m^2 of a room with given ID
     *
     * @param id ID of a Room
     * @return Lighting power of a Room
     */
    @RequestMapping(value = "/{id}/lighting_power", method = RequestMethod.GET)
    public float getLightingPowerForRoom(@PathVariable int id) {
        logger.info("Getting lighting power from room with id: {}", id);
        return repository.getRoomById(id).getLightingPower();
    }
}
