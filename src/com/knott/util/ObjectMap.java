package com.knott.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

/**
 * ��������ʵ�����ⲿ�����ļ���
 * ����ҳ��Ԫ�صĶ�λ���ʽ
 * ����ҳ���������࣬��ȡָ����properties�ļ���ʶ��Ԫ�ض�λ���ʽ
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
	//���ݱ���ElementNameInproFile�����������ļ��ж�ȡ��Ӧ�����ö���
	String locator = propertise.getProperty(ElementNameInproFile);
	//�����ö����еĶ�λ���ʹ浽locatorType����������λ���ʽ��ֵ����loatorValue����
	String locatorType = locator.split(">")[0];
	String locatorValue = locator.split(">")[1];
	/*��Eclipse�������ļ���Ĭ��ΪISO-8859-1���봢��
	 * ʹ��getBytes�������Խ��ַ�������ת��ΪUTF-8����
	 * �Դ�������������ļ���ȡ����Ϊ���������
	 */
	locatorValue = new String(locatorValue.getBytes("ISO-8859-1"),"UTF-8");
	System.out.println("��ȡ�Ķ�λ���ͣ�"+ locatorType + "\t ��ȡ�Ķ�λ���ʽ��"+ locatorValue);
	//����locatorType�ı���ֵ�����жϷ��غ��ֶ�λ��ʽ��By����
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
		throw new Exception("����� ��λ���� δ�����壺"+ locatorType);
	
	}
}