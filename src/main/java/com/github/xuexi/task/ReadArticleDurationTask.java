package com.github.xuexi.task;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ReadArticleDurationTask extends ReadArticleTask {

	protected ReadArticleDurationTask(Progress progress) {
		super(progress);
	}

	@Override
	public boolean isEnable() {
		return !progress.finished();

	}

}
