package com.knott.testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class QQMailAddContact {
	public WebDriver driver;
	String baseURL = "https://mail.qq.com/";
  @Test
  public void f() {
  }
  @BeforeMethod
  public void beforeMethod() {
	// Ҫ�����°汾��firefox����Ҫgeckodriver������δ����ʱjava.lang.IllegalStateException����
			System.setProperty("webdriver.gecko.driver", "D:\\javas\\geckodriver.exe");
			// ���޷���Firefox����������趨Firefox������İ�װ·��(δ����·��ʱpath����)
			System.setProperty("webdriver.firefox.bin", "D:\\firefox\\firefox.exe");
			// ��Firefox�����
			driver = new FirefoxDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
