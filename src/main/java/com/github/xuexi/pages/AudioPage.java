package com.github.xuexi.pages;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.xuexi.common.DriverService;
import com.github.xuexi.properties.AudioXPath;

import io.appium.java_client.android.AndroidElement;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class AudioPage {

	@Autowired
	private DriverService driverService;
	@Autowired
	private AudioXPath audioXPath;
	
	public void watchShort() {
		try {
			watch11sec(0);
		} finally {
			driverService.back();
		}
		
	}
	
	private void watch11sec(int retryTimes) {
		if (retryTimes > 2) {
			log.info("网络不太好");
			return;
		}
		try {
			Thread.sleep(11*1000);
			AndroidElement retryBtn = retryBtn();
			while (retryBtn != null) {
				retryBtn.click();
				watch11sec(++retryTimes);
			}
		} catch (InterruptedException e) {
			
		}
	}
	
	public AndroidElement retryBtn() {
		try {
			driverService.findElementByXPathNoWait(audioXPath.getRetry());
		} catch (Exception e) {
			
		}
		return null;
	}

	public void watchLong() {
		try {
			watch18min();
		} finally {
			driverService.back();
		}
	}
	
	private void watch18min() {
		LocalTime startTime = LocalTime.now();
		while (LocalTime.now().compareTo(startTime.plusMinutes(18)) < 0) {
			AndroidElement retryBtn = retryBtn();
			if (retryBtn != null) {
				retryBtn.click();
			}
		}
	}

}
