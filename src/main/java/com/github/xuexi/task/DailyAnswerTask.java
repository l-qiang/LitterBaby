package com.github.xuexi.task;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class DailyAnswerTask extends Task {


	protected DailyAnswerTask(Progress progress) {
		super(progress);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void d0() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEnable() {
		return false;
		// TODO Auto-generated method stub

	}

}
