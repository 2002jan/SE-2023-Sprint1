package pl.put.poznan.building.app;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.util.ResourceUtils;
import pl.put.poznan.building.classes.Building;
import pl.put.poznan.building.classes.Level;
import pl.put.poznan.building.classes.Room;

import java.io.IOException;


@SpringBootApplication(scanBasePackages = {"pl.put.poznan.building.rest"})
public class BuildingInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BuildingInfoApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadJson(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode buildingsJson = mapper.readTree(ResourceUtils.getFile("classpath:buildings.json"));
            buildingsJson.forEach(b -> {
                Building building = new Building(b.get("id").asInt(), b.get("name").asText());
                Building.buildingMap.put(building.getId(), building);

                b.get("levels").forEach(l -> {
                    Level level = new Level(l.get("id").asInt(), l.get("name").asText());
                    Level.levelMap.put(level.getId(), level);

                    building.addLevel(level);

                    l.get("rooms").forEach(r -> {
                        Room room = new Room(
                                r.get("id").asInt(),
                                r.get("name").asText(),
                                r.get("area").asInt(),
                                r.get("cube").asInt(),
                                (float) r.get("heating").asDouble(),
                                r.get("lighting").asInt()
                        );
                        Room.roomMap.put(room.getId(), room);

                        level.addRoom(room);
                    });

                });

            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
