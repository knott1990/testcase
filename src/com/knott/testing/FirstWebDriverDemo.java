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
	String baseUrl = "https://mail.qq.com/";// 设定访问网站的地址

	@Test(enabled = false)
	public void f() {
		// 打开sogou首页
		driver.get(baseUrl);
		// 在搜索框中输入搜索内容
		driver.findElement(By.id("query")).sendKeys("光荣之路自动化测试");
		driver.findElement(By.id("stb")).click();
	}

	@Test
	public void vst_qqmail() throws Exception {
		driver.get(baseUrl);
		Thread.sleep(2000);
		// 报错Unable to locate element:
		// //*[@id='switcher_plogin']，尝试先定位到frame--解决
		driver.switchTo().frame("login_frame");
		// 点击账号密码登录
		driver.findElement(By.xpath("//*[@id='switcher_plogin']")).click();
		// 输入QQ帐号
		driver.findElement(By.xpath("//*[@id='u']")).sendKeys("1329552517");
		// 输入QQ密码
		driver.findElement(By.xpath("//*[@id='p']")).sendKeys("19901116jj");
		// 点击登录按钮
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
		// 要调起新版本的firefox，需要geckodriver驱动（未设置时java.lang.IllegalStateException报错）
		System.setProperty("webdriver.gecko.driver", "D:\\javas\\geckodriver.exe");
		// 若无法打开Firefox浏览器，可设定Firefox浏览器的安装路径(未设置路径时path报错)
		System.setProperty("webdriver.firefox.bin", "D:\\firefox\\firefox.exe");
		// 打开Firefox浏览器
		driver = new FirefoxDriver();
	}

	@AfterMethod
	public void afterMethod() {
		// 关闭打开的浏览器
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
