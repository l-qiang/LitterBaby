package com.github.xuexi.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.xuexi.pages.AgreementPage;
import com.github.xuexi.pages.ArticlePage;
import com.github.xuexi.pages.AudioPage;
import com.github.xuexi.pages.HomePage;
import com.github.xuexi.pages.LoginPage;
import com.github.xuexi.pages.MinePage;
import com.github.xuexi.pages.Page;
import com.github.xuexi.pages.ScorePage;
import com.github.xuexi.pages.SubscribePage;

@Component
public class PageFactory {
	
	@Autowired
	private DriverService driverService;
	@Autowired
	private LoginPage loginPage;
	@Autowired
	private HomePage homePage;
	@Autowired
	private AgreementPage agreementPage;
	@Autowired
	private ScorePage scorePage;
	@Autowired
	private MinePage minePage;
	@Autowired
	private ArticlePage articlePage;
	@Autowired
	private AudioPage audioPage;
	@Autowired
	private SubscribePage subscribePage;
	
	/**
	 * 打开app的第一个页面
	 * @return
	 */
	public Page firstPage() {
		driverService.waitSplashOver();
		if (driverService.currentActivityIsHome()) {
			return homePage;
		} else if (driverService.currentActivityIsLogin()) {
			return loginPage;
		}
		throw new UnknownPageException("获取第一个页面失败");
	}
	
	public Page afterLoginPage() {
		if (driverService.currentActivityIsAgreement()) {
			return agreementPage;
		} else if (driverService.currentActivityIsHome()) {
			return homePage;
		}
		throw new UnknownPageException("登陆后调整到未知页面");
	}
	
	public HomePage homePage() {
		return homePage;
	}

	public AgreementPage agreementPage() {
		return agreementPage;
	}
	
	public LoginPage loginPage() {
		return loginPage;
	}
	
	public ScorePage scorePage() {
		return scorePage;
	}
	
	public MinePage minePage() {
		return minePage;
	}
	
	public ArticlePage articlePage() {
		return articlePage;
	}
	
	public AudioPage audioPage() {
		return audioPage;
	}
	
	public SubscribePage subscribePage() {
		return subscribePage;
	}
}
