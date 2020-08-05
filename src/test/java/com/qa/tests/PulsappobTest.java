package com.qa.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.pages.AllmenuPage;
import com.qa.pages.PenjualanPage;
import com.qa.pages.IntroScreenPage;
import com.qa.pages.LoginPage;
import com.qa.pages.PembayaranPage;
import com.qa.pages.PpobPage;
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
public class PulsappobTest extends BaseTest{

	IntroScreenPage introPage;
	LoginPage loginPage;
	PenjualanPage PenjualanPage;
	SidebarPage sidebar;
	AllmenuPage allmenuPage;
	PpobPage ppobPage;
	PembayaranPage pembayaranPage;

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

	//	@Test (priority = 1)
	public PenjualanPage loginValidUser() {
		String username = "";
		String password = "";
		username = dataTest.getJSONObject("validUserPass").getString("username");
		password = dataTest.getJSONObject("validUserPass").getString("password");


		loginPage.enterUsername(username);
		loginPage.enterPassword(password);

		PenjualanPage = loginPage.pressLoginBtn();
		return new PenjualanPage();

	}

	public PembayaranPage beliBarangcash(String cashAmount) {
		String namaPel = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("dataPembayaran").getString("namaPel");
		String emailPel = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("dataPembayaran").getString("emailPel");
		String tlpPel = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("dataPembayaran").getString("tlpPel");
		//		pembayaranPage = PenjualanPage.pressbtnTotal();
//		pembayaranPage.inputtxtCashAmount(cashAmount);
		pembayaranPage.pressbtnCash();
		//		pembayaranPage.pilihPecahanlima();
		//		pembayaranPage.pilihPecahanempat();
		//		pembayaranPage.pilihPecahantiga();
//		pembayaranPage.pilihPecahandua();
		pembayaranPage.pilihPecahansatu();
		
		String actualuangTunai = pembayaranPage.gettxtCashAmount();
		String expecteduangTunai = cashAmount;
		SoftAssert softassert= new SoftAssert();
		softassert.assertEquals(actualuangTunai, expecteduangTunai);


		scrollToElement("textContains", "Masukan Nama Pelanggan", "scroll ke element : Masukan Nama Pelanggan");
		pembayaranPage.inputtxtCustomerNameCash(namaPel);
		scrollToElement("textContains", "Masukan Telepon Pelanggan", "scroll ke element : Masukan Telepon Pelanggan");
		pembayaranPage.inputtxtCustomerPhoneCash(tlpPel);
		scrollToElement("textContains", "Masukan Email Pelanggan", "scroll ke element : Masukan Email Pelanggan");
		pembayaranPage.inputtxtCustomerEmailCash(emailPel);
		pembayaranPage.pressswDoubleReceipt();
		pembayaranPage.pressswEmailReceipt();
		softassert.assertAll();
		return new PembayaranPage();
	}

	public void prosespulsaPpob(String a1,String a2,String b,String c,String d,String e,String f) {

		String expectedNumber = getStrings().get(a1);
		String actualNumber = ppobPage.getdetailphoneNumber();
		String expectedDenom = getStrings().get(a2);
		String actualDenom = ppobPage.getdetaildenomPulsa();
		String expectedTotal = getStrings().get(b);
		String actualTotal = ppobPage.getdetailtotalPulsa();
		ppobPage.pressbtnConfirmppob();
		String expectedKet = getStrings().get("expected_keterangan");
		String actualKet = ppobPage.getcontentText();
		ppobPage.pressconfirmButton();
		String expectedLbl = getStrings().get(c);
		String actualLbl = ppobPage.getlblName();
		String expectedPrice = getStrings().get(d);
		String actualPrice = ppobPage.getlblPrice();
		String expectedQty = getStrings().get("expected_qty");
		String actualQty = ppobPage.getlblQty();
		ppobPage.pressbtnShowOrder();
		String expectedSubtotalppob = getStrings().get(e);
		String actualSubtotalppob = ppobPage.getlblPpob();
		String expectedQtyorder = getStrings().get("expected_qty");
		String actualQtyorder = ppobPage.getlblQuantity();
		ppobPage.pressbtnHideOrder();
		pembayaranPage = ppobPage.pressbtnOrder();
		String uangTunai = getStrings().get(d);
		pembayaranPage = beliBarangcash(uangTunai);
		pembayaranPage.pressbtnPay();
		String expectedlblTitle = getStrings().get("expected_lbltitlebayar");
		String actuallblTitle = pembayaranPage.getlblTitle();
		String expectedlblTotal = getStrings().get(d);
		String actuallblTotal = pembayaranPage.getlblTotal();
		String expectedlblMethod = getStrings().get("expected_lblMethodbayar");
		String actuallblMethod = pembayaranPage.getlblMethod();
		String expectedlblPay = getStrings().get(d);
		String actuallblPay = pembayaranPage.getlblPay();
		String expectedlblChange = getStrings().get("expected_changebayar");
		String actuallblChange = pembayaranPage.getlblChange();
		ppobPage = pembayaranPage.pressbtnOkppob();
		sidebar = ppobPage.showSidebar();
		loginPage = logout();
		SoftAssert softassert= new SoftAssert();
		softassert.assertEquals(actualNumber, expectedNumber);
		softassert.assertEquals(actualDenom, expectedDenom);
		softassert.assertEquals(actualTotal, expectedTotal);
		softassert.assertEquals(actualKet, expectedKet);
		softassert.assertEquals(actualKet, expectedKet);
		softassert.assertEquals(actualLbl, expectedLbl);
		softassert.assertEquals(actualLbl, expectedLbl);
		softassert.assertEquals(actualQty, expectedQty);
		softassert.assertEquals(actualPrice, expectedPrice);
		softassert.assertEquals(actualSubtotalppob, expectedSubtotalppob);
		softassert.assertEquals(actualQtyorder, expectedQtyorder);
		softassert.assertEquals(actuallblTitle, expectedlblTitle);
		softassert.assertEquals(actuallblTotal, expectedlblTotal);
		softassert.assertEquals(actuallblMethod, expectedlblMethod);
		softassert.assertEquals(actuallblPay, expectedlblPay);
		softassert.assertEquals(actuallblChange, expectedlblChange);
		softassert.assertAll();
		

	}

	@Test
	public void belipulsa5rbPpob() {
		String phonenumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("pulsaTelkomsel");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPulsappob();
		ppobPage.inputPhone(phonenumber);
		ppobPage.pressprosesPpob();
		ppobPage.pilihDenom5ribu();
		prosespulsaPpob("expected_phone_number","expected_denom5rb","expected_total5rb", "expected_lblnamepulsa5rb", "expected_lblpricepulsa5rb", "expected_totalorderpulsa5rb", "pulsa5rb");
	}
	
	@Test
	public void belipulsa10rbPpob() {
		String phonenumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("pulsaTelkomsel");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPulsappob();
		ppobPage.inputPhone(phonenumber);
		ppobPage.pressprosesPpob();
		ppobPage.pilihDenom10ribu();
		prosespulsaPpob("expected_phone_number","expected_denom10rb","expected_total10rb", "expected_lblnamepulsa10rb", "expected_lblpricepulsa10rb", "expected_totalorderpulsa10rb", "pulsa10rb");
	}
	
	@Test
	public void belipulsa20rbPpob() {
		String phonenumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("pulsaTelkomsel");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPulsappob();
		ppobPage.inputPhone(phonenumber);
		ppobPage.pressprosesPpob();
		ppobPage.pilihDenom20ribu();
		prosespulsaPpob("expected_phone_number","expected_denom20rb","expected_total20rb", "expected_lblnamepulsa20rb", "expected_lblpricepulsa20rb", "expected_totalorderpulsa20rb", "pulsa20rb");
	}
	
	@Test
	public void belipulsa25rbPpob() {
		String phonenumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("pulsaTelkomsel");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPulsappob();
		ppobPage.inputPhone(phonenumber);
		ppobPage.pressprosesPpob();
		ppobPage.pilihDenom25ribu();
		prosespulsaPpob("expected_phone_number","expected_denom25rb","expected_total25rb", "expected_lblnamepulsa25rb", "expected_lblpricepulsa25rb", "expected_totalorderpulsa25rb", "pulsa25rb");
	}
	
	@Test
	public void belipulsa100rbPpob() {
		String phonenumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("pulsaTelkomsel");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPulsappob();
		ppobPage.inputPhone(phonenumber);
		ppobPage.pressprosesPpob();
		ppobPage.pilihDenom100ribu();
		prosespulsaPpob("expected_phone_number","expected_denom100rb","expected_total100rb", "expected_lblnamepulsa100rb", "expected_lblpricepulsa100rb", "expected_totalorderpulsa100rb", "pulsa100rb");
	}
	
	@Test
	public void belipulsa50rbPpob() {
		String phonenumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("pulsaTelkomsel");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPulsappob();
		ppobPage.inputPhone(phonenumber);
		ppobPage.pressprosesPpob();
		ppobPage.pilihDenom50ribu();
		prosespulsaPpob("expected_phone_number","expected_denom50rb","expected_total50rb", "expected_lblnamepulsa50rb", "expected_lblpricepulsa50rb", "expected_totalorderpulsa50rb", "pulsa50rb");
	}
	
	@Test
	public void belipulsa150rbPpob() {
		String phonenumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("pulsaTelkomsel");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPulsappob();
		ppobPage.inputPhone(phonenumber);
		ppobPage.pressprosesPpob();
		ppobPage.pilihDenom150ribu();
		prosespulsaPpob("expected_phone_number","expected_denom150rb","expected_total150rb", "expected_lblnamepulsa150rb", "expected_lblpricepulsa150rb", "expected_totalorderpulsa150rb", "pulsa150rb");
	}
	
	@Test
	public void belipulsa200rbPpob() {
		String phonenumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("pulsaTelkomsel");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPulsappob();
		ppobPage.inputPhone(phonenumber);
		ppobPage.pressprosesPpob();
		ppobPage.pilihDenom200ribu();
		prosespulsaPpob("expected_phone_number","expected_denom200rb","expected_total200rb", "expected_lblnamepulsa200rb", "expected_lblpricepulsa200rb", "expected_totalorderpulsa200rb", "pulsa200rb");
	}
	
	@Test
	public void belipulsa300rbPpob() {
		String phonenumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("pulsaTelkomsel");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPulsappob();
		ppobPage.inputPhone(phonenumber);
		ppobPage.pressprosesPpob();
		ppobPage.pilihDenom300ribu();
		prosespulsaPpob("expected_phone_number","expected_denom300rb","expected_total300rb", "expected_lblnamepulsa300rb", "expected_lblpricepulsa300rb", "expected_totalorderpulsa300rb", "pulsa300rb");
	}
	
	@Test
	public void belipulsa1jtPpob() {
		String phonenumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("pulsaTelkomsel");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPulsappob();
		ppobPage.inputPhone(phonenumber);
		ppobPage.pressprosesPpob();
		ppobPage.pilihDenom1juta();
		prosespulsaPpob("expected_phone_number","expected_denom1jt","expected_total1jt", "expected_lblnamepulsa1jt", "expected_lblpricepulsa1jt", "expected_totalorderpulsa1jt", "pulsa1jt");
	}

	
	//	@Test (priority = 4)
	public LoginPage logout() {
		//		sidebar = PenjualanPage.showSidebar();
		sidebar.pressLogoutBtn();
		loginPage = sidebar.pressConfirmLogoutBtn();
		return new LoginPage();

	}


}
