package com.Spring.PlaneDetector.PlaneDetector.PlaneDetectorService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;
@Service
public class PlaneDetectorService {

    @Bean
    public Function<String, String> planeDetectionStarter(){
        return in -> {
            return in;
        };
    }

    @Bean
    public Function<Integer, String> planesDetected(){
        return in -> {
            return String.valueOf(in);
        };
    }
}

