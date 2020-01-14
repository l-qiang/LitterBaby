package com.github.xuexi.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.xuexi.common.DriverService;
import com.github.xuexi.common.PageFactory;
import com.github.xuexi.properties.LoginXPath;
import com.github.xuexi.properties.User;

/**
 * 登录
 * @author liu-qiang
 *
 */
@Component
public class LoginPage implements Page{
	
	@Autowired
	private DriverService driverService;
	@Autowired
	private PageFactory pageFactory;
	@Autowired
	private LoginXPath loginXPath;
	@Autowired
	private User user;
	
	public Page login() {
		driverService.findElementByXPath(loginXPath.getPhoneNum()).sendKeys(user.getPhoneNum());
		driverService.findElementByXPath(loginXPath.getPassword()).sendKeys(user.getPassword());
		driverService.findElementByXPath(loginXPath.getLoginBtn()).click();
		
		waitCurrentPageOver();
		
		return pageFactory.afterLoginPage();
	}
	
	
	private void waitCurrentPageOver() {
		driverService.waitLoginActivityOver();
	}
	
}
