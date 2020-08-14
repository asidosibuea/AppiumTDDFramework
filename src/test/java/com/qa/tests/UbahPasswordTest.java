package com.qa.tests;

import java.lang.reflect.Method;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.pages.LoginPage;
import com.qa.pages.PenjualanPage;
import com.qa.pages.SettingPage;
import com.qa.pages.setting.UbahPasswordPage;
import com.qa.utils.TestUtils;

public class UbahPasswordTest extends BaseTest{

	LoginPage loginPage;
	PenjualanPage dashboardPage;
	SidebarPage sidebar;
	SettingPage settingPage;
	PenjualanPage penjualanPage;
	UbahPasswordPage editPasswordPage;
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
		utils.log().info("\n *******Starting test: "+ m.getName() + " *******\n");	
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
		return editPasswordPage.showSidebar().pressLogoutBtn().pressConfirmLogoutBtn();
	}
	
	@Test
	public void emptyAllField() {
		penjualanPage = validLogin();
		settingPage = penjualanPage.showSidebar().pressPengaturanMenu();
		editPasswordPage = settingPage.pressUbahPasswordMenu();
		editPasswordPage.pressSimpanBtn();
		
		String actualMsg = editPasswordPage.getPopupMsg();
		String expectedMsg = getStrings().get("edit_password_empty_all_field");
		Assert.assertEquals(actualMsg, expectedMsg);
		
		editPasswordPage.pressPopupConfirmBtn();
		logout();
		
	}
	
	@Test
	public void emptyNewPassword() {
		penjualanPage = validLogin();
		settingPage = penjualanPage.showSidebar().pressPengaturanMenu();
		editPasswordPage = settingPage.pressUbahPasswordMenu();
		
		String oldPassword = dataTest.getString("oldPassword");
		String newPassword = dataTest.getString("emptyNewPassword");
		String emptyRetypePassword = dataTest.getString("emptyNewPassword");
		
		editPasswordPage.enterOldPassword(oldPassword);
		editPasswordPage.enterNewPassword(newPassword);
		editPasswordPage.retypePassword(emptyRetypePassword);
		editPasswordPage.pressSimpanBtn();
		
		String actualMsg = editPasswordPage.getPopupMsg();
		String expectedMsg = getStrings().get("empty_new_password");
		Assert.assertEquals(actualMsg, expectedMsg);
		
		editPasswordPage.pressPopupConfirmBtn();
		logout();
	}
	
	@Test
	public void emptyRetypePassword() {
		penjualanPage = validLogin();
		settingPage = penjualanPage.showSidebar().pressPengaturanMenu();
		editPasswordPage = settingPage.pressUbahPasswordMenu();
		
		String oldPassword = dataTest.getString("oldPassword");
		String newPassword = dataTest.getString("newPassword");
		String emptyRetypePassword = dataTest.getString("emptyNewPassword");
		
		editPasswordPage.enterOldPassword(oldPassword);
		editPasswordPage.enterNewPassword(newPassword);
		editPasswordPage.retypePassword(emptyRetypePassword);
		editPasswordPage.pressSimpanBtn();
		
		String actualMsg = editPasswordPage.getPopupMsg();
		String expectedMsg = getStrings().get("empty_retype_password");
		Assert.assertEquals(actualMsg, expectedMsg);
		
		editPasswordPage.pressPopupConfirmBtn();
		logout();
	}
	
}
