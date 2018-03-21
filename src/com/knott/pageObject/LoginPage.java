package com.knott.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.knott.util.ObjectMap;

public class LoginPage {
	private WebElement element = null;
	//指定页面元素定位表达式配置文件的绝对文件路径
	private ObjectMap objMap = new ObjectMap("E:\\workspace\\SeleniumProj\\objectMap.properties");
	private WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement choseButton() throws Exception{
		element = driver.findElement(objMap.getLocator("qqmail.loginPage.chosebutton"));
		return element;
	}
	
	//返回登录页面中的用户名输入框页面元素对象
	public WebElement userName() throws Exception{
		//使用objectMap类中的getLocator方法获取配置文件中关于用户名的定位方式和定位表达式
		element = driver.findElement(objMap.getLocator("qqmail.loginPage.username"));
		return element;
	}
	
	public WebElement userpwd() throws Exception{
		element = driver.findElement(objMap.getLocator("qqmail.loginPage.userpwd"));
		return element;
	}
	
	public WebElement loginButton() throws Exception{
		element = driver.findElement(objMap.getLocator("qqmail.loginPage.loginbutton"));
		return element;
	}
}
