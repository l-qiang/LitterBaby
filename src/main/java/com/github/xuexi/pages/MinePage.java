package com.github.xuexi.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.xuexi.common.DriverService;
import com.github.xuexi.common.PageFactory;
import com.github.xuexi.properties.MineXPath;

/**
 * 我的
 * @author liu-qiang
 *
 */
@Component
public class MinePage implements Page{
	
	@Autowired
	private DriverService driverService;
	@Autowired
	private PageFactory pageFactory;
	@Autowired
	private MineXPath mineXPath;
	
	public ScorePage score() {
		driverService.findElementByXPath(mineXPath.getScore()).click();
		waitCurrentPageOver();
		
		return pageFactory.scorePage();
	}

	private void waitCurrentPageOver() {
		driverService.waitElementInvisible(mineXPath.getTitle());
	}
}
