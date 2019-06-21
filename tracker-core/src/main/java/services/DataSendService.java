package services;

import jdev.dto.PointDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.concurrent.BlockingDeque;


@Service
public class DataSendService {
    private static final Logger log = LoggerFactory.getLogger(DataSendService.class);
    private static final int TIME_OUT = 10_000;
    @Autowired
    ServiceStorage serviceStorage;


    RestTemplate restTemplate = new RestTemplate();



    @Scheduled(fixedDelay = TIME_OUT)
    public void sendDTO() throws InterruptedException, IOException {
        int i=0;

        BlockingDeque <PointDTO> queue = serviceStorage.allCoordinates ();

            for (PointDTO p : queue) {
                log.info(" Номер точки "+i +": " + p);
                restTemplate.postForObject("http://localhost:8080/points/create", p, PointDTO.class);
                i++;
            }

    }
}
