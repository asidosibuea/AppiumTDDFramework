package com.qa.tests;

import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.pages.LoginPage;
import com.qa.pages.PenjualanPage;
import com.qa.pages.SettingPage;
import com.qa.pages.setting.BahasaPage;
import com.qa.reports.ExtentReport;
import com.qa.utils.TestUtils;

public class LanguageSettingTest extends BaseTest{
	
	LoginPage loginPage;
	PenjualanPage penjualanPage;
	SidebarPage sidebar;
	SettingPage settingPage;
	BahasaPage bahasaPage;
	JSONObject dataTest;
	TestUtils utils = new TestUtils();

	@BeforeClass
	public void beforeClass() throws Exception {
		dataTest = utils.getDataTest();
	}

	@AfterClass
	public void afterClass() {
	}
	
	@BeforeMethod
	public void beforeMethod(Method m) {		
		utils.log().info("\n\n *******Starting test: "+ m.getName() + " *******\n");	
		launchApp();
		loginPage = new LoginPage();
	}

	@AfterMethod
	public void afterMethod() {
		utils.log().info("--- After test method ----");
		closeApp();
	}
	
	public PenjualanPage validLogin() {
		loginPage.pressLanguageDropdown().pressIndonesianLang();
		String username = dataTest.getJSONObject("validUserPass").getString("username");
		String password = dataTest.getJSONObject("validUserPass").getString("password");
		
		return loginPage.login(username, password);
	}
	
	public LoginPage logout() {
		return bahasaPage.showSidebar().pressLogoutBtn().pressConfirmLogoutBtn();
	}
	
	@Test
	public void setBahasaIndonesia() {
		penjualanPage = validLogin();
		settingPage = penjualanPage.showSidebar().pressPengaturanMenu();
		bahasaPage = settingPage.pressBahasaMenu();
		
		boolean isSelectedBahasa = bahasaPage.getStatusBahasa();
		
		if (!isSelectedBahasa) {
			bahasaPage.pressIndonesianLangBtn();
			
			String actualTitlePage = bahasaPage.getPageTitle();
			String expectedTitlePage =  getStrings().get("title_in");
			
			Assert.assertEquals(actualTitlePage, expectedTitlePage);
		} else {
			utils.log().info("tidak perlu setting bahasa, bahasa indonesia sudah terpilih");
			ExtentReport.getTest().log(Status.INFO, "tidak perlu setting bahasa, bahasa indonesia sudah terpilih");
		}
	}
	
	@Test
	public void setBahasaInggris() {
		penjualanPage = validLogin();
		settingPage = penjualanPage.showSidebar().pressPengaturanMenu();
		bahasaPage = settingPage.pressBahasaMenu();
		
		boolean isSelectedEnglish = bahasaPage.getStatusEnglish();
		
		if (!isSelectedEnglish) {
			bahasaPage.pressEnglishLangBtn();
			
			String actualTitlePage = bahasaPage.getPageTitle();
			String expectedTitlePage =  getStrings().get("title_en");
			
			Assert.assertEquals(actualTitlePage, expectedTitlePage);
		} else {
			utils.log().info("tidak perlu setting bahasa, bahasa inggris sudah terpilih");
			ExtentReport.getTest().log(Status.INFO, "tidak perlu setting bahasa, bahasa inggris sudah terpilih");
		}
	}
}
