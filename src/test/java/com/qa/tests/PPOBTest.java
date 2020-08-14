package com.qa.tests;

import java.io.InputStream;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.pages.LoginPage;
import com.qa.pages.PenjualanPage;
import com.qa.pages.penjualan.AllMenuPage;
import com.qa.pages.penjualan.CheckoutPLN;
import com.qa.pages.penjualan.PLNDenomPage;
import com.qa.pages.penjualan.PPOBPage;
import com.qa.pages.penjualan.TopupPLNPage;
import com.qa.utils.TestUtils;

public class PPOBTest extends BaseTest{
	
	LoginPage loginPage;
	PenjualanPage penjualanPage;
	SidebarPage sidebar;
	AllMenuPage allmenuPage;
	PPOBPage ppobPage;
	TopupPLNPage topupPlnPage;
	PLNDenomPage plnDenomPage;
	CheckoutPLN checkoutPage;
	
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
		utils.log().info("Login test after method");
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
	public void bayarTagihanPLNPrabayar5ribu() {
		
		String idPelanggan = dataTest.getString("idPlnPrepaid");
		
		penjualanPage = validLogin();
		allmenuPage = penjualanPage.pressAllMenuBtn();
		ppobPage = allmenuPage.pressSwitchToPPOBBtn();
		String balance1 = ppobPage.getTotalSaldo();

		topupPlnPage = ppobPage.pressBayarPLN();
		String balance2 = topupPlnPage.getTotalSaldo();
		topupPlnPage.selectOpsiPrabayar().enterIdPelanggan(idPelanggan);
		
		plnDenomPage = topupPlnPage.pressProsesOrderBtn();
		String balance3 = plnDenomPage.getTotalSaldo();
//		plnDenomPage.pressSaldo();
		
		
		checkoutPage = plnDenomPage.pilihDenom50Ribu();
		String balance4 = checkoutPage.getTotalSaldo();
//		checkoutPage.pressSaldo();
		
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(balance1.trim(), balance2.trim());
		softAssert.assertEquals(balance2, balance3);
		softAssert.assertEquals(balance3, balance4);
		
		ppobPage = checkoutPage.pressConfirmBtn();
		String actualStatusTrx = ppobPage.getPopupMsg();
		String expedtedStatusTrx = getStrings().get("expected_success_trx_ppob");
		
		softAssert.assertEquals(actualStatusTrx.trim(), expedtedStatusTrx);
		
		ppobPage.pressConfirmPopup("success");
		softAssert.assertAll();
		
	}

}
