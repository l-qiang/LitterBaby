package com.github.xuexi.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;


@Configuration
@ConfigurationProperties(prefix="xpath.home")
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
