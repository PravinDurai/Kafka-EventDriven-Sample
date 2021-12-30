package com.sample.twitertokafka.service.runner.impl;

import java.util.Arrays;

import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import com.sample.twitertokafka.config.ApplicationConfig;
import com.sample.twitertokafka.listener.TwitterListener;
import com.sample.twitertokafka.service.runner.StreamRunner;

import lombok.extern.slf4j.Slf4j;
import twitter4j.FilterQuery;
import twitter4j.StatusListener;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

@Slf4j
@Component
public class StreamRunnerImpl implements StreamRunner {
	
	private final ApplicationConfig applicationConfig;
	
	private final TwitterListener twitterListener;
	
	private TwitterStream twitterStream;
	
	private StreamRunnerImpl(ApplicationConfig applicationConfig, TwitterListener twitterListener) {
		this.applicationConfig=applicationConfig;
		this.twitterListener=twitterListener;
	}

	@Override
	public void start() throws TwitterException {
		twitterStream=new TwitterStreamFactory().getInstance();
		twitterStream.addListener(twitterListener);
		addFilter();
	}
	
	@PreDestroy
	public void shutdown() {
		if(twitterStream!=null) {
			log.info("Closing twitter stream!");
			twitterStream.shutdown();
		}
	}

	private void addFilter() {
		String[] keywords=applicationConfig.getTwiterKeywords().toArray(new String[0]);
		FilterQuery filterQuery=new FilterQuery(keywords);
		twitterStream.filter(filterQuery);
		log.info("Started filtering twitter stream for configured keywords :: {}", Arrays.toString(keywords));
	}

	
}
