package com.sample.twitertokafka.service.runner;

import org.springframework.stereotype.Service;

import twitter4j.TwitterException;

@Service
public interface StreamRunner {
	void start() throws TwitterException;
}
