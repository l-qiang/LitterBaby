package com.github.xuexi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.xuexi.common.PageFactory;
import com.github.xuexi.pages.AgreementPage;
import com.github.xuexi.pages.HomePage;
import com.github.xuexi.pages.LoginPage;

import lombok.val;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LoginService {
	
	@Autowired
	private PageFactory pageFactory;
	
	public HomePage tryLogin() {
		log.info("尝试登录");
		val firstPage = pageFactory.firstPage();
		
		if (firstPage instanceof HomePage) { // 已经是主页
			return (HomePage) firstPage;
		} else if (firstPage instanceof LoginPage) {
			val page = ((LoginPage)firstPage).login();
			if (page instanceof AgreementPage) {
				return ((AgreementPage) page).agree();
			} else {
				return (HomePage) page;
			}
		}
		
		return pageFactory.homePage();
	}

}
