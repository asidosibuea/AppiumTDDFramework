package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.pages.PenjualanPage;
import com.qa.pages.SettingPage;
import com.qa.pages.IntroScreenPage;
import com.qa.pages.LoginPage;
import com.qa.utils.TestUtils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

//@Listeners
public class UbahPasswordTest extends BaseTest{
	
	IntroScreenPage introPage;
	LoginPage loginPage;
	PenjualanPage penjualanPage;
	SidebarPage sidebar;
	SettingPage settingPage;
	
	JSONObject dataTest;
	TestUtils utils = new TestUtils();

	@BeforeClass
	public void beforeClass() throws Exception {
		InputStream dataInStream = null;
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
		
//		introPage = new IntroScreenPage();
		loginPage = new LoginPage();
		
	}

	@AfterMethod
	public void afterMethod() {
		utils.log().info("Login test after method");
	}

	public PenjualanPage loginValidUser() {
		String username = "";
		String password = "";
		username = dataTest.getJSONObject("validUserPass").getString("username");
		password = dataTest.getJSONObject("validUserPass").getString("password");


		loginPage.enterUsername(username);
		loginPage.enterPassword(password);

		penjualanPage = loginPage.pressLoginBtn();
		return new PenjualanPage();

	}
	
	@Test
	public void ubahPass() {
		String passLama1 = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("ubahPass").getString("passLama1");
		String passbaru1 = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("ubahPass").getString("passbaru1");
		String passbaru2 = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("ubahPass").getString("passbaru2");
		String username = dataTest.getJSONObject("validUserPass").getString("username");

		loginPage.enterUsername(username);
		loginPage.enterPassword(passLama1);

		penjualanPage = loginPage.pressLoginBtn();
		sidebar = penjualanPage.swipeToSidebar();
		settingPage = sidebar.presspengaturanPage();
		settingPage.masukubahpassSubmenu();
		settingPage.enteroldPassword(passLama1);
		settingPage.enternewPassword(passbaru1);
		settingPage.enterreTypeNewPassword(passbaru1);
		settingPage.pressbtnCreateNewPassCustomer();
		settingPage.pressconfirmUbahpass();
		sidebar = settingPage.pressbtnBar();
		sidebar.pressBtnLogout();
		loginPage = sidebar.pressConfirmButton();
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(passbaru1);

		penjualanPage = loginPage.pressLoginBtn();
		sidebar = penjualanPage.swipeToSidebar();
		settingPage = sidebar.presspengaturanPage();
		settingPage.masukubahpassSubmenu();
		settingPage.enteroldPassword(passbaru1);
		settingPage.enternewPassword(passbaru2);
		settingPage.enterreTypeNewPassword(passbaru2);
		settingPage.pressbtnCreateNewPassCustomer();
		settingPage.pressconfirmUbahpass();
		sidebar = settingPage.pressbtnBar();
		sidebar.pressBtnLogout();
		loginPage = sidebar.pressConfirmButton();
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(passbaru2);

		penjualanPage = loginPage.pressLoginBtn();
		sidebar = penjualanPage.swipeToSidebar();
		sidebar.pressBtnLogout();
		loginPage = sidebar.pressConfirmButton();

	}
	
//	@Test
	public void logout() {
//		sidebar = penjualanPage.showSidebar();
		sidebar.pressLogoutBtn();
		loginPage = sidebar.pressConfirmLogoutBtn();
		
	}


		

}
