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
public class PlnppobTest extends BaseTest{
	
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

	public PembayaranPage beliBarangcash(String cashAmount) {
		String namaPel = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("dataPembayaran").getString("namaPel");
		String emailPel = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("dataPembayaran").getString("emailPel");
		String tlpPel = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("dataPembayaran").getString("tlpPel");
//		pembayaranPage = PenjualanPage.pressbtnTotal();
		pembayaranPage.inputtxtCashAmount(cashAmount);
		pembayaranPage.pressbtnCash();
//		pembayaranPage.pilihPecahanlima();
//		pembayaranPage.pilihPecahanempat();
//		pembayaranPage.pilihPecahantiga();
		pembayaranPage.pilihPecahandua();
		pembayaranPage.pilihPecahansatu();
		
		scrollToElement("textContains", "Masukan Nama Pelanggan", "scroll ke element : Masukan Nama Pelanggan");
		pembayaranPage.inputtxtCustomerNameCash(namaPel);
		scrollToElement("textContains", "Masukan Telepon Pelanggan", "scroll ke element : Masukan Telepon Pelanggan");
		pembayaranPage.inputtxtCustomerPhoneCash(tlpPel);
		scrollToElement("textContains", "Masukan Email Pelanggan", "scroll ke element : Masukan Email Pelanggan");
		pembayaranPage.inputtxtCustomerEmailCash(emailPel);
		pembayaranPage.pressswDoubleReceipt();
		pembayaranPage.pressswEmailReceipt();
		return new PembayaranPage();
	}
//	@Test
	public PenjualanPage loginValidUser() {
		String username = "";
		String password = "";
		username = dataTest.getJSONObject("AsidoDataTest").getJSONObject("validUserPass").getString("username");
		password = dataTest.getJSONObject("AsidoDataTest").getJSONObject("validUserPass").getString("password");

		
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		
		PenjualanPage = loginPage.pressLoginBtn();
		return new PenjualanPage();
		
	}
	
	@Test 
	public void beliplnnontaglistPpob() {
		String idPel = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("plnNontaglis");
		
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPlnppob();
		ppobPage.inputelectricNumber(idPel);
		ppobPage.pressbeliPlnnontaglis();
		ppobPage.pressprosesPpob();
		prosesplnPpob("expected_namapel","expected_idpelnontaglist","expected_billnontaglist", "expected_totalnontaglist", "expected_lblnameplnnontl", "expected_lblpriceplnnontl", "expected_totalorderplnnontl", "plnnontl");
	}
	
	@Test
	public void beliplnpascaPpob() {
		String idPel = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("plnPascabayar");
		
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPlnppob();
		ppobPage.inputelectricNumber(idPel);
		ppobPage.pressbeliPlnpostpaid();
		ppobPage.pressprosesPpob();
		prosesplnpostntPpob("expected_namapel","expected_idpelpost","expected_bill", "expected_totalpost", "expected_lblnameplnpost", "expected_lblpriceplnpost", "expected_totalorderplnpost", "plnpost");
		
	}
	
public void prosesplnpostntPpob(String a1,String a2,String a, String b,String c,String d,String e,String f) {
		
		String expectedName = getStrings().get(a1);
		String actualName = ppobPage.getdetailnama();
		String expectedNumber = getStrings().get(a2);
		String actualNumber = ppobPage.getdetailkonfirmelectricNumber();
		String expectedDenom = getStrings().get(a);
		String actualDenom = ppobPage.getdetailelectricBill();
		String expectedTotal = getStrings().get(b);
		String actualTotal = ppobPage.getdetailkonfirmtotal();
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
		String uangTunai = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString(f);
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
		SoftAssert softassert= new SoftAssert();
		softassert.assertEquals(actualName, expectedName);
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
		sidebar = ppobPage.showSidebar();
		loginPage = logout();
		
	}
	
//	fungsi buat prosesplnpprapob
	public void prosesplnPpob(String a1,String a2,String a, String b,String c,String d,String e,String f) {
		
		String expectedName = getStrings().get(a1);
		String actualName = ppobPage.getdetailnama();
		String expectedNumber = getStrings().get(a2);
		String actualNumber = ppobPage.getdetailkonfirmelectricNumber();
		String expectedDenom = getStrings().get(a);
		String actualDenom = ppobPage.getdetailelectric();
		String expectedTotal = getStrings().get(b);
		String actualTotal = ppobPage.getdetailkonfirmtotal();
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
		String uangTunai = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString(f);
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
		SoftAssert softassert= new SoftAssert();
		softassert.assertEquals(actualName, expectedName);
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
		sidebar = ppobPage.showSidebar();
		loginPage = logout();
		
	}
	
	@Test
	public void beliplnpra20Ppob() {
		String idPel = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("plnPrabayar");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPlnppob();
		ppobPage.inputelectricNumber(idPel);
		ppobPage.pressbeliPlnprepaid();
		ppobPage.pressprosesPpob();
		ppobPage.pilihDenom20ribu();
		prosesplnPpob("expected_namapel","expected_idpel","expected_plndenom20rb", "expected_plntotal20rb", "expected_lblnameplnpra20rb", "expected_lblpriceplnpra20rb", "expected_totalorderplnpra20rb", "pln20rb");
	}	
	
	@Test
	public void beliplnpra50Ppob() {
		String idPel = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("plnPrabayar");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPlnppob();
		ppobPage.inputelectricNumber(idPel);
		ppobPage.pressbeliPlnprepaid();
		ppobPage.pressprosesPpob();
		ppobPage.pilihDenom50ribu();
		prosesplnPpob("expected_namapel","expected_idpel","expected_plndenom50rb", "expected_plntotal50rb", "expected_lblnameplnpra50rb", "expected_lblpriceplnpra50rb", "expected_totalorderplnpra50rb", "pln50rb");
	}
	
	@Test
	public void beliplnpra100Ppob() {
		String idPel = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("plnPrabayar");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPlnppob();
		ppobPage.inputelectricNumber(idPel);
		ppobPage.pressbeliPlnprepaid();
		ppobPage.pressprosesPpob();
		ppobPage.pilihDenom100ribu();
		prosesplnPpob("expected_namapel","expected_idpel","expected_plndenom100rb", "expected_plntotal100rb", "expected_lblnameplnpra100rb", "expected_lblpriceplnpra100rb", "expected_totalorderplnpra100rb", "pln100rb");
	}
	
	@Test
	public void beliplnpra200Ppob() {
		String idPel = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("plnPrabayar");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPlnppob();
		ppobPage.inputelectricNumber(idPel);
		ppobPage.pressbeliPlnprepaid();
		ppobPage.pressprosesPpob();
		ppobPage.pilihDenom200ribu();
		prosesplnPpob("expected_namapel","expected_idpel","expected_plndenom200rb", "expected_plntotal200rb", "expected_lblnameplnpra200rb", "expected_lblpriceplnpra200rb", "expected_totalorderplnpra200rb", "pln200rb");
	}
	
	@Test
	public void beliplnpra500Ppob() {
		String idPel = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("plnPrabayar");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPlnppob();
		ppobPage.inputelectricNumber(idPel);
		ppobPage.pressbeliPlnprepaid();
		ppobPage.pressprosesPpob();
		ppobPage.pilihDenom500ribu();
		prosesplnPpob("expected_namapel","expected_idpel","expected_plndenom500rb", "expected_plntotal500rb", "expected_lblnameplnpra500rb", "expected_lblpriceplnpra500rb", "expected_totalorderplnpra500rb", "pln500rb");
	}
	
	@Test
	public void beliplnpra1jtPpob() {
		String idPel = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("plnPrabayar");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPlnppob();
		ppobPage.inputelectricNumber(idPel);
		ppobPage.pressbeliPlnprepaid();
		ppobPage.pressprosesPpob();
		ppobPage.pilihDenom1juta();
		prosesplnPpob("expected_namapel","expected_idpel","expected_plndenom1jt", "expected_plntotal1jt", "expected_lblnameplnpra1jt", "expected_lblpriceplnpra1jt", "expected_totalorderplnpra1jt", "pln1jt");
	}
	
	@Test
	public void beliplnpra5jtPpob() {
		String idPel = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("plnPrabayar");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPlnppob();
		ppobPage.inputelectricNumber(idPel);
		ppobPage.pressbeliPlnprepaid();
		ppobPage.pressprosesPpob();
		ppobPage.pilihDenom5Jt();
		prosesplnPpob("expected_namapel","expected_idpel","expected_plndenom5jt", "expected_plntotal5jt", "expected_lblnameplnpra5jt", "expected_lblpriceplnpra5jt", "expected_totalorderplnpra5jt", "pln5jt");
	}
	
	@Test
	public void beliplnpra10jtPpob() {
		String idPel = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("plnPrabayar");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPlnppob();
		ppobPage.inputelectricNumber(idPel);
		ppobPage.pressbeliPlnprepaid();
		ppobPage.pressprosesPpob();
		ppobPage.pilihDenom10Jt();
		prosesplnPpob("expected_namapel","expected_idpel","expected_plndenom10jt", "expected_plntotal10jt", "expected_lblnameplnpra10jt", "expected_lblpriceplnpra10jt", "expected_totalorderplnpra10jt", "pln10jt");
	}	

	
//	@Test (priority = 4)
	public LoginPage logout() {
//		sidebar = PenjualanPage.showSidebar();
		sidebar.pressLogoutBtn();
		loginPage = sidebar.pressConfirmLogoutBtn();
		return new LoginPage();
		
	}
			

}
