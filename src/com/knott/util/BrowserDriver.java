package com.knott.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserDriver {
	private WebDriver browser;

	public WebDriver firefox() {
		// 要调起新版本的firefox，需要geckodriver驱动（未设置时java.lang.IllegalStateException报错）
		System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver.exe");
		// 若无法打开Firefox浏览器，可设定Firefox浏览器的安装路径(未设置路径时path报错)
		System.setProperty("webdriver.firefox.bin", "D:\\firefox\\firefox.exe");
		// 打开Firefox浏览器
		browser = new FirefoxDriver();
		return browser;
	}

	public WebDriver ie() {
		System.setProperty("webdriver.ie.driver", ".\\lib\\IEDriverServer.exe"); // 浏览器对象赋值给IE浏览器的驱动
		// 若IE浏览器设置的安全性较高，运行时有可能报错，因此设置capabilities解决
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		browser = new InternetExplorerDriver();
		return browser;
	}
}
