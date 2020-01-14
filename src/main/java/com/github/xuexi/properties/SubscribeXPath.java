package com.github.xuexi.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix="xpath.subscribe")
public @Data class SubscribeXPath {
	
	private String publicName;
	private String publicBtn;
}
