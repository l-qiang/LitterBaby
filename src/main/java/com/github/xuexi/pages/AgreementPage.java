package com.github.xuexi.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.xuexi.common.DriverService;
import com.github.xuexi.common.PageFactory;
import com.github.xuexi.properties.AgreementXPath;

/**
 * 协议
 * @author liu-qiang
 *
 */
@Component
public class AgreementPage implements Page{
	
	@Autowired
	private DriverService driverService;
	@Autowired
	private PageFactory pageFactory;
	@Autowired
	private AgreementXPath agreementXPath;
	
	public HomePage agree() {
		driverService.findElementByXPath(agreementXPath.getAgree()).click();
		waitCurrentPageOver();
		
		return pageFactory.homePage();
	}

	private void waitCurrentPageOver() {
		driverService.waitAgreementActivityOver();
	}
}
