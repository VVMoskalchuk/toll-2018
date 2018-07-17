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


    }

    @Test
    public void readFileCoordinates() {
    }

    @Test
    public void serviceStorage() {
    }

    @Test
    public void allCoordinates1() {
    }

    @Test
    public void readFileCoordinates1() {
    }

    @Test
    public void serviceStorage1() {
    }
}