package services;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class ServiceGPSTest {

    private ServiceGPS serviceGPS;


    @Test
    public void allCoordinates() throws IOException, InterruptedException {
        serviceGPS  = new ServiceGPS();
        assertNotNull(serviceGPS.allCoordinates("coordinates.txt"));
        assertEquals(40, serviceGPS.allCoordinates("coordinates.txt").size());

    }
}