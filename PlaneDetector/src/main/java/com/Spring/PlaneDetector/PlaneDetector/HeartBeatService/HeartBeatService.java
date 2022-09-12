package com.Spring.PlaneDetector.PlaneDetector.HeartBeatService;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class HeartBeatService {
    @Bean
    public Supplier<String> heartBean() {
        return () -> {
            return "PlaneDetector";
        };
    }
}