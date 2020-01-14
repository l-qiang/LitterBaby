package com.github.xuexi.pages;

import org.openqa.selenium.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.xuexi.common.DriverService;
import com.github.xuexi.properties.ScoreXPath;
import com.github.xuexi.task.Progress;
import com.github.xuexi.task.Task;
import com.github.xuexi.task.TaskFactory;

import io.appium.java_client.android.AndroidElement;
import lombok.val;

@Component
public class ScorePage implements Page {

	@Autowired
	private DriverService driverService;
	@Autowired
	private TaskFactory taskFactory;
	@Autowired
	private ScoreXPath scoreXPath;
	
	public Task nextTask() {
		val tasks = driverService.findElementsByXPath(scoreXPath.getTasks());
		for (AndroidElement task : tasks) {
			try {
				val btn = task.findElementByXPath(scoreXPath.getTaskBtn());
				val title = task.findElementByXPath(scoreXPath.getTaskTitle()).getText();
				val progressText = task.findElementByXPath(scoreXPath.getTaskProgressText()).getText();
				val ans = taskFactory.get(title, new Progress(progressText));
				if (ans.isEnable()) {
					btn.click();
					return ans;
				}
			} catch (NoSuchElementException e) {
				
			}
			driverService.swipeUp(task.getRect().height);
		}
		return null;
	}
}
