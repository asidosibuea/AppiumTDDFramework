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
import com.qa.pages.IntroScreenPage;
import com.qa.pages.LoginPage;
import com.qa.pages.PenjualanPage;
import com.qa.pages.popup.PopupBiayaKirim;
import com.qa.pages.popup.PopupItem;
import com.qa.pages.popup.PopupStatusOrder;
import com.qa.pages.popup.PopupTopping;
import com.qa.utils.TestUtils;

public class MenambahDeliveryTest extends BaseTest{
	IntroScreenPage introPage;
	LoginPage loginPage;
	PenjualanPage penjualanPage;
	SidebarPage sidebar;
	PopupItem itemPopUp;
	PopupTopping popupTopping;
	PopupStatusOrder popupStatusOrder;
	PopupBiayaKirim popupBiayaKirim;
	
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
	public void menambahDelivery() {
		penjualanPage.pilihKategori1();
		penjualanPage.TambahKeranjang1();
		popupStatusOrder = penjualanPage.pressbtnOrderType();
		penjualanPage = popupStatusOrder.pressbtnTakeAway();
		
		String expectedStatus = getStrings().get("status_order");
		String actualStatus = penjualanPage.getStatusOrder();
		Assert.assertEquals(actualStatus, expectedStatus);
		
		penjualanPage.totalHarga();
		penjualanPage.pressBtnShowOrder();
		popupBiayaKirim = penjualanPage.pressbtnDelivery();
		popupBiayaKirim.pressbtnAddDelivery();
		popupBiayaKirim.enterBiayaKirim(getStrings().get("biaya_delivery"));
		penjualanPage = popupBiayaKirim.pressbtnAddDeliveryFee();
		penjualanPage.totalHarga();
	}
	
	@Test(priority = 3)
	public void logout() {
		sidebar = penjualanPage.showSidebar();
		sidebar.pressLogoutBtn();
		loginPage = sidebar.pressConfirmLogoutBtn();
		
	}
}
