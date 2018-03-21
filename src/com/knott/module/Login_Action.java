package com.knott.module;

import org.openqa.selenium.WebDriver;

import com.knott.pageObject.LoginPage;

public class Login_Action {
	public static void execute(WebDriver driver,String userName,String userpwd) throws Exception{
		driver.get("https://mail.qq.com/");
		LoginPage loginpage = new LoginPage(driver);
		Thread.sleep(5000);
		driver.switchTo().frame("login_frame");
		loginpage.choseButton().click();
		loginpage.userName().sendKeys(userName);
		loginpage.userpwd().sendKeys(userpwd);
		loginpage.loginButton().click();
		Thread.sleep(5000);
	}
}
