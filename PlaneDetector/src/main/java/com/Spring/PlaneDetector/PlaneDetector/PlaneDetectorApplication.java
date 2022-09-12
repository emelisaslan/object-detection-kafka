package com.Spring.PlaneDetector.PlaneDetector;
import com.Spring.PlaneDetector.PlaneDetector.HeartBeatService.HeartBeatService;
import com.Spring.PlaneDetector.PlaneDetector.PlaneDetectorService.PlaneDetectorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PlaneDetectorApplication {

	public static void main(String[] args) {
		ApplicationContext apc = SpringApplication.run(PlaneDetectorApplication.class, args);
		PlaneDetectorService pds = apc.getBean(PlaneDetectorService.class);
		HeartBeatService hbs = apc.getBean(HeartBeatService.class);
	}

}
