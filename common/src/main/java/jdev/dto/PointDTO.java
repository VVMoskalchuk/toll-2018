package jdev.dto;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by jdev on 06.03.2017.
 */
public class PointDTO {
    private double lat;
    private double lon;
    private String autoId;
    private long time;


    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    public Object fromJson(String jsonInString, Class<Object> objectClass) throws IOException {

       ObjectMapper mapper = new ObjectMapper();
       return mapper.readValue(jsonInString, Object.class);

   }

    @Override
    public String toString() {
        return "PointDTO{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", autoId='" + autoId + '\'' +
                '}';
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }
}
