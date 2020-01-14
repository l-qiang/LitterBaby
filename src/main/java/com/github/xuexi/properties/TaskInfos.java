package com.github.xuexi.properties;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix="score")
public @Data class TaskInfos {
	
	List<TaskInfo> tasks;
	
	public String name(String title) {
		for (TaskInfo info : tasks) {
			if (info.getTitle().equals(title)) {
				return info.getTaskname();
			}
		}
		throw new IllegalArgumentException("任务["+title+"]配置不存在");
	}
}
