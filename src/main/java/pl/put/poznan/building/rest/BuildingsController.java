package pl.put.poznan.building.rest;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.building.classes.Building;
import pl.put.poznan.building.dto.LocationDto;

@RestController
@RequestMapping("/buildings")
public class BuildingsController {

    @RequestMapping(method = RequestMethod.GET)
    public Object[] getAllBuildings() {
        return Building.buildingMap
                .values()
                .stream()
                .map(LocationDto::new)
                .toArray();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public LocationDto getBuilding(@PathVariable int id) {
        return new LocationDto(Building.buildingMap.get(id));
    }

    @RequestMapping(value = "/{id}/levels", method = RequestMethod.GET)
    public String getLevelsFromBuilding(@PathVariable int id) {
        return "All levels from building: " + id;
    }

    @RequestMapping(value = "/{id}/area", method = RequestMethod.GET)
    public String getAreaForBuilding(@PathVariable int id) {
        return "getArea for Building with id: " + id;
    }

    @RequestMapping(value = "/{id}/volume", method = RequestMethod.GET)
    public String getVolumeForBuilding(@PathVariable int id) {
        return "getVolume for Building with id: " + id;
    }

    @RequestMapping(value = "/{id}/heating_energy", method = RequestMethod.GET)
    public String getHeatingEnergyForBuilding(@PathVariable int id) {
        return "getHeatingEnergy for Building with id: " + id;
    }

    @RequestMapping(value = "/{id}/lighting_power", method = RequestMethod.GET)
    public String getLightingPowerForBuilding(@PathVariable int id) {
        return "getLightingPower for Building with id: " + id;
    }

    @RequestMapping(value = "/{id}/rooms_exceeding", 
        method = RequestMethod.GET, params = {"heating_energy"})
    public String getRoomsExeceedingHeatingEnergyForBuilding(@PathVariable int id,
    @RequestParam(value = "heating_energy") int heating_energy) {
        return "Get rooms in Building id: " + id + " exceeding heating energy: " + heating_energy;
    }
}
