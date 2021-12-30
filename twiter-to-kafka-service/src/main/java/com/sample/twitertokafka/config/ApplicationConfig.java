package com.sample.twitertokafka.config;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.ToString;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "props")
@Data
@ToString
@Component
public class ApplicationConfig {

	private List<String> twiterKeywords;

}
