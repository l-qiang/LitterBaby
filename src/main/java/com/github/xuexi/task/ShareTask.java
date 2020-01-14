package com.github.xuexi.task;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.github.xuexi.pages.ArticlePage;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ShareTask extends ReadArticleTask {


	protected ShareTask(Progress progress) {
		super(progress);
	}

	@Override
	public void d0() {
		super.d0();
	}
	
	@Override
	protected void doArticle(ArticlePage articlePage) {
		articlePage.share();
	}
	
	@Override
	public boolean isEnable() {
		return true;

	}

}
