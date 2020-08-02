package com.qa.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.qa.base.BaseTest;

public class TestUtils {
	
	public static final int WAIT = 10;
	public static final int WAITFORSWIPE = 15;
	public static final int WAITTEXTCHANGE = 120;
	public static final String ON = "ON";
	public static final String OFF = "OFF";
	
	public static final String UDIDBangAcil = "R9CMC04AD1J";
	public static final String UDIDAsido = "R9CMC05NZ3J";
	
	public HashMap<String, String> parseStringXML(InputStream file) throws Exception{
		HashMap<String, String> stringMap = new HashMap<String, String>();
		
		//Get Document Builder
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//Build Document
		Document document = builder.parse(file);
		
		//Normalize the XML structure; It's just too important
		document.getDocumentElement().normalize();
		
		//Here comes the root node
		Element root = document.getDocumentElement();
		
		//Get All Elements
		NodeList nList = document.getElementsByTagName("string");
		
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node node = nList.item(temp);
			
			if(node.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) node;
				
				//Store element key and value in map
				stringMap.put(element.getAttribute("name"), element.getTextContent());
			}
		}
		
		return stringMap;
	}
	
	public String getFormattedDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		Date date = new Date();
		
		return dateFormat.format(date);
		
	}
	
	public void log(String txt) {
		BaseTest base = new BaseTest();
		String msg = Thread.currentThread().getId() + ":" + base.getPlatform() + ":" + base.getDeviceName() + ":" 
				+ Thread.currentThread().getStackTrace()[2].getClassName() + ":" + txt;
		System.out.println(msg);
		
		String strFile = "logs" + File.separator + base.getPlatform() + "_" + base.getDeviceName() 
				+ File.separator + base.getDateTime();
		
		File logFile = new File(strFile);
		
		if (!logFile.exists()) {
			logFile.mkdirs();
		}
		
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(logFile + File.separator + "log.txt", true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println(msg);
		printWriter.close();
		
		
	}
	
	public Logger log() {
		return  LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName());
	}

}
