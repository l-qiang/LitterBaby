package com.github.xuexi.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix="user")
public @Data class User {
	
	private String phoneNum;
	private String password;
}
