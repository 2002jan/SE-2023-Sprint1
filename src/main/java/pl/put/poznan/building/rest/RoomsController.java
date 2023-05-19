package pl.put.poznan.building.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.building.classes.Room;
import pl.put.poznan.building.dto.LocationDto;
import pl.put.poznan.building.rest.repositories.BuildingRepository;

@RestController
@RequestMapping("/rooms")
public class RoomsController {

    private final BuildingRepository repository;

    @Autowired
    public RoomsController(BuildingRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object[] getAllRooms() {
        return Room.roomMap
                .values()
                .stream()
                .map(LocationDto::new)
                .toArray();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public LocationDto getRoom(@PathVariable int id) {
        return new LocationDto(repository.getRoomById(id));
    }

    @RequestMapping(value = "/{id}/area", method = RequestMethod.GET)
    public int getAreaForRoom(@PathVariable int id) {
        return repository.getRoomById(id).getArea();

    }

    @RequestMapping(value = "/{id}/volume", method = RequestMethod.GET)
    public int getVolumeForRoom(@PathVariable int id) {
        return repository.getRoomById(id).getVolume();
    }

    @RequestMapping(value = "/{id}/heating_energy", method = RequestMethod.GET)
    public float getHeatingEnergyForRoom(@PathVariable int id) {
        return repository.getRoomById(id).getHeatingEnergy();
    }

    @RequestMapping(value = "/{id}/lighting_power", method = RequestMethod.GET)
    public int getLightingPowerForRoom(@PathVariable int id) {
        return repository.getRoomById(id).getLightingPower();
    }


    @RequestMapping(value = "/{id}/exceeding", 
        method = RequestMethod.GET, params = {"heating_energy"})
    public String isRoomExceeding(@PathVariable int id,
    @RequestParam(value = "heating_energy") int heating_energy) {
        return "Is room with: " + id + " exceeding heating energy: " + heating_energy;
    }
}
