package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.pages.PenjualanPage;
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
public class LoginTest extends BaseTest{
	
	IntroScreenPage introPage;
	LoginPage loginPage;
	PenjualanPage penjualanPage;
	SidebarPage sidebar;
	
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
//		introPage = new IntroScreenPage();
		loginPage = new LoginPage();
		
	}

	@AfterMethod
	public void afterMethod() {
		utils.log().info("Login test after method");
		closeApp();
	}

	@Test
	public void loginValidUser() {
		String username = "";
		String password = "";
		username = dataTest.getJSONObject("AsidoDataTest").getJSONObject("validUserPass").getString("username");
		password = dataTest.getJSONObject("AsidoDataTest").getJSONObject("validUserPass").getString("password");
		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		
		penjualanPage = loginPage.pressLoginBtn();
		sidebar = penjualanPage.showSidebar();
		
		String expectedCashierName = getStrings().get("expected_staff_name");
		String actualCashierName = sidebar.getCashierName();
		
		Assert.assertEquals(expectedCashierName, actualCashierName);
		penjualanPage = (PenjualanPage) sidebar.hideSideBar(new PenjualanPage());
		
		
	}
	
	@Test
	public void loginInvalidUsername() {
		System.out.println(Thread.currentThread().getId());
		
		String username = "";
		String password = "";

		username = dataTest.getJSONObject("AsidoDataTest").getJSONObject("invalidUsername").getString("username");
		password = dataTest.getJSONObject("AsidoDataTest").getJSONObject("invalidUsername").getString("password");

		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.pressLoginBtn();
		
		loginPage.pressConfirmErrorBtn();
	}
	
	@Test
	public void loginInvalidPassword() {
		System.out.println(Thread.currentThread().getId());
		
		String username = "";
		String password = "";
		
		username = dataTest.getJSONObject("AsidoDataTest").getJSONObject("invalidPassword").getString("username");
		password = dataTest.getJSONObject("AsidoDataTest").getJSONObject("invalidPassword").getString("password");

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.pressLoginBtn();

		loginPage.pressConfirmErrorBtn();
	}
	
//	@Test
	public void logout() {
//		sidebar = dashboardPage.showSidebar();
		sidebar.pressLogoutBtn();
		loginPage = sidebar.pressConfirmLogoutBtn();
		
	}


		

}
