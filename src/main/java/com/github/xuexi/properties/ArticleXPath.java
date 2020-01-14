package com.github.xuexi.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix="xpath.article")
public @Data class ArticleXPath {
	
	private String loadfailed;
	private String header;
	private String body;
	private String headerTitle;
	private String postViewEnter;
	private String postView;
	private String postViewPublish;
	private String postViewCancel;
	private String postViewInput;
	private String favorite;
	private String share;
	private String shareXxqg;
	private String view;
}
