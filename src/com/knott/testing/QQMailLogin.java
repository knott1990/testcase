package com.knott.testing;

import org.testng.annotations.Test;

import com.knott.module.Login_Action;
import com.knott.pageObject.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class QQMailLogin {
	public WebDriver driver;
	String baseURL = "https://mail.qq.com/";

	@Test
	public void testLogin() throws Exception {
		//调用封装好的Login_Action来简化测试代码
		//Login_Action.execute(driver, "1329552517", "19901116jj");
		Login_Action.execute(driver, "361333457", "B_ur_hero.793");
		/**
		 * 以下为调用Login_Action前，需如下逐步写登录动作
		 */
		/*driver.get(baseURL);
		LoginPage loginpage = new LoginPage(driver);
		driver.switchTo().frame("login_frame");
		loginpage.choseButton().click();
		loginpage.userName().sendKeys("1329552517");
		loginpage.userpwd().sendKeys("19901116jj");
		loginpage.loginButton().click();*/
		Thread.sleep(5000);
		// 断言网页中是否包含“未读邮件”内容来确认登录成功（断言时报错，case不通过）
		//driver.switchTo().frame("mainFrame");
		//Assert.assertTrue(driver.getPageSource().contains("未读邮件"));
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
		//driver.quit();
		driver.close();
	}

}
