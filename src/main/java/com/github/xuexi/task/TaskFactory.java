package com.github.xuexi.task;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.xuexi.properties.TaskInfos;

@Component
public class TaskFactory implements BeanFactoryAware{
	
	@Autowired
	private TaskInfos taskInfos;
	private BeanFactory beanFactory;
	
	public Task get(String title, Progress progress) {
		return (Task) beanFactory.getBean(taskInfos.name(title), progress);
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}
}
