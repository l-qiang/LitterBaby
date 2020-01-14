package com.github.xuexi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.xuexi.common.DriverService;
import com.github.xuexi.service.LoginService;
import com.github.xuexi.service.ScoreService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AutoXuexi {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private ScoreService scoreService;
	@Autowired
	private DriverService driverService;
	
	public void start(){
		log.info("开始学习");
		
		driverService.start();
		try {
			loginService.tryLogin();
			scoreService.startScore();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driverService.quit();
		}
		
		log.info("学习完成");
	}
	
}
