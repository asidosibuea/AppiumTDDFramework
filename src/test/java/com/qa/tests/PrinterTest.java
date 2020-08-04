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
	PenjualanPage penjualanPage;
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
	
	@BeforeMethod
	public void beforeMethod(Method m) {
		utils.log().info("\n\n *******Starting test: "+ m.getName() + " *******\n");	
		loginPage = new LoginPage();
	}

	@AfterMethod
	public void afterMethod() {
		utils.log().info("--- After test method ----");
	}
	
	public PenjualanPage validLogin() {
		loginPage.pressLanguageDropdown().pressIndonesianLang();
		String username = dataTest.getJSONObject("validUserPass").getString("username");
		String password = dataTest.getJSONObject("validUserPass").getString("password");
		
		return loginPage.login(username, password);
	}
	
	public LoginPage logout() {
		return printerPage.showSidebar().pressLogoutBtn().pressConfirmLogoutBtn();
	}
	
	
	@Test
	public void nyalakanPrinter() {
		penjualanPage = validLogin();
		printerPage = penjualanPage.showSidebar().pressPengaturanMenu().pressPrinterMenu();
		printerPage.switchOnStatusPrinter();
		
		
	}
	
	@Test
	public void gantiPrinterUtama() {
		penjualanPage = validLogin();
		printerPage = penjualanPage.showSidebar().pressPengaturanMenu().pressPrinterMenu();
		printerPage.switchOnStatusPrinter();
		
		
		
	}

}
