package com.github.xuexi.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix="xpath.login")
@PropertySource(value = "xxqg.properties", encoding = "UTF-8")
public @Data class LoginXPath {
	
	private String phoneNum;
	private String password;
	private String loginBtn;
}
