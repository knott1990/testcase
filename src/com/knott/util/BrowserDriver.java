package com.knott.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserDriver {
	private WebDriver browser;

	public WebDriver firefox() {
		// Ҫ�����°汾��firefox����Ҫgeckodriver������δ����ʱjava.lang.IllegalStateException����
		System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver.exe");
		// ���޷���Firefox����������趨Firefox������İ�װ·��(δ����·��ʱpath����)
		System.setProperty("webdriver.firefox.bin", "D:\\firefox\\firefox.exe");
		// ��Firefox�����
		browser = new FirefoxDriver();
		return browser;
	}

	public WebDriver ie() {
		System.setProperty("webdriver.ie.driver", ".\\lib\\IEDriverServer.exe"); // ���������ֵ��IE�����������
		// ��IE��������õİ�ȫ�Խϸߣ�����ʱ�п��ܱ����������capabilities���
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		browser = new InternetExplorerDriver();
		return browser;
	}
}
