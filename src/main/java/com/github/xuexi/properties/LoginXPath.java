package com.github.xuexi.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix="xpath.login")
public @Data class LoginXPath {
	
	private String phoneNum;
	private String password;
	private String loginBtn;
}
