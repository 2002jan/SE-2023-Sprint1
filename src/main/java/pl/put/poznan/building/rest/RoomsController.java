package pl.put.poznan.building.rest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rooms")
public class RoomsController {

    @RequestMapping(method = RequestMethod.GET)
    public String getAllRooms() {
        return "All rooms";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getRoom(@PathVariable int id) {
        return "Room with id " + id;
    }
}
