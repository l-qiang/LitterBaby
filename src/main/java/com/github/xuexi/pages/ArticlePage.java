package com.github.xuexi.pages;

import java.time.LocalTime;

import org.openqa.selenium.TimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.xuexi.common.DriverService;
import com.github.xuexi.properties.ArticleXPath;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ArticlePage implements Page{
	
	@Autowired
	private DriverService driverService;
	@Autowired
	private ArticleXPath articleXPath;

	public void read() {
		tryLoad();
		LocalTime startTime = LocalTime.now();
		log.info("开始阅读");
		String view = awesome();
		while (LocalTime.now().compareTo(startTime.plusMinutes(2)) < 0) {
			sleep10sec();
			driverService.swipeUp();
		}
		
		// 三连
		doPostView(view); 
		doFavorite();
		doShare();
		
		driverService.back();
	}

	private void tryLoad() {
		try {
			waitArticleBody();
		} catch (Exception e) {
			driverService.back();
			return;
		}
	}
	
	private void waitArticleBody() {
		try {
			driverService.waitElementVisible(articleXPath.getBody());
		} catch (TimeoutException e) {
			driverService.findElementByXPath(articleXPath.getLoadfailed()).click();
			waitArticleBody();
		}
	}
	
	private void sleep10sec() {
		try {
			Thread.sleep(3*1000);
		} catch (InterruptedException e) {
		}
	}

	public void postView() {
		tryLoad();
		doPostView(awesome());
		driverService.back();
	}

	private String awesome() {
		String title = "这个app就是这么用的，你可真是个人才！！！";
		try {
			title = driverService.findElementByXPath(articleXPath.getHeaderTitle()).getText();
		} catch (Exception e) {
		}
		return title;
	}
	
	private void doPostView(String view) {
		log.info("尝试评论");
		try {
			try {
				view = driverService.findElementByXPath(articleXPath.getView()).getText();
			} catch (Exception e) {
			}
			
			driverService.findElementByXPath(articleXPath.getPostViewEnter()).click();
			driverService.findElementByXPath(articleXPath.getPostViewInput()).click();
			
			driverService.waitElementClickable(articleXPath.getPostViewPublish());
			driverService.findElementByXPath(articleXPath.getPostViewInput()).sendKeys(view);
			driverService.findElementByXPath(articleXPath.getPostViewPublish()).click();
//			driverService.waitElementInvisible(articleXPath.getPostView());
		} catch (Exception e) {}
	}
	
	public void favorite() {
		tryLoad();
		doFavorite();
		driverService.back();
	}
	
	private void doFavorite() {
		log.info("尝试收藏");
		try {
			driverService.findElementByXPath(articleXPath.getFavorite()).click();
		} catch (Exception e) {}
	}
	
	public void share() {
		tryLoad();
		doShare();
		driverService.back();
	}

	private void doShare() {
		log.info("尝试分享");
		try {
			driverService.findElementByXPath(articleXPath.getShare()).click();
			driverService.findElementByXPath(articleXPath.getShareXxqg()).click();
			driverService.waitHomeActivityOver();
			driverService.back();
		} catch (Exception e) {}
	}
}
