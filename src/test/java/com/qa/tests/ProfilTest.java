package com.qa.tests;

import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
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
import com.qa.pages.setting.BahasaPage;
import com.qa.pages.setting.ProfilPage;
import com.qa.utils.TestUtils;

public class ProfilTest extends BaseTest{
	
	LoginPage loginPage;
	PenjualanPage dashboardPage;
	SidebarPage sidebar;
	SettingPage settingPage;
	ProfilPage profilPage;
	
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
		launchApp();
		utils.log().info("\n\n *******Starting test: "+ m.getName() + " *******\n");
		loginPage = new LoginPage();
	}

	@AfterMethod
	public void afterMethod() {
		closeApp();
	}
	
	public PenjualanPage validLogin() {
		String username = dataTest.getJSONObject("validUserPass").getString("username");
		String password = dataTest.getJSONObject("validUserPass").getString("password");
		
		return loginPage.login(username, password);
	}
	
	public LoginPage logout() {
		return sidebar.pressLogoutBtn().pressConfirmLogoutBtn();
	}
	
	@Test
	public void kosongkanSemuaRowFooter() {
//		loginPage.pressLanguageDropdown().pressIndonesianLang();
		dashboardPage = validLogin();
		settingPage = dashboardPage.showSidebar().pressPengaturanMenu();
		profilPage = settingPage.pressProfilMenu();
		profilPage.scrollToFooterDescription();
		
		String row1 = dataTest.getJSONObject("invalidFooter").getString("row1");
		String row2 = dataTest.getJSONObject("invalidFooter").getString("row2");
		
		profilPage.enterFooterRow1(row1);
		profilPage.enterFooterRow2(row2);
		profilPage.pressSaveFooterButton();
		
		String excpedtedMsg = getStrings().get("expected_failed_edit_footer");
		String actualMsg = profilPage.getPopupMsg();
		
		Assert.assertEquals(actualMsg, excpedtedMsg);
		profilPage.pressConfirmationButton("Failed");
		
		sidebar = profilPage.showSidebar();
		
		logout();
	}
	
	@Test
	public void kosongkanFooterRow1() {
//		loginPage.pressLanguageDropdown().pressIndonesianLang();
		dashboardPage = validLogin();
		settingPage = dashboardPage.showSidebar().pressPengaturanMenu();
		profilPage = settingPage.pressProfilMenu();
		profilPage.scrollToFooterDescription();
		
		String row1 = dataTest.getJSONObject("emptyFooterRow1").getString("row1");
		String row2 = dataTest.getJSONObject("emptyFooterRow1").getString("row2");
		
		profilPage.enterFooterRow1(row1);
		profilPage.enterFooterRow2(row2);
		profilPage.pressSaveFooterButton();
		
		String excpedtedMsg = getStrings().get("expected_failed_edit_footer");
		String actualMsg = profilPage.getPopupMsg();
		
		Assert.assertEquals(actualMsg, excpedtedMsg);
		profilPage.pressConfirmationButton("Failed");
		
		sidebar = profilPage.showSidebar();
		
		logout();
	}
	
	@Test
	public void kosongkanFooterRow2() {
//		loginPage.pressLanguageDropdown().pressIndonesianLang();
		dashboardPage = validLogin();
		settingPage = dashboardPage.showSidebar().pressPengaturanMenu();
		profilPage = settingPage.pressProfilMenu();
		profilPage.scrollToFooterDescription();
		
		String row1 = dataTest.getJSONObject("emptyFooterRow2").getString("row1");
		String row2 = dataTest.getJSONObject("emptyFooterRow2").getString("row2");
		
		profilPage.enterFooterRow1(row1);
		profilPage.enterFooterRow2(row2);
		profilPage.pressSaveFooterButton();
		
		String excpedtedMsg = getStrings().get("expected_success_edit_footer");
		String actualMsg = profilPage.getPopupMsg();
		
		Assert.assertEquals(actualMsg, excpedtedMsg);
		profilPage.pressConfirmationButton("Success");
		
		sidebar = profilPage.showSidebar();
		
		logout();
	}
	
	@Test
	public void isiSemuaRowFooter() {
//		loginPage.pressLanguageDropdown().pressIndonesianLang();
		dashboardPage = validLogin();
		settingPage = dashboardPage.showSidebar().pressPengaturanMenu();
		profilPage = settingPage.pressProfilMenu();
		profilPage.scrollToFooterDescription();
		
		String row1 = dataTest.getJSONObject("validFooter").getString("row1");
		String row2 = dataTest.getJSONObject("validFooter").getString("row2");
		
		profilPage.enterFooterRow1(row1);
		profilPage.enterFooterRow2(row2);
		profilPage.pressSaveFooterButton();
		
		String excpedtedMsg = getStrings().get("expected_success_edit_footer");
		String actualMsg = profilPage.getPopupMsg();
		
		Assert.assertEquals(actualMsg, excpedtedMsg);
		profilPage.pressConfirmationButton("Success");
		
		sidebar = profilPage.showSidebar();
		
		logout();
	}

}
