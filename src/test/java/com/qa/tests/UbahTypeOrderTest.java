package com.qa.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
public class UbahTypeOrderTest extends BaseTest{

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

	//	test pilih tipe order dine in
	@Test
	public void ubahTypeorderdinein() {
		penjualanPage = loginValidUser();

		penjualanPage.pressbtnOrderType();
		penjualanPage.pressbtnOrderDineIn();

		String actualOrdertype = penjualanPage.getHasilbtnOrderType();
		String expectedOrdertype = getStrings().get("expected_true_dineinordertype");	

		SoftAssert softAssertdinein = new SoftAssert();
		softAssertdinein.assertEquals(actualOrdertype, expectedOrdertype);

		logout();

		softAssertdinein.assertAll();
		//		softAsserttakeaway.assertAll();
	}

	//	test pilih tipe order takeaway
	@Test
	public void ubahTypeordertakeaway() {
		penjualanPage = loginValidUser();

		penjualanPage.pressbtnOrderType();
		penjualanPage.pressbtnOrderTakeAway();

		String actualOrdertypet= penjualanPage.getHasilbtnOrderType();
		String expectedOrdertypet = getStrings().get("expected_true_takeawayordertype");	

		SoftAssert softAsserttakeaway = new SoftAssert();
		softAsserttakeaway.assertEquals(actualOrdertypet, expectedOrdertypet);		

		logout();

		softAsserttakeaway.assertAll();
	}

	//	test pilih tipe order lainnya
	@Test 
	public void ubahTypeorderlainnya() {
		penjualanPage = loginValidUser();

		penjualanPage.pressbtnOrderType();
		penjualanPage.pressbtnOrderMore();

		String actualOrderMore = penjualanPage.getHasilconfrimMoreorder();
		String expectedOrderMore = getStrings().get("expected_true_confirmmoreorder");	

		SoftAssert softAssertmoreorder = new SoftAssert();
		softAssertmoreorder.assertEquals(actualOrderMore, expectedOrderMore);		

		penjualanPage.pressbtnconfrimMoreorder();
		logout();

		softAssertmoreorder.assertAll();
	}

	//	@Test
	public void logout() {
		sidebar = penjualanPage.showSidebar();
		sidebar.pressLogoutBtn();
		loginPage = sidebar.pressConfirmLogoutBtn();

	}




}
