package com.Spring.CarDetector.CarDetector.HeartBeatService;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class HeartBeatService {
    @Bean
    public Supplier<String> heartBean() {
        return () -> {
            return "CarDetector";
        };
    }
}