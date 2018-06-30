package controllers;

import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;

@RestController
public class Controller {
    private Logger logger = LoggerFactory.getLogger(Controller.class);



    @RequestMapping(value = "points/create", method = RequestMethod.POST, headers = "Accept=application/json")
    public @ResponseBody
    PointDTO newPoint(@RequestBody PointDTO point) {
        logger.info("Поехали");
        String strLog = "autoId: " + point.getAutoId() + " lon = " + point.getLon() + " lat = " + point.getLat();
        logger.info(strLog);
        try (FileWriter writer = new FileWriter ("tracks.txt", true)) {
            writer.write(point.toString ());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return point;
    }
}