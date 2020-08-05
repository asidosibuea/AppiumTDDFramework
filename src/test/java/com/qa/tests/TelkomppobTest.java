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
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

//@Listeners
public class TelkomppobTest extends BaseTest{

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
	
	@Test
	public void belijastel1bPpob() {
		String jastelnumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("jasTel1b");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliTelkomppob();
		ppobPage.inputtxtCustomerId(jastelnumber);
		ppobPage.pressprosesPpob();
		
		String actualbranchCode = ppobPage.getbranchCode();
		String expectedbranchCode = getStrings().get("expectedbranchCodeJt");
		String actualdateTime = ppobPage.getdateTime();
		String expecteddateTime = utils.getFormattedDateTimeV2();
		String actualnoJasTel = ppobPage.getnoJasTel();
		String expectednoJasTel = getStrings().get("expectednoJasTel1b");
		String actualname = ppobPage.getname();
		String expectedname = getStrings().get("expectednameJt");
		String actualtelephone = ppobPage.gettelephone();
		String expectedtelephone = getStrings().get("expectedtelephone1b");
		String actualdivreDatel = ppobPage.getdivreDatel();
		String expecteddivreDatel = getStrings().get("expecteddivreDatel");
		String actualperiod = ppobPage.getperiod();
		String expectedperiod= getStrings().get("expectedperiode1b");
		String actualnoReffPeriod1 = ppobPage.getnoReffPeriod1();
		String expectednoReffPeriod1 = getStrings().get("expectednoReffPeriod1");
		String actualperiod1 = ppobPage.getperiod1();
		String expectedperiod1 = getStrings().get("expectedperiod1Jt");
		String actualamount = ppobPage.getamount();
		String expectedamount = getStrings().get("expectedamount1bJt");
		String actualadminCost = ppobPage.getadminCost();
		String expectedadminCost = getStrings().get("expectedadminCost1bJt");
		String actualpaymentTotal = ppobPage.getpaymentTotal();
		String expectedpaymentTotal = getStrings().get("expectedpaymentTotal1bJt");
//		scrollToElement("textContains", "Konfirmasi", "scroll ke element : Tombol Konfirmasi");
		ppobPage.pressbtnConfirmppob();
		String expectedKet = getStrings().get("expected_keterangan");
		String actualKet = ppobPage.getcontentText();
		
		ppobPage.pressconfirmButton();
		String expectedLbl = getStrings().get("expected_lblnameJt");
		String actualLbl = ppobPage.getlblName();
		String expectedPrice = getStrings().get("expected_lblprice1bJt");
		String actualPrice = ppobPage.getlblPrice();
		String expectedQty = getStrings().get("expected_qty");
		String actualQty = ppobPage.getlblQty();
		ppobPage.pressbtnShowOrder();
		String expectedSubtotalppob = getStrings().get("expected_totalorder1bJt");
		String actualSubtotalppob = ppobPage.getlblPpob();
		String expectedQtyorder = getStrings().get("expected_qty");
		String actualQtyorder = ppobPage.getlblQuantity();
		ppobPage.pressbtnHideOrder();
		String expectedtotalOrder = getStrings().get("expected_totalorder1bJt");
		String actualtotalOrder = ppobPage.getbtnOrder();
		pembayaranPage = ppobPage.pressbtnOrder();
		String uangTunai = getStrings().get("expected_lbltunai1bJt");
		pembayaranPage = beliBarangcash(uangTunai);
		pembayaranPage.pressbtnPay();
		String expectedlblTitle = getStrings().get("expected_lbltitlebayar");
		String actuallblTitle = pembayaranPage.getlblTitle();
		String expectedlblTotal = getStrings().get("expected_lblprice1bJt");
		String actuallblTotal = pembayaranPage.getlblTotal();
		String expectedlblMethod = getStrings().get("expected_lblMethodbayar");
		String actuallblMethod = pembayaranPage.getlblMethod();
		String expectedlblPay = getStrings().get("expected_lbltunai1bJt");
		String actuallblPay = pembayaranPage.getlblPay();
		String expectedlblChange = getStrings().get("expected_changebayar1bJt");
		String actuallblChange = pembayaranPage.getlblChange();
		ppobPage = pembayaranPage.pressbtnOkppob();
		sidebar = ppobPage.showSidebar();
		loginPage = logout();
		SoftAssert softassert= new SoftAssert();
		softassert.assertEquals(actualbranchCode, expectedbranchCode);
		softassert.assertEquals(actualdateTime, expecteddateTime);
		softassert.assertEquals(actualnoJasTel, expectednoJasTel);
		softassert.assertEquals(actualname, expectedname);
		softassert.assertEquals(actualtelephone, expectedtelephone);
		softassert.assertEquals(actualdivreDatel, expecteddivreDatel);
		softassert.assertEquals(actualperiod, expectedperiod);
		softassert.assertEquals(actualnoReffPeriod1, expectednoReffPeriod1);
		softassert.assertEquals(actualperiod1, expectedperiod1);
		softassert.assertEquals(actualamount, expectedamount);
		softassert.assertEquals(actualadminCost, expectedadminCost);
		softassert.assertEquals(actualpaymentTotal, expectedpaymentTotal);
		softassert.assertEquals(actualKet, expectedKet);
		softassert.assertEquals(actualKet, expectedKet);
		softassert.assertEquals(actualLbl, expectedLbl);
		softassert.assertEquals(actualLbl, expectedLbl);
		softassert.assertEquals(actualQty, expectedQty);
		softassert.assertEquals(actualPrice, expectedPrice);
		softassert.assertEquals(actualSubtotalppob, expectedSubtotalppob);
		softassert.assertEquals(actualQtyorder, expectedQtyorder);
		softassert.assertEquals(actualtotalOrder, expectedtotalOrder);
		softassert.assertEquals(actuallblTitle, expectedlblTitle);
		softassert.assertEquals(actuallblTotal, expectedlblTotal);
		softassert.assertEquals(actuallblMethod, expectedlblMethod);
		softassert.assertEquals(actuallblPay, expectedlblPay);
		softassert.assertEquals(actuallblChange, expectedlblChange);
		softassert.assertAll();
		
	}
	
	@Test
	public void belijastel2bPpob() {
		String jastelnumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("jasTel2b");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliTelkomppob();
		ppobPage.inputtxtCustomerId(jastelnumber);
		ppobPage.pressprosesPpob();
		
		String actualbranchCode = ppobPage.getbranchCode();
		String expectedbranchCode = getStrings().get("expectedbranchCodeJt");
		String actualdateTime = ppobPage.getdateTime();
		String expecteddateTime = utils.getFormattedDateTimeV2();
		String actualnoJasTel = ppobPage.getnoJasTel();
		String expectednoJasTel = getStrings().get("expectednoJasTel2b");
		String actualname = ppobPage.getname();
		String expectedname = getStrings().get("expectednameJt");
		String actualtelephone = ppobPage.gettelephone();
		String expectedtelephone = getStrings().get("expectedtelephone2b");
		String actualdivreDatel = ppobPage.getdivreDatel();
		String expecteddivreDatel = getStrings().get("expecteddivreDatel");
		String actualperiod = ppobPage.getperiod();
		String expectedperiod= getStrings().get("expectedperiode2b");
		String actualnoReffPeriod1 = ppobPage.getnoReffPeriod1();
		String expectednoReffPeriod1 = getStrings().get("expectednoReffPeriod1");
		String actualnoReffPeriod2 = ppobPage.getnoReffPeriod2();
		String expectednoReffPeriod2 = getStrings().get("expectednoReffPeriod2");
		String actualperiod1 = ppobPage.getperiod1();
		String expectedperiod1 = getStrings().get("expectedperiod1Jt");
		String actualperiod2 = ppobPage.getperiod2();
		String expectedperiod2 = getStrings().get("expectedperiod2Jt");
		String actualamount = ppobPage.getamount();
		String expectedamount = getStrings().get("expectedamount2bJt");
		String actualadminCost = ppobPage.getadminCost();
		String expectedadminCost = getStrings().get("expectedadminCost2bJt");
		String actualpaymentTotal = ppobPage.getpaymentTotal();
		String expectedpaymentTotal = getStrings().get("expectedpaymentTotal2bJt");
//		scrollToElement("textContains", "Konfirmasi", "scroll ke element : Tombol Konfirmasi");
		ppobPage.pressbtnConfirmppob();
		String expectedKet = getStrings().get("expected_keterangan");
		String actualKet = ppobPage.getcontentText();
		
		ppobPage.pressconfirmButton();
		String expectedLbl = getStrings().get("expected_lblnameJt");
		String actualLbl = ppobPage.getlblName();
		String expectedPrice = getStrings().get("expected_lblprice2bJt");
		String actualPrice = ppobPage.getlblPrice();
		String expectedQty = getStrings().get("expected_qty");
		String actualQty = ppobPage.getlblQty();
		ppobPage.pressbtnShowOrder();
		String expectedSubtotalppob = getStrings().get("expected_totalorder2bJt");
		String actualSubtotalppob = ppobPage.getlblPpob();
		String expectedQtyorder = getStrings().get("expected_qty");
		String actualQtyorder = ppobPage.getlblQuantity();
		ppobPage.pressbtnHideOrder();
		String expectedtotalOrder = getStrings().get("expected_totalorder2bJt");
		String actualtotalOrder = ppobPage.getbtnOrder();
		pembayaranPage = ppobPage.pressbtnOrder();
		String uangTunai = getStrings().get("expected_lbltunai2bJt");
		pembayaranPage = beliBarangcash(uangTunai);
		pembayaranPage.pressbtnPay();
		String expectedlblTitle = getStrings().get("expected_lbltitlebayar");
		String actuallblTitle = pembayaranPage.getlblTitle();
		String expectedlblTotal = getStrings().get("expected_lblprice2bJt");
		String actuallblTotal = pembayaranPage.getlblTotal();
		String expectedlblMethod = getStrings().get("expected_lblMethodbayar");
		String actuallblMethod = pembayaranPage.getlblMethod();
		String expectedlblPay = getStrings().get("expected_lblprice2bJt");
		String actuallblPay = pembayaranPage.getlblPay();
		String expectedlblChange = getStrings().get("expected_changebayar2bJt");
		String actuallblChange = pembayaranPage.getlblChange();
		ppobPage = pembayaranPage.pressbtnOkppob();
		sidebar = ppobPage.showSidebar();
		loginPage = logout();
		SoftAssert softassert= new SoftAssert();
		softassert.assertEquals(actualbranchCode, expectedbranchCode);
		softassert.assertEquals(actualdateTime, expecteddateTime);
		softassert.assertEquals(actualnoJasTel, expectednoJasTel);
		softassert.assertEquals(actualname, expectedname);
		softassert.assertEquals(actualtelephone, expectedtelephone);
		softassert.assertEquals(actualdivreDatel, expecteddivreDatel);
		softassert.assertEquals(actualperiod, expectedperiod);
		softassert.assertEquals(actualnoReffPeriod1, expectednoReffPeriod1);
		softassert.assertEquals(actualnoReffPeriod2, expectednoReffPeriod2);
		softassert.assertEquals(actualperiod1, expectedperiod1);
		softassert.assertEquals(actualperiod2, expectedperiod2);
		softassert.assertEquals(actualamount, expectedamount);
		softassert.assertEquals(actualadminCost, expectedadminCost);
		softassert.assertEquals(actualpaymentTotal, expectedpaymentTotal);
		softassert.assertEquals(actualKet, expectedKet);
		softassert.assertEquals(actualKet, expectedKet);
		softassert.assertEquals(actualLbl, expectedLbl);
		softassert.assertEquals(actualLbl, expectedLbl);
		softassert.assertEquals(actualQty, expectedQty);
		softassert.assertEquals(actualPrice, expectedPrice);
		softassert.assertEquals(actualSubtotalppob, expectedSubtotalppob);
		softassert.assertEquals(actualQtyorder, expectedQtyorder);
		softassert.assertEquals(actualtotalOrder, expectedtotalOrder);
		softassert.assertEquals(actuallblTitle, expectedlblTitle);
		softassert.assertEquals(actuallblTotal, expectedlblTotal);
		softassert.assertEquals(actuallblMethod, expectedlblMethod);
		softassert.assertEquals(actuallblPay, expectedlblPay);
		softassert.assertEquals(actuallblChange, expectedlblChange);
		softassert.assertAll();
		
	}

	@Test
	public void belijastel3bPpob() {
		String jastelnumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("jasTel3b");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliTelkomppob();
		ppobPage.inputtxtCustomerId(jastelnumber);
		ppobPage.pressprosesPpob();
		
		String actualbranchCode = ppobPage.getbranchCode();
		String expectedbranchCode = getStrings().get("expectedbranchCodeJt");
		String actualdateTime = ppobPage.getdateTime();
		String expecteddateTime = utils.getFormattedDateTimeV2();
		String actualnoJasTel = ppobPage.getnoJasTel();
		String expectednoJasTel = getStrings().get("expectednoJasTel3b");
		String actualname = ppobPage.getname();
		String expectedname = getStrings().get("expectednameJt");
		String actualtelephone = ppobPage.gettelephone();
		String expectedtelephone = getStrings().get("expectedtelephone3b");
		String actualdivreDatel = ppobPage.getdivreDatel();
		String expecteddivreDatel = getStrings().get("expecteddivreDatel");
		String actualperiod = ppobPage.getperiod();
		String expectedperiod= getStrings().get("expectedperiode3b");
		String actualnoReffPeriod1 = ppobPage.getnoReffPeriod1();
		String expectednoReffPeriod1 = getStrings().get("expectednoReffPeriod1");
		String actualnoReffPeriod2 = ppobPage.getnoReffPeriod2();
		String expectednoReffPeriod2 = getStrings().get("expectednoReffPeriod2");
		String actualnoReffPeriod3 = ppobPage.getnoReffPeriod3();
		String expectednoReffPeriod3 = getStrings().get("expectednoReffPeriod3");
		String actualperiod1 = ppobPage.getperiod1();
		String expectedperiod1 = getStrings().get("expectedperiod1Jt");
		String actualperiod2 = ppobPage.getperiod2();
		String expectedperiod2 = getStrings().get("expectedperiod2Jt");
		String actualperiod3 = ppobPage.getperiod3();
		String expectedperiod3 = getStrings().get("expectedperiod3Jt");
		String actualamount = ppobPage.getamount();
		String expectedamount = getStrings().get("expectedamount3bJt");
		String actualadminCost = ppobPage.getadminCost();
		String expectedadminCost = getStrings().get("expectedadminCost3bJt");
		String actualpaymentTotal = ppobPage.getpaymentTotal();
		String expectedpaymentTotal = getStrings().get("expectedpaymentTotal3bJt");

		ppobPage.pressbtnConfirmppob();
		String expectedKet = getStrings().get("expected_keterangan");
		String actualKet = ppobPage.getcontentText();
		
		ppobPage.pressconfirmButton();
		String expectedLbl = getStrings().get("expected_lblnameJt");
		String actualLbl = ppobPage.getlblName();
		String expectedPrice = getStrings().get("expected_lblprice3bJt");
		String actualPrice = ppobPage.getlblPrice();
		String expectedQty = getStrings().get("expected_qty");
		String actualQty = ppobPage.getlblQty();
		ppobPage.pressbtnShowOrder();
		String expectedSubtotalppob = getStrings().get("expected_totalorder3bJt");
		String actualSubtotalppob = ppobPage.getlblPpob();
		String expectedQtyorder = getStrings().get("expected_qty");
		String actualQtyorder = ppobPage.getlblQuantity();
		ppobPage.pressbtnHideOrder();
		String expectedtotalOrder = getStrings().get("expected_totalorder3bJt");
		String actualtotalOrder = ppobPage.getbtnOrder();
		pembayaranPage = ppobPage.pressbtnOrder();
		String uangTunai = getStrings().get("expected_lbltunai3bJt");
		pembayaranPage = beliBarangcash(uangTunai);
		pembayaranPage.pressbtnPay();
		String expectedlblTitle = getStrings().get("expected_lbltitlebayar");
		String actuallblTitle = pembayaranPage.getlblTitle();
		String expectedlblTotal = getStrings().get("expected_lblprice3bJt");
		String actuallblTotal = pembayaranPage.getlblTotal();
		String expectedlblMethod = getStrings().get("expected_lblMethodbayar");
		String actuallblMethod = pembayaranPage.getlblMethod();
		String expectedlblPay = getStrings().get("expected_lblprice3bJt");
		String actuallblPay = pembayaranPage.getlblPay();
		String expectedlblChange = getStrings().get("expected_changebayar3bJt");
		String actuallblChange = pembayaranPage.getlblChange();
		ppobPage = pembayaranPage.pressbtnOkppob();
		sidebar = ppobPage.showSidebar();
		loginPage = logout();
		SoftAssert softassert= new SoftAssert();
		softassert.assertEquals(actualbranchCode, expectedbranchCode);
		softassert.assertEquals(actualdateTime, expecteddateTime);
		softassert.assertEquals(actualnoJasTel, expectednoJasTel);
		softassert.assertEquals(actualname, expectedname);
		softassert.assertEquals(actualtelephone, expectedtelephone);
		softassert.assertEquals(actualdivreDatel, expecteddivreDatel);
		softassert.assertEquals(actualperiod, expectedperiod);
		softassert.assertEquals(actualnoReffPeriod1, expectednoReffPeriod1);
		softassert.assertEquals(actualnoReffPeriod2, expectednoReffPeriod2);
		softassert.assertEquals(actualnoReffPeriod3, expectednoReffPeriod3);
		softassert.assertEquals(actualperiod1, expectedperiod1);
		softassert.assertEquals(actualperiod2, expectedperiod2);
		softassert.assertEquals(actualperiod3, expectedperiod3);
		softassert.assertEquals(actualamount, expectedamount);
		softassert.assertEquals(actualadminCost, expectedadminCost);
		softassert.assertEquals(actualpaymentTotal, expectedpaymentTotal);
		softassert.assertEquals(actualKet, expectedKet);
		softassert.assertEquals(actualKet, expectedKet);
		softassert.assertEquals(actualLbl, expectedLbl);
		softassert.assertEquals(actualLbl, expectedLbl);
		softassert.assertEquals(actualQty, expectedQty);
		softassert.assertEquals(actualPrice, expectedPrice);
		softassert.assertEquals(actualSubtotalppob, expectedSubtotalppob);
		softassert.assertEquals(actualQtyorder, expectedQtyorder);
		softassert.assertEquals(actualtotalOrder, expectedtotalOrder);
		softassert.assertEquals(actuallblTitle, expectedlblTitle);
		softassert.assertEquals(actuallblTotal, expectedlblTotal);
		softassert.assertEquals(actuallblMethod, expectedlblMethod);
		softassert.assertEquals(actuallblPay, expectedlblPay);
		softassert.assertEquals(actuallblChange, expectedlblChange);
		softassert.assertAll();
		
	}
	
	//	@Test (priority = 4)
	public LoginPage logout() {
		//		sidebar = PenjualanPage.showSidebar();
		sidebar.pressLogoutBtn();
		loginPage = sidebar.pressConfirmLogoutBtn();
		return new LoginPage();

	}


}
