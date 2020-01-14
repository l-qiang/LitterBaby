package com.github.xuexi.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix="xpath.score")
public @Data class ScoreXPath {
	private String tasks;
	private String taskBtn;
	private String taskTitle;
	private String taskProgressText;
}
