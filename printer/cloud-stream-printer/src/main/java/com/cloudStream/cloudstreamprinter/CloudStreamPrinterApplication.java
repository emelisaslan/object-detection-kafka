package com.cloudStream.cloudstreamprinter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
@EnableBinding(Sink.class)
public class CloudStreamPrinterApplication {
	private final Logger logger = LoggerFactory.getLogger(CloudStreamPrinterApplication.class);

	@StreamListener("input")
	@Primary
	public void consumeMessage(String str){
		logger.info("Consume payload:" + str);
	}
	public static void main(String[] args) {
		SpringApplication.run(CloudStreamPrinterApplication.class, args);
	}

}
