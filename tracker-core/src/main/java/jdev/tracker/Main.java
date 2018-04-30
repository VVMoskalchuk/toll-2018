package jdev.tracker;

import jdev.dto.PointDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by jdev on 07.03.2017.
 */
public class Main {
    public static void main(String... args) throws Exception {
//        for (int i=0; i<5; i++) {
//            System.out.println("Main.main say Hello!!!!");
//            PointDTO point = new PointDTO();
//            point.setLat(45);
//            System.out.println(point.toJson());
//            Thread.sleep(1000);
//        }

        ApplicationContext context = new AnnotationConfigApplicationContext ( InjectionServeses.class);
    }
}
