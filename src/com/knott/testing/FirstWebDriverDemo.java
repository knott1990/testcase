package com.knott.testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class FirstWebDriverDemo {
	public WebDriver driver;
	String baseUrl = "https://mail.qq.com/";// �趨������վ�ĵ�ַ

	@Test(enabled = false)
	public void f() {
		// ��sogou��ҳ
		driver.get(baseUrl);
		// ����������������������
		driver.findElement(By.id("query")).sendKeys("����֮·�Զ�������");
		driver.findElement(By.id("stb")).click();
	}

	@Test
	public void vst_qqmail() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(2000);
		// ����Unable to locate element:
		// //*[@id='switcher_plogin']�������ȶ�λ��frame--���
		driver.switchTo().frame("login_frame");
		// ����˺������¼
		driver.findElement(By.xpath("//*[@id='switcher_plogin']")).click();
		// ����QQ�ʺ�
		driver.findElement(By.xpath("//*[@id='u']")).sendKeys("1329552517");
		// ����QQ����
		driver.findElement(By.xpath("//*[@id='p']")).sendKeys("19901116jj");
		// �����¼��ť
		driver.findElement(By.xpath("//*[@id='login_button']")).click();
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("before-class:running");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("after-class:running");
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
		// �رմ򿪵������
		// driver.quit();
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("I'm beforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("I'm afterTest");
	}

}
