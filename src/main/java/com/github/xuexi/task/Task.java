package com.github.xuexi.task;

public abstract class Task {
	
	protected Progress progress;
	
	protected Task(Progress progress) {
		this.progress = progress;
	}
	
	public abstract void d0();
	public abstract boolean isEnable();
}
