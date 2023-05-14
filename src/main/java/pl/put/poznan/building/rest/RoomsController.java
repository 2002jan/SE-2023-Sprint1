package pl.put.poznan.building.rest;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.building.classes.Room;
import pl.put.poznan.building.dto.LocationDto;

@RestController
@RequestMapping("/rooms")
public class RoomsController {

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
        return new LocationDto(Room.roomMap.get(id));
    }

    @RequestMapping(value = "/{id}/area", method = RequestMethod.GET)
    public String getAreaForRoom(@PathVariable int id) {
        return "getArea for Room with id: " + id;
    }

    @RequestMapping(value = "/{id}/volume", method = RequestMethod.GET)
    public String getVolumeForRoom(@PathVariable int id) {
        return "getVolume for Room with id: " + id;
    }

    @RequestMapping(value = "/{id}/heating_energy", method = RequestMethod.GET)
    public String getHeatingEnergyForRoom(@PathVariable int id) {
        return "getHeatingEnergy for Room with id: " + id;
    }

    @RequestMapping(value = "/{id}/lighting_power", method = RequestMethod.GET)
    public String getLightingPowerForRoom(@PathVariable int id) {
        return "getLightingPower for Room with id: " + id;
    }

    @RequestMapping(value = "/{id}/exceeding", 
        method = RequestMethod.GET, params = {"heating_energy"})
    public String isRoomExceeding(@PathVariable int id,
    @RequestParam(value = "heating_energy") int heating_energy) {
        return "Is room with: " + id + " exceeding heating energy: " + heating_energy;
    }
}
