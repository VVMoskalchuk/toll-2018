package jdev.tracker.services;

import jdev.dto.PointDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ServiceSend {

    private static final Logger log = LoggerFactory.getLogger(ServiceSend.class);

    @Scheduled(cron = "${cron.prop}")
    void sendToServer() throws IOException {

        String line = null;
        BufferedReader br = new BufferedReader(new FileReader ("StorageData.txt"));
        while((line = br.readLine()) != null){
            String[] parts = line.toString ().split (";");
            String part1 = parts[0];
            String part2 = parts[1];
            PointDTO point = new PointDTO();
            point.setLat(part1);
            point.setLon(part2);
            point.setAutoId("o567gfd");
            point.toJson ();
            log.info(System.currentTimeMillis () + " " + point.getLat () + " " + point.getLon () + " " + point.getAutoId ()  );
        }

    }


}
