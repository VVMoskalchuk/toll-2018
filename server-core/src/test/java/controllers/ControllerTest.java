package controllers;

import jdev.dto.PointDTO;
import org.junit.Test;

import static org.junit.Assert.*;

public class ControllerTest {

    @Test
    public void newPoint() {


        PointDTO pointDTO = new PointDTO();
        pointDTO.setLon(40);
        pointDTO.setLat(81);
        pointDTO.setAutoId("NOMER_AUTO");

        PointDTO result = new Controller().newPoint(pointDTO);
        assertNotNull(result);
        assertEquals(result.getAutoId(),"NOMER_AUTO");
        assertEquals(result.getLat(),81, 0);
        assertEquals(result.getLon(),40, 0);

    }
}