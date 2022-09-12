package com.Spring.HumanDetector.HumanDetector;

import com.Spring.HumanDetector.HumanDetector.HeartBeatService.HeartBeatService;
import com.Spring.HumanDetector.HumanDetector.HumanDetectorService.HumanDetectorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HumanDetectorApplication {

	public static void main(String[] args) {
		ApplicationContext apl = SpringApplication.run(HumanDetectorApplication.class, args);
		HumanDetectorService hds = apl.getBean(HumanDetectorService.class);
		HeartBeatService hbs = apl.getBean(HeartBeatService.class);

	}
}


