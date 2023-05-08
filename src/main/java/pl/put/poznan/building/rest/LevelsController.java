package pl.put.poznan.building.rest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/levels")
public class LevelsController {

    @RequestMapping(method = RequestMethod.GET)
    public String getAllLevels() {
        return "All levels";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getLevel(@PathVariable int id) {
        return "Level with id " + id;
    }

    @RequestMapping(value = "/{id}/rooms", method = RequestMethod.GET)
    public String getRoomsFromLevel(@PathVariable int id) {
        return "All rooms from level: " + id;
    }
}
