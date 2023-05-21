package pl.put.poznan.building.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.building.classes.Level;
import pl.put.poznan.building.dto.LocationDto;
import pl.put.poznan.building.rest.repositories.BuildingRepository;

@RestController
@RequestMapping("/levels")
public class LevelsController {

    private final BuildingRepository repository;

    @Autowired
    public LevelsController(BuildingRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object[] getAllLevels() {
        return Level.levelMap
                .values()
                .stream()
                .map(LocationDto::new)
                .toArray();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public LocationDto getLevel(@PathVariable int id) {
        return new LocationDto(repository.getLevelById(id));
    }

    @RequestMapping(value = "/{id}/rooms", method = RequestMethod.GET)
    public Object[] getRoomsFromLevel(@PathVariable int id) {
        return repository.getLevelById(id)
                .getLocations()
                .stream()
                .map(LocationDto::new)
                .toArray();
    }

    @RequestMapping(value = "/{id}/area", method = RequestMethod.GET)
    public int getAreaForLevel(@PathVariable int id) {
        return repository.getLevelById(id).getArea();
    }

    @RequestMapping(value = "/{id}/volume", method = RequestMethod.GET)
    public float getVolumeForLevel(@PathVariable int id) {
        return repository.getLevelById(id).getVolume();
    }

    @RequestMapping(value = "/{id}/heating_energy", method = RequestMethod.GET)
    public float getHeatingEnergyForLevel(@PathVariable int id) {
        return repository.getLevelById(id).getHeatingEnergy();
    }

    @RequestMapping(value = "/{id}/lighting_power", method = RequestMethod.GET)
    public float getLightingPowerForLevel(@PathVariable int id) {
        return repository.getLevelById(id).getLightingPower();
    }
}
