package com.github.xuexi;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.Data;

@Configuration
@ConfigurationProperties(prefix="cap")
public @Data class AppiumConfig {
	
	private String version;
	private String appPackage;
	private String appActivity;
	private String deviceName;
	private boolean noReset;
	private int newCommandTimeout;
	private String appiumServer;
	
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public AndroidDriver<AndroidElement> androidDriver() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.ANDROID);
		capabilities.setVersion(version); // 安卓版本
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName); // adb devices 查看
		capabilities.setCapability("noReset", noReset); 
		capabilities.setCapability("newCommandTimeout", newCommandTimeout); 
		return new AndroidDriver<AndroidElement>(new URL(appiumServer), capabilities);
	}
}
