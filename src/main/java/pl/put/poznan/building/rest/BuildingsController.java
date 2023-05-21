package pl.put.poznan.building.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.building.classes.Building;
import pl.put.poznan.building.dto.LocationDto;
import pl.put.poznan.building.rest.repositories.BuildingRepository;

/**
 * Controller for all endpoints regarding building model
 */
@RestController
@RequestMapping("/buildings")
public class BuildingsController {
    private static Logger logger = LoggerFactory.getLogger(Building.class);

    private final BuildingRepository repository;

    @Autowired
    public BuildingsController(BuildingRepository repository) {
        this.repository = repository;
    }

    /**
     * @return Array of all buildings in the system
     */
    @RequestMapping(method = RequestMethod.GET)
    public Object[] getAllBuildings() {
        logger.debug("Getting all buildings");
        return Building.buildingMap
                .values()
                .stream()
                .map(LocationDto::new)
                .toArray();
    }

    /**
     * Retrieves information about building with given ID
     *
     * @param id ID of a Building
     * @return Information about building with given ID
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public LocationDto getBuilding(@PathVariable int id) {
        logger.debug("Getting building with id: {}", id);
        return new LocationDto(repository.getBuildingById(id));
    }

    /**
     * Retrieves list of all levels of a building with given ID
     *
     * @param id ID of a Building
     * @return Array of all Levels from building with given ID
     */
    @RequestMapping(value = "/{id}/levels", method = RequestMethod.GET)
    public Object[] getLevelsFromBuilding(@PathVariable int id) {
        logger.debug("Getting levels from building with id: {}", id);
        return repository.getBuildingById(id)
                .getLocations()
                .stream()
                .map(LocationDto::new)
                .toArray();
    }

    /**
     * Retrieves total area of a building with given ID
     *
     * @param id ID of a Building
     * @return Total area of a Building
     */
    @RequestMapping(value = "/{id}/area", method = RequestMethod.GET)
    public int getAreaForBuilding(@PathVariable int id) {
        logger.debug("Getting area from building with id: {}", id);
        return repository.getBuildingById(id).getArea();
    }

    /**
     * Retrieves total volume of a building with given ID
     *
     * @param id ID of a Building
     * @return Total volume of a Building
     */
    @RequestMapping(value = "/{id}/volume", method = RequestMethod.GET)
    public int getVolumeForBuilding(@PathVariable int id) {
        logger.debug("Getting volume from building with id: {}", id);
        return repository.getBuildingById(id).getVolume();
    }

    /**
     * Retrieves average heating energy per m^3 of a building with given ID
     *
     * @param id ID of a Building
     * @return Average heating energy of a Building
     */
    @RequestMapping(value = "/{id}/heating_energy", method = RequestMethod.GET)
    public float getHeatingEnergyForBuilding(@PathVariable int id) {
        logger.debug("Getting heating energy from building with id: {}", id);
        return repository.getBuildingById(id).getHeatingEnergy();
    }

    /**
     * Retrieves average lighting power per m^2 of a building with given ID
     *
     * @param id ID of a Building
     * @return Average lighting power of a Building
     */
    @RequestMapping(value = "/{id}/lighting_power", method = RequestMethod.GET)
    public float getLightingPowerForBuilding(@PathVariable int id) {
        logger.debug("Getting lighting power from building with id: {}", id);
        return repository.getBuildingById(id).getLightingPower();
    }

    /**
     * Retrieves list of all rooms from building with given ID, that exceed given level of heating energy per m^3
     *
     * @param id ID of a Building
     * @param heatingEnergyLimit Limit of heating energy
     * @return Array of rooms that exceed given limit
     */
    @RequestMapping(value = "/{id}/rooms_exceeding/{limit}",
            method = RequestMethod.GET)
    public Object[] getRoomsExceedingHeatingEnergyForBuilding(@PathVariable int id, @PathVariable(value = "limit") int heatingEnergyLimit) {
        logger.info("Getting rooms exceeding heating energy limit from building with id: {}", id);
        return repository.getBuildingById(id).getRoomsExceedingHeatingEnergy(heatingEnergyLimit)
                .stream()
                .map(LocationDto::new)
                .toArray();
    }
}
