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
}
