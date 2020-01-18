package com.github.xuexi.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.github.xuexi.common.PageFactory;

import lombok.var;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class AudiovisualLearningDurationTask extends Task {

	@Autowired
	private PageFactory pageFactory;
	
	protected AudiovisualLearningDurationTask(Progress progress) {
		super(progress);
	}

	@Override
	public void d0() {
		var homePage = pageFactory.homePage();
		
		homePage.enterNextLongAudio().watchLong();
		
		homePage.mine().score();
	}

	@Override
	public boolean isEnable() {
		return !progress.finished();
	}

}
