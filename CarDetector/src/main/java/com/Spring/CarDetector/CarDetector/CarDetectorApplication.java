package com.Spring.CarDetector.CarDetector;
import com.Spring.CarDetector.CarDetector.CarDetectorService.CarDetectorService;
import com.Spring.CarDetector.CarDetector.HeartBeatService.HeartBeatService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CarDetectorApplication {

	public static void main(String[] args) {
		ApplicationContext apc = SpringApplication.run(CarDetectorApplication.class, args);
		CarDetectorService cds = apc.getBean(CarDetectorService.class);
		HeartBeatService hbs = apc.getBean(HeartBeatService.class);
	}
}
