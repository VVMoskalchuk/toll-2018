package jdev.tracker.services;

import java.io.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by jdev on 26.03.2017.
 */
@Service
public class ServiceStorage {

    @Autowired
    private ServiceGPS serviceGPS;
  //  private BlockingDeque<String> queue =  new LinkedBlockingDeque<> (100);

    @PostConstruct
    private void init() throws IOException, InterruptedException {
        serviceGPS.readFileCoordinates ();
        serviceGPS.serviceStorage ();

}


}
