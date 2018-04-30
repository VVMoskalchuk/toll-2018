package jdev.tracker.services;

import java.io.*;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by jdev on 26.03.2017.
 */
@Service
public class ServiceGPS {

    private BlockingDeque<String> queue =  new LinkedBlockingDeque<> (100);

    //тут перадаем  в очередь
    @Scheduled(fixedDelay = 2000)
    void readFileCoordinates() throws InterruptedException, IOException {
        String line = null;
        BufferedReader br = new BufferedReader(new FileReader("coordinates.txt"));
        while((line = br.readLine()) != null){
            queue.put(line);
        }

    }


//    @Scheduled(fixedDelay = 2000)
//    void ServiceStorage() throws InterruptedException {
        //   log.info("take trying!!!");
        //   long current = System.currentTimeMillis();
        //      log.info((current - previous) + " ScheduledQueueService.take " + queue.poll(500, TimeUnit.MILLISECONDS));
//        System.out.println (queue.take());
//    }

}





