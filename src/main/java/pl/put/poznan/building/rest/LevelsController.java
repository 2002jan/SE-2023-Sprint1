package pl.put.poznan.building.rest;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.building.classes.Level;
import pl.put.poznan.building.dto.LocationDto;

@RestController
@RequestMapping("/levels")
public class LevelsController {

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
        return new LocationDto(Level.levelMap.get(id));
    }

    @RequestMapping(value = "/{id}/rooms", method = RequestMethod.GET)
    public String getRoomsFromLevel(@PathVariable int id) {
        return "All rooms from level: " + id;
    }

    @RequestMapping(value = "/{id}/area", method = RequestMethod.GET)
    public String getAreaForLevel(@PathVariable int id) {
        return "getArea for Level with id: " + id;
    }

    @RequestMapping(value = "/{id}/volume", method = RequestMethod.GET)
    public String getVolumeForLevel(@PathVariable int id) {
        return "getVolume for Level with id: " + id;
    }

    @RequestMapping(value = "/{id}/heating_energy", method = RequestMethod.GET)
    public String getHeatingEnergyForLevel(@PathVariable int id) {
        return "getHeatingEnergy for Level with id: " + id;
    }

    @RequestMapping(value = "/{id}/lighting_power", method = RequestMethod.GET)
    public String getLightingPowerForLevel(@PathVariable int id) {
        return "getLightingPower for Level with id: " + id;
    }

    @RequestMapping(value = "/{id}/rooms_exceeding", 
        method = RequestMethod.GET, params = {"heating_energy"})
    public String getRoomsExeceedingHeatingEnergyForLevel(@PathVariable int id,
    @RequestParam(value = "heating_energy") int heating_energy) {
        return "Get rooms in Level id: " + id + " exceeding heating energy: " + heating_energy;
    }
}
