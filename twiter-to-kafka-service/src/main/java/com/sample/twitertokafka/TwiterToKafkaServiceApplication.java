package com.sample.twitertokafka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sample.twitertokafka.service.runner.StreamRunner;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class TwiterToKafkaServiceApplication implements CommandLineRunner {
	
	private final StreamRunner streamRunner;
	
	public TwiterToKafkaServiceApplication(StreamRunner streamRunner) {
		this.streamRunner=streamRunner;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TwiterToKafkaServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {	
		log.info("Application Start...");
		log.info("Started Stream Runner...");
		streamRunner.start();
	}

}
