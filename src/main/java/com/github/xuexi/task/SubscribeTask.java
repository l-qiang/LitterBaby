package com.github.xuexi.task;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class SubscribeTask extends Task {
	
	protected SubscribeTask(Progress progress) {
		super(progress);
	}

	@Override
	public void d0() {
		
	}

	@Override
	public boolean isEnable() {
		return false;
	}

}
