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
	// 要调起新版本的firefox，需要geckodriver驱动（未设置时java.lang.IllegalStateException报错）
			System.setProperty("webdriver.gecko.driver", "D:\\javas\\geckodriver.exe");
			// 若无法打开Firefox浏览器，可设定Firefox浏览器的安装路径(未设置路径时path报错)
			System.setProperty("webdriver.firefox.bin", "D:\\firefox\\firefox.exe");
			// 打开Firefox浏览器
			driver = new FirefoxDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
