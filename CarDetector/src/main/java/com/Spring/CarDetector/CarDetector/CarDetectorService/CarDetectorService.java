package com.Spring.CarDetector.CarDetector.CarDetectorService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import java.util.function.Function;
@Service
public class CarDetectorService {

    @Bean
    public Function<String, String> carDetectionStarter() {
        return in -> {
            return in;
        };
    }
    @Bean
    public Function<Integer, String> carsDetected() {
        return in -> {
            return String.valueOf(in);
        };
    }
}


