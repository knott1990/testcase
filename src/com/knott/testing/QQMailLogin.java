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
		//���÷�װ�õ�Login_Action���򻯲��Դ���
		//Login_Action.execute(driver, "1329552517", "19901116jj");
		Login_Action.execute(driver, "361333457", "B_ur_hero.793");
		/**
		 * ����Ϊ����Login_Actionǰ����������д��¼����
		 */
		/*driver.get(baseURL);
		LoginPage loginpage = new LoginPage(driver);
		driver.switchTo().frame("login_frame");
		loginpage.choseButton().click();
		loginpage.userName().sendKeys("1329552517");
		loginpage.userpwd().sendKeys("19901116jj");
		loginpage.loginButton().click();*/
		Thread.sleep(5000);
		// ������ҳ���Ƿ������δ���ʼ���������ȷ�ϵ�¼�ɹ�������ʱ����case��ͨ����
		//driver.switchTo().frame("mainFrame");
		//Assert.assertTrue(driver.getPageSource().contains("δ���ʼ�"));
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
		//driver.quit();
		driver.close();
	}

}
