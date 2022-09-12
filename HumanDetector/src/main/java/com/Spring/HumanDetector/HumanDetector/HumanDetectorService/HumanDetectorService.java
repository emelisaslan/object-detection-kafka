package com.Spring.HumanDetector.HumanDetector.HumanDetectorService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@Service
public class HumanDetectorService extends Thread {

    @Bean
    public Function<String, String> humanDetectionStarter() {
        return in -> {
            System.out.println(in);
            return in;
        };
    }
    @Bean
    public Function<Integer, String> humansDetected() {
        return in -> {
            return String.valueOf(in);
        };
    }

}

