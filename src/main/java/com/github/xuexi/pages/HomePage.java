package com.github.xuexi.pages;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.xuexi.common.DriverService;
import com.github.xuexi.common.PageFactory;
import com.github.xuexi.entity.Article;
import com.github.xuexi.entity.Audio;
import com.github.xuexi.properties.HomeXPath;
import com.github.xuexi.repository.ArticleRepository;
import com.github.xuexi.repository.AudioRepository;

import io.appium.java_client.android.AndroidElement;
import lombok.val;
import lombok.var;
import lombok.extern.slf4j.Slf4j;

/**
 * 首页
 * @author liu-qiang
 *
 */
@Component
@Slf4j
public class HomePage implements Page{

	@Autowired
	private DriverService driverService;
	@Autowired
	private PageFactory pageFactory;
	@Autowired
	private HomeXPath homeXPath;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private AudioRepository audioRepository;
	
	private static final Random random = new Random();
	
	public MinePage mine() {
		log.info("进入我的");
		driverService.findElementByXPath(homeXPath.getMine()).click();
		waitCurrentPageOver();
		
		return pageFactory.minePage();
	}
	
	private void waitCurrentPageOver() {
		driverService.waitHomeActivityOver();
	}

	public ArticlePage enterNextArticle() {
		waitArticleClickable();
		
		AndroidElement article =  nextArticle();
		article.click();
		
		return pageFactory.articlePage();
	}
	
	public AudioPage enterNextShortAudio() {
		switchToNewsTab(); // 看联播频道的很稳
		waitAudioClickable();
		AndroidElement audio = nextShortAudio();
		audio.click();
		return pageFactory.audioPage();
	}

	private void waitArticleClickable() {
		driverService.waitElementClickable(homeXPath.getArticle());
	}
	
	private void waitAudioClickable() {
		driverService.waitElementClickable(homeXPath.getAudio());
	}
	
	private void switchToNewsTab() {
		driverService.findElementByXPath(homeXPath.getNewsTab()).click();
	}
	
	private AndroidElement nextArticle() {
		for (var article : articleElements()) {
			val title = article.findElementByXPath(homeXPath.getArticleTitle()).getText();
			if (!articleRepository.existsById(title)) {
				articleRepository.save(new Article(title));
				return article;
			}
		}
		
		randomSwipe();
		return nextArticle();
	}
	
	private AndroidElement nextShortAudio() {
		for (var audio : articleElements()) {
			val title = audio.findElementByXPath(homeXPath.getArticleTitle()).getText();
			if (!audioRepository.existsById(title)) {
				audioRepository.save(new Audio(title));
				return audio;
			}
		}
		swipeUp();
		return nextShortAudio();
	}

	private void randomSwipe() {
		switch (random.nextInt(3)) {
		case 0:
			swipeUp();
			break;
		case 1:
			swipeLeft();
			break;
		case 2:
			swipeRight();
			break;
		}
	}
	
	private void swipeUp() {
		waitArticleClickable();
		driverService.swipeUp();
	}

	private void swipeLeft() {
		waitArticleClickable();
		driverService.swipeLeft();
	}
	
	private void swipeRight() {
		waitArticleClickable();
		driverService.swipeRight();
	}
	
	public void localChannelXuexi() {
		driverService.findElementByXPath(homeXPath.getChannelXuexi()).click();
		waitCurrentPageOver();
		driverService.back();
	}
	
	private List<AndroidElement> articleElements() {
		try {
			return driverService.findElementsByXPath(homeXPath.getArticle());
		} catch (Exception e) {
			return Collections.emptyList();
		}
	}
	
}
