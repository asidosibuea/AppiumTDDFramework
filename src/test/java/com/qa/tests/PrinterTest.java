package com.qa.tests;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.time.Duration;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.pages.PenjualanPage;
import com.qa.pages.IntroScreenPage;
import com.qa.pages.LoginPage;
import com.qa.pages.SettingPage;
import com.qa.pages.setting.PrinterPage;
import com.qa.pages.setting.ProfilPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PrinterTest extends BaseTest{
	
	LoginPage loginPage;
	PenjualanPage dashboardPage;
	SidebarPage sidebar;
	SettingPage settingPage;
	PrinterPage printerPage;
	
	JSONObject dataTest;
	TestUtils utils = new TestUtils();
	

	public PrinterTest() {
		super();
	}

	@BeforeClass
	public void beforeClass() throws Exception {
		InputStream dataInStream = null;
		
		//dataTest
		dataInStream = null;
		try {
			String dataFileName = "data/data-test.json";
			dataInStream = getClass().getClassLoader().getResourceAsStream(dataFileName);
			JSONTokener tokener = new JSONTokener(dataInStream);
			
			dataTest = new JSONObject(tokener);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (dataInStream != null) {
				dataInStream.close();
			}
		}
		
		closeApp();
		launchApp();
	}

	@AfterClass
	public void afterClass() {
	}
	
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod(Method m) {
		utils.log().info("\n\n *******Starting test: "+ m.getName() + " *******\n");
		
		System.out.println("lagi jalanin before method");
		
		String username = dataTest.getJSONObject("validUserPass").getString("username");
		String password = dataTest.getJSONObject("validUserPass").getString("password");
		
		try {	
			loginPage = new LoginPage();
			loginPage.pressLanguageDropdown();
//			loginPage.pressIndonesianLang().login(username, password);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
		
		
		
	}

	@AfterMethod
	public void afterMethod() {
		utils.log().info("Printer test after method");
		loginPage = printerPage.showSidebar().pressLogoutBtn().pressConfirmLogoutBtn();
	}
	
//	public DashboardPage validLogin() {
//		loginPage.pressLanguageDropdown().pressIndonesianLang();
//		String username = dataTest.getJSONObject("validUserPass").getString("username");
//		String password = dataTest.getJSONObject("validUserPass").getString("password");
//		
//		return loginPage.login(username, password);
//	}
	
	public LoginPage logout() {
		return printerPage.showSidebar().pressLogoutBtn().pressConfirmLogoutBtn();
	}
	
	
	@Test
	public void nyalakanPrinter() {
		System.out.println("1");
//		dashboardPage = validLogin();
//		printerPage = dashboardPage.showSidebar().pressPengaturanMenu().pressPrinterMenu();
//		printerPage.switchOnStatusPrinter();
	}

}
