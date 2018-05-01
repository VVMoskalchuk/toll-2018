package jdev.tracker.services;

import java.io.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

import jdev.dto.PointDTO;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by jdev on 26.03.2017.
 */
@Service
public class ServiceGPS {

    private BlockingDeque <String> queue =  new LinkedBlockingDeque <String> (100);
    FileWriter writer;

    {
        try {
            writer = new FileWriter("StorageData.txt", false);
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }


    //тут перадаем  в очередь
    @Scheduled(fixedDelay = 2000)
    void readFileCoordinates() throws InterruptedException, IOException {
        String line = null;
        BufferedReader br = new BufferedReader(new FileReader("coordinates.txt"));
        while((line = br.readLine()) != null){
            queue.put(line.toString ());
        }

    }

    @Scheduled(fixedDelay = 5000)
    void serviceStorage() throws InterruptedException, IOException {
      //  System.out.println (queue.take());
        String text = queue.take();
        writer.write( String.valueOf ( text ) );
        writer.append('\n');
        writer.flush();
    }

}





