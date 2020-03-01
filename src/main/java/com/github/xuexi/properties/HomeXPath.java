package com.github.xuexi.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;


@Configuration
@ConfigurationProperties(prefix="xpath.home")
@PropertySource(value = "xxqg.properties", encoding = "UTF-8")
public @Data class HomeXPath {
	
	private String mine;
	
	private String article;
	private String articleTitle;
	
	private String channelXuexi;
	
	private String audio;
	private String audioTitle;
	private String audioDuration;
	
	private String newsTab;
}
