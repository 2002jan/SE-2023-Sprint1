package pl.put.poznan.building.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.building.classes.Building;
import pl.put.poznan.building.dto.LocationDto;
import pl.put.poznan.building.rest.repositories.BuildingRepository;

@RestController
@RequestMapping("/buildings")
public class BuildingsController {

    private final BuildingRepository repository;

    @Autowired
    public BuildingsController(BuildingRepository repository) {
        this.repository = repository;
    }

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
        return new LocationDto(repository.getBuildingById(id));
    }

    @RequestMapping(value = "/{id}/levels", method = RequestMethod.GET)
    public String getLevelsFromBuilding(@PathVariable int id) {
        return "All levels from building: " + id;
    }

    @RequestMapping(value = "/{id}/area", method = RequestMethod.GET)
    public int getAreaForBuilding(@PathVariable int id) {
        return repository.getBuildingById(id).getArea();
    }

    @RequestMapping(value = "/{id}/volume", method = RequestMethod.GET)
    public int getVolumeForBuilding(@PathVariable int id) {
        return repository.getBuildingById(id).getVolume();
    }

    @RequestMapping(value = "/{id}/heating_energy", method = RequestMethod.GET)
    public float getHeatingEnergyForBuilding(@PathVariable int id) {
        return repository.getBuildingById(id).getHeatingEnergy();
    }

    @RequestMapping(value = "/{id}/lighting_power", method = RequestMethod.GET)
    public float getLightingPowerForBuilding(@PathVariable int id) {
        return repository.getBuildingById(id).getLightingPower();
    }

    @RequestMapping(value = "/{id}/rooms_exceeding", 
        method = RequestMethod.GET, params = {"heating_energy"})
    public String getRoomsExceedingHeatingEnergyForBuilding(@PathVariable int id,
    @RequestParam(value = "heating_energy") int heating_energy) {
        return "Get rooms in Building id: " + id + " exceeding heating energy: " + heating_energy;
    }
}
