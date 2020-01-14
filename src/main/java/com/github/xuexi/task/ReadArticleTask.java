package com.github.xuexi.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.github.xuexi.common.PageFactory;
import com.github.xuexi.pages.ArticlePage;

import lombok.var;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ReadArticleTask extends Task {
	
	@Autowired
	private PageFactory pageFactory;
	
	protected ReadArticleTask(Progress progress) {
		super(progress);
	}

	@Override
	public void d0() {
		var homePage = pageFactory.homePage();
		
		var doneNumber = 0;
		while(doneNumber < progress.toDoNumber()) {
			doArticle(homePage.enterNextArticle());
			doneNumber++;
		}
		
		
		homePage.mine().score();
	}
	
	protected void doArticle(ArticlePage articlePage) {
		articlePage.read();
	}

	@Override
	public boolean isEnable() {
		return !progress.finished();
	}

}
