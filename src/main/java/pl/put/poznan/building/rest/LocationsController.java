package pl.put.poznan.building.rest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/locations")
public class LocationsController {

    @RequestMapping(method = RequestMethod.GET)
    public String getAllLocations() {
        return "All locations";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getLocation(@PathVariable int id) {
        return "Location with id " + id;
    }

    @RequestMapping(value = "/{id}/area", method = RequestMethod.GET)
    public String getAreaForLocation(@PathVariable int id) {
        return "getArea for location with id: " + id;
    }

    @RequestMapping(value = "/{id}/volume", method = RequestMethod.GET)
    public String getVolumeForLocation(@PathVariable int id) {
        return "getVolume for location with id: " + id;
    }

    @RequestMapping(value = "/{id}/heating_energy", method = RequestMethod.GET)
    public String getHeatingEnergyForLocation(@PathVariable int id) {
        return "getHeatingEnergy for location with id: " + id;
    }

    @RequestMapping(value = "/{id}/lighting_power", method = RequestMethod.GET)
    public String getLightingPowerForLocation(@PathVariable int id) {
        return "getLightingPower for location with id: " + id;
    }

    @RequestMapping(value = "/{id}/rooms_exceeding", 
        method = RequestMethod.GET, params = {"heating_energy"})
    public String getRoomsExeceedingHeatingEnergyForLocation(@PathVariable int id,
    @RequestParam(value = "heating_energy") int heating_energy) {
        return "Get rooms in location id: " + id + "exceeding heating energy: " + heating_energy;
    }
}