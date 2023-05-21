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

    @RequestMapping(method = RequestMethod.GET)
    public Object[] getAllRooms() {
        logger.debug("Getting all rooms");
        return Room.roomMap
                .values()
                .stream()
                .map(LocationDto::new)
                .toArray();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public LocationDto getRoom(@PathVariable int id) {
        logger.debug("Getting room with id: {}", id);
        return new LocationDto(repository.getRoomById(id));
    }

    @RequestMapping(value = "/{id}/area", method = RequestMethod.GET)
    public int getAreaForRoom(@PathVariable int id) {
        logger.debug("Getting area from room with id: {}", id);
        return repository.getRoomById(id).getArea();

    }

    @RequestMapping(value = "/{id}/volume", method = RequestMethod.GET)
    public int getVolumeForRoom(@PathVariable int id) {
        logger.debug("Getting volume from room with id: {}", id);
        return repository.getRoomById(id).getVolume();
    }

    @RequestMapping(value = "/{id}/heating_energy", method = RequestMethod.GET)
    public float getHeatingEnergyForRoom(@PathVariable int id) {
        logger.debug("Getting heating energy from room with id: {}", id);
        return repository.getRoomById(id).getHeatingEnergy();
    }

    @RequestMapping(value = "/{id}/lighting_power", method = RequestMethod.GET)
    public float getLightingPowerForRoom(@PathVariable int id) {
        logger.info("Getting lighting power from room with id: {}", id);
        return repository.getRoomById(id).getLightingPower();
    }
}
