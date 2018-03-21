package com.knott.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.knott.util.ObjectMap;

public class LoginPage {
	private WebElement element = null;
	//ָ��ҳ��Ԫ�ض�λ���ʽ�����ļ��ľ����ļ�·��
	private ObjectMap objMap = new ObjectMap("E:\\workspace\\SeleniumProj\\objectMap.properties");
	private WebDriver driver;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	public WebElement choseButton() throws Exception{
		element = driver.findElement(objMap.getLocator("qqmail.loginPage.chosebutton"));
		return element;
	}
	
	//���ص�¼ҳ���е��û��������ҳ��Ԫ�ض���
	public WebElement userName() throws Exception{
		//ʹ��objectMap���е�getLocator������ȡ�����ļ��й����û����Ķ�λ��ʽ�Ͷ�λ���ʽ
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
