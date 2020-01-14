package com.github.xuexi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.xuexi.common.PageFactory;
import com.github.xuexi.pages.ScorePage;

import lombok.var;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ScoreService {
	
	@Autowired
	private PageFactory pageFactory;
	
	public void startScore() {
		ScorePage scorePage = pageFactory.homePage().mine().score();
		
		log.info("进入学习积分开始做任务");
		var nextTask = scorePage.nextTask();
		while (nextTask != null) {
			nextTask.d0();
			nextTask = scorePage.nextTask();
		}
		
	}
}
