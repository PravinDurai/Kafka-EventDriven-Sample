package com.sample.twitertokafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.twitertokafka.config.ApplicationConfig;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "twitertokafka")
@Slf4j
public class TwiterToKafkaController {

	@Autowired
	private ApplicationConfig applicationConfig;

	private ObjectMapper objectMapper = new ObjectMapper();

	@GetMapping(value = "/hello", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<String> getMethod() throws JsonProcessingException {
		log.info("Application config :: {}", objectMapper.writerWithDefaultPrettyPrinter()
				.writeValueAsString(applicationConfig.getTwiterKeywords()));
		return new ResponseEntity<String>(objectMapper.writeValueAsString(applicationConfig.getTwiterKeywords()),
				HttpStatus.OK);
	}

}
