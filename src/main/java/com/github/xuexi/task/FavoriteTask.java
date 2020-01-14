package com.github.xuexi.task;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.github.xuexi.pages.ArticlePage;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FavoriteTask extends ReadArticleTask {


	protected FavoriteTask(Progress progress) {
		super(progress);
	}

	@Override
	public void d0() {
		super.d0();
	}
	
	@Override
	protected void doArticle(ArticlePage articlePage) {
		articlePage.favorite();
	}

	@Override
	public boolean isEnable() {
		return !progress.finished();
	}

}
