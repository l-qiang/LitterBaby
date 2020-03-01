package com.github.xuexi.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix="xpath.agreement")
@PropertySource(value = "xxqg.properties", encoding = "UTF-8")
public @Data class AgreementXPath {
	
	private String agree;
}
