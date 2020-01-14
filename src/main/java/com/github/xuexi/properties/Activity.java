package com.github.xuexi.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix="activity")
public @Data class Activity {
	
	private String home;
	private String splash;
	private String login;
	private String agreement;
	private String mine;
	
	public boolean isHome(String activity) {
		return home.equals(activity);
	}
	
	public boolean isNotHome(String activity) {
		return !isHome(activity);
	}
	
	public boolean isSplash(String activity) {
		return splash.equals(activity);
	}
	
	public boolean isNotSplash(String activity) {
		return !isSplash(activity);
	}
	
	public boolean isLogin(String activity) {
		return login.equals(activity);
	}
	
	public boolean isNotLogin(String activity) {
		return !isLogin(activity);
	}
	
	public boolean isAgreement(String activity) {
		return agreement.equals(activity);
	}
	
	public boolean isNotAgreement(String activity) {
		return !isAgreement(activity);
	}
	
	public boolean isMine(String activity) {
		return mine.equals(activity);
	}
	
	public boolean isNotMine(String activity) {
		return !isMine(activity);
	}
	
}
