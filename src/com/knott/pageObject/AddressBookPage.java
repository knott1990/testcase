package com.knott.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.knott.util.ObjectMap;

public class AddressBookPage {
	private WebElement element = null;
	//指定页面元素定位表达式配置文件的绝对文件路径
	private ObjectMap objMap = new ObjectMap("E:\\workspace\\SeleniumProj\\objectMap.properties");
	private WebDriver driver;
	
	public AddressBookPage(WebDriver driver){
		this.driver = driver;
	}

	public WebElement openAddBook() throws Exception{
		element = driver.findElement(objMap.getLocator("qqmail.homePage.addressBook"));
		return element;
	}
	
	public WebElement creatContactPersonButton() throws Exception{
		element = driver.findElement(objMap.getLocator("qqmail.addressBook.createContactPerson"));
		return element;
	}
	
	public WebElement contactPersonName() throws Exception{
		element = driver.findElement(objMap.getLocator("qqmail.addressBook.contactPersonName"));
		return element;
	}
	
	public WebElement contactPersonEmail() throws Exception{
		element = driver.findElement(objMap.getLocator("qqmail.addressBook.contactPersonEmail"));
		return element;
	}
	
	public WebElement contactPersonTel() throws Exception{
		element = driver.findElement(objMap.getLocator("qqmail.addressBook.contactPersonTel"));
		return element;
	}
	
	public WebElement saveButton() throws Exception{
		element = driver.findElement(objMap.getLocator("qqmail.addressBook.saveButton"));
		return element;
	}
}
