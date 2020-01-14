package com.github.xuexi.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.github.xuexi.common.PageFactory;
import com.github.xuexi.pages.HomePage;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class LocalChannelTask extends Task {
	
	@Autowired
	private PageFactory pageFactory;
	
	protected LocalChannelTask(Progress progress) {
		super(progress);
	}

	@Override
	public void d0() {
		HomePage homePage = pageFactory.homePage();
		
		homePage.localChannelXuexi();
		
		homePage.mine().score();
	}

	@Override
	public boolean isEnable() {
		return !progress.finished();
	}

}
