package services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.awt.*;
import java.io.IOException;
import java.util.concurrent.BlockingDeque;

@Service
public class DataSendService {

    private static final Logger log = LoggerFactory.getLogger(DataSendService.class);

    @Autowired
    private ServiceGPS serviceGPS;
    @Autowired
    private RestTemplate restTemplate;

    @Scheduled(cron = "*/60 * * * * *")
    public void sendToServer() throws InterruptedException, IOException {
        BlockingDeque <String> queue = serviceGPS.allCoordinates ();
        String[] points = new String[queue.size()];

        int i = 0;
        for(String point : queue) {
            points[i] = point;
            i ++;
        }

        restTemplate.postForObject("http://localhost:8080/points/create", points, Point[].class);
    }


}
