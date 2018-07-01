package services;

import java.io.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ServiceStorage {

    private static final Logger log = LoggerFactory.getLogger(ServiceStorage.class);
    private BlockingDeque <PointDTO> queue =  new LinkedBlockingDeque <PointDTO> (1000);

    @Autowired
    private ServiceGPS serviceGPS;



     public BlockingDeque <PointDTO> allCoordinates() throws IOException, InterruptedException {
        String line = null;
        BufferedReader br = new BufferedReader(new FileReader("coordinates.txt"));
        PointDTO objPoint = new PointDTO ();
        while((line = br.readLine()) != null){
            log.info ( "Зашел" );
            objPoint.setAutoId ("к422вн186rus" );
            String[] M = line.split ( ";" );
            objPoint.setLat( Double.parseDouble ( ( M[0] ) ) );
            objPoint.setLon ( Double.parseDouble ( M[1] ));
            queue.put(objPoint);
        }

         return queue;

    }


}

