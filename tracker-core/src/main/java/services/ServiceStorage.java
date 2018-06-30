package services;

import java.io.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


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
