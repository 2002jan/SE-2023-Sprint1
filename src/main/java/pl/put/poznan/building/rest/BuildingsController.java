package pl.put.poznan.building.rest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buildings")
public class BuildingsController {

    @RequestMapping(method = RequestMethod.GET)
    public String getAllBuildings() {
        return "All buildings";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getBuilding(@PathVariable int id) {
        return "Building with id " + id;
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
