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

import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.pages.AktifitasPage;
import com.qa.pages.DiskonBillPage;
import com.qa.pages.LoginPage;
import com.qa.pages.PenjualanPage;
import com.qa.pages.RiwayatPage;
import com.qa.pages.popup.PopupItem;
import com.qa.pages.popup.PopupTopping;
import com.qa.utils.TestUtils;

public class MelakukanSettlementTest extends BaseTest{
	LoginPage loginPage;
	PenjualanPage penjualanPage;
	SidebarPage sidebar;
	PopupItem itemPopUp;
	PopupTopping popupTopping;
	DiskonBillPage diskonBillPage;
	RiwayatPage riwayatPage;
	AktifitasPage aktifitasPage;
	
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
	
	@Test(priority = 1)
	public void loginValidUser() {
		String username = "";
		String password = "";
		username = dataTest.getJSONObject("BagasDataTest").getJSONObject("validUserPass").getString("username");
		password = dataTest.getJSONObject("BagasDataTest").getJSONObject("validUserPass").getString("password");

		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		
		penjualanPage = loginPage.pressLoginBtn();
	}
	
	@Test(priority = 2)
	public void melihatTransaksi() {
		sidebar = penjualanPage.showSidebar();
		aktifitasPage = sidebar.pressAktifitasMenu();
		aktifitasPage.pressMenuSettlement();
		
//		String username = "";
//		String password = "";
//		username = dataTest.getJSONObject("BagasDataTest").getJSONObject("validUserPass").getString("username");
//		password = dataTest.getJSONObject("BagasDataTest").getJSONObject("validUserPass").getString("password");
		
//		aktifitasPage.enterUsername(username);
//		aktifitasPage.enterPassword(password);
		aktifitasPage.enterUsername(getStrings().get("username"));
		aktifitasPage.enterPassword(getStrings().get("password"));
		aktifitasPage.pressBtnSettlement();
		aktifitasPage.enterCashAmount(getStrings().get("cash_amount_settlement"));
		aktifitasPage.pressBtnSettlement();
		
		String expectedTitle = getStrings().get("status_settlement");
		String actualTitle = aktifitasPage.getTitleText();
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
		aktifitasPage.pressBtnCancel();
		aktifitasPage.pressBtnClose();
	}
	
	@Test(priority = 3)
	public void logout() {
		sidebar = aktifitasPage.showSidebar();
		sidebar.pressLogoutBtn();
		loginPage = sidebar.pressConfirmLogoutBtn();
		
	}
}
