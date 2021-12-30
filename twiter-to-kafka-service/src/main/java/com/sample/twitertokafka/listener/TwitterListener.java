package com.sample.twitertokafka.listener;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import twitter4j.Status;
import twitter4j.StatusAdapter;

@Slf4j
@Component
public class TwitterListener extends StatusAdapter {

	@Override
	public void onStatus(Status status) {
		log.info("Twitter Text :: {}", status.getText());
	}
}
