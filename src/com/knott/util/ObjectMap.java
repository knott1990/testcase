package com.knott.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

/**
 * 本类用于实现在外部配置文件中
 * 配置页面元素的定位表达式
 * 被测页面对象调起本类，读取指定的properties文件来识别元素定位表达式
 * @author win7
 *
 */
public class ObjectMap {
	Properties propertise;
	
	public ObjectMap(String propFile){
		propertise = new Properties();
		try {
			FileInputStream in = new FileInputStream(propFile);
			propertise.load(in);
			in.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

public By getLocator(String ElementNameInproFile) throws Exception{
	//根据变量ElementNameInproFile从属性配置文件中读取对应的配置对象
	String locator = propertise.getProperty(ElementNameInproFile);
	//将配置对象中的定位类型存到locatorType变量，将定位表达式的值存入loatorValue变量
	String locatorType = locator.split(">")[0];
	String locatorValue = locator.split(">")[1];
	/*在Eclipse中配置文件均默认为ISO-8859-1编码储存
	 * 使用getBytes方法可以将字符串编码转换为UTF-8编码
	 * 以此来解决在配置文件读取中文为乱码的问题
	 */
	locatorValue = new String(locatorValue.getBytes("ISO-8859-1"),"UTF-8");
	System.out.println("获取的定位类型："+ locatorType + "\t 获取的定位表达式："+ locatorValue);
	//根据locatorType的变量值内容判断返回何种定位方式的By对象
	if(locatorType.toLowerCase().equals("id")){
		return By.id(locatorValue);
	}
	else if(locatorType.toLowerCase().equals("name")){
		return By.name(locatorValue);
	}
	else if(locatorType.toLowerCase().equals("classname")){
		return By.className(locatorValue);
	}
	else if(locatorType.toLowerCase().equals("tagname")){
		return By.tagName(locatorValue);
	}
	else if(locatorType.toLowerCase().equals("linktext")){
		return By.linkText(locatorValue);
	}
	else if(locatorType.toLowerCase().equals("partiallinktext")){
		return By.partialLinkText(locatorValue);
	}
	else if(locatorType.toLowerCase().equals("cssselector")){
		return By.cssSelector(locatorValue);
	}
	else if(locatorType.toLowerCase().equals("xpath")){
		return By.xpath(locatorValue);
	}
	else
		throw new Exception("输入的 定位类型 未被定义："+ locatorType);
	
	}
}