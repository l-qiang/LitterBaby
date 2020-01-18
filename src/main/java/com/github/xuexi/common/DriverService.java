package com.github.xuexi.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

import com.github.xuexi.properties.Activity;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.offset.PointOption;
import lombok.val;

@Service
public class DriverService {
	
	@Autowired
	private Activity activity;
	private AndroidDriver<AndroidElement> androidDriver;
	private WebDriverWait wait;
	private AndroidTouchAction androidTouchAction;
	private int height;
	private int width;
	
	public void start() {
		androidDriver = androidDriver();
		wait = new WebDriverWait(androidDriver,30);
		androidTouchAction = new AndroidTouchAction(androidDriver);
		val size = androidDriver.manage().window().getSize();
		height = size.height;
		width = size.width;
	}
	
	@Lookup 
	AndroidDriver<AndroidElement> androidDriver() {
		return null;
	}
	
	public AndroidElement findElementByXPath(String xpath) {
		waitElementByXPathPresence(xpath);
		return androidDriver.findElementByXPath(xpath);
	}
	
	public List<AndroidElement> findElementsByXPath(String xpath) {
		waitElementByXPathPresence(xpath);
		return androidDriver.findElementsByXPath(xpath);
	}
	
	public void waitSplashOver() {
		wait.until(e ->activity.isNotSplash(currentActivity()));
	}
	
	public void waitLoginActivityOver() {
		wait.until(e -> activity.isNotLogin(currentActivity()));
	}
	
	public void waitAgreementActivityOver() {
		wait.until(e -> activity.isNotAgreement(currentActivity()));
	}
	
	public void waitHomeActivityOver() {
		wait.until(e -> activity.isNotHome(currentActivity()));
	}
	
	public void waitElementInvisible(String xpath) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}
	public void waitElementVisible(String xpath) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void waitElementClickable(String xpath) {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	}
	
	private void waitElementByXPathPresence(String xpath) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}
	
	public boolean currentActivityIsHome() {
		return activity.isHome(currentActivity());
	}
	
	public boolean currentActivityIsLogin() {
		return activity.isLogin(currentActivity());
	}
	
	public boolean currentActivityIsAgreement() {
		return activity.isAgreement(currentActivity());
	}
	
	private String currentActivity() {
		return androidDriver.currentActivity();
	}
	
	public void swipeUp() {
		androidTouchAction.press(PointOption.point(width / 2, height / 2 + 200))
						  .waitAction()
						  .moveTo(PointOption.point(width / 2, height / 2 - 400))
						  .release()
						  .perform();
	}
	
	public void swipeUp(int heigth) {
		androidTouchAction.press(PointOption.point(width / 2, height / 2 + heigth))
		  .waitAction()
		  .moveTo(PointOption.point(width / 2, height / 2))
		  .release()
		  .perform();
	}
	
	public void swipeDown() {
		androidTouchAction.press(PointOption.point(width / 2, height / 2 - 400))
						  .waitAction()
					      .moveTo(PointOption.point(width / 2, height / 2 + 200))
					      .release()
					      .perform();
	}
	
	public void swipeLeft() {
		androidTouchAction.press(PointOption.point(width - 5, height - 400))
		                  .waitAction()
						  .moveTo(PointOption.point(5, height - 400))
						  .release()
						  .perform();
	}
	
	public void swipeRight() {
		androidTouchAction.press(PointOption.point(5,height - 400))
		                  .waitAction()
						  .moveTo(PointOption.point(width - 5, height - 400))
						  .release()
						  .perform();
	}
	
	public void quit() {
		androidDriver.quit();
	}
	
	public void back() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		androidDriver.navigate().back();
	}
	
}
