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
public class BpjsppobTest extends BaseTest{

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

	public void prosesbpjsksPpob(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String l) {

		String actualbranchCode = ppobPage.getbranchCode();
		String expectedbranchCode = getStrings().get(a);
		String actualdateTime = ppobPage.getdateTime();
		String expecteddateTime = utils.getFormattedDateTimeV2();
		String actualnoVa = ppobPage.getnoVa();
		String expectednoVa = getStrings().get(b);
		String actualname = ppobPage.getname();
		String expectedname = getStrings().get(c);
		String actualparticipant = ppobPage.getparticipant();
		String expectedparticipant = getStrings().get(d);
		String actualperiod = ppobPage.getperiod();
		String expectedperiod= getStrings().get(e);
		String actualamount = ppobPage.getamount();
		String expectedamount = getStrings().get(f);
		String actualadminCost = ppobPage.getadminCost();
		String expectedadminCost = getStrings().get(g);
		String actualpaymentTotal = ppobPage.getpaymentTotal();
		String expectedpaymentTotal = getStrings().get(h);
		
		ppobPage.pressbtnConfirmppob();
		String expectedKet = getStrings().get("expected_keterangan");
		String actualKet = ppobPage.getcontentText();
		
		ppobPage.pressconfirmButton();
		String expectedLbl = getStrings().get(i);
		String actualLbl = ppobPage.getlblName();
		String expectedPrice = getStrings().get(j);
		String actualPrice = ppobPage.getlblPrice();
		String expectedQty = getStrings().get("expected_qty");
		String actualQty = ppobPage.getlblQty();
		ppobPage.pressbtnShowOrder();
		String expectedSubtotalppob = getStrings().get(j);
		String actualSubtotalppob = ppobPage.getlblPpob();
		String expectedQtyorder = getStrings().get("expected_qty");
		String actualQtyorder = ppobPage.getlblQuantity();
		ppobPage.pressbtnHideOrder();
		pembayaranPage = ppobPage.pressbtnOrder();
		String uangTunai = getStrings().get(j);
		pembayaranPage = beliBarangcash(uangTunai);
		pembayaranPage.pressbtnPay();
		String expectedlblTitle = getStrings().get("expected_lbltitlebayar");
		String actuallblTitle = pembayaranPage.getlblTitle();
		String expectedlblTotal = getStrings().get(j);
		String actuallblTotal = pembayaranPage.getlblTotal();
		String expectedlblMethod = getStrings().get("expected_lblMethodbayar");
		String actuallblMethod = pembayaranPage.getlblMethod();
		String expectedlblPay = getStrings().get(j);
		String actuallblPay = pembayaranPage.getlblPay();
		String expectedlblChange = getStrings().get("expected_changebayar");
		String actuallblChange = pembayaranPage.getlblChange();
		ppobPage = pembayaranPage.pressbtnOkppob();
		sidebar = ppobPage.showSidebar();
		loginPage = logout();
		SoftAssert softassert= new SoftAssert();
		softassert.assertEquals(actualbranchCode, expectedbranchCode);
		softassert.assertEquals(actualdateTime, expecteddateTime);
		softassert.assertEquals(actualnoVa, expectednoVa);
		softassert.assertEquals(actualname, expectedname);
		softassert.assertEquals(actualparticipant, expectedparticipant);
		softassert.assertEquals(actualperiod, expectedperiod);
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
		softassert.assertEquals(actuallblTitle, expectedlblTitle);
		softassert.assertEquals(actuallblTotal, expectedlblTotal);
		softassert.assertEquals(actuallblMethod, expectedlblMethod);
		softassert.assertEquals(actuallblPay, expectedlblPay);
		softassert.assertEquals(actuallblChange, expectedlblChange);
		softassert.assertAll();
		

	}

	@Test
	public void belibpjs1bPpob() {
		String bpjsnumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("bpjsKesehatan");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliBpjsppob();
		ppobPage.inputtxtBpjsNumber(bpjsnumber);
		ppobPage.getpilihJumlahbayar("expected_1b");
		ppobPage.pressprosesPpob();
		
		prosesbpjsksPpob("expectedbranchCode",
				"expectednoVa", 
				"expectedname",
				"expectedparticipant",
				"expectedperiod1",
				"expectedamount1",
				"expectedadminCost",
				"expectedpaymentTotal1",
				"expected_lblnamebpjsk", 
				"expected_lblpricebpjsk1", 
				"bpjsk1");
	}
	
	@Test
	public void belibpjs2bPpob() {
		String bpjsnumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("bpjsKesehatan");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliBpjsppob();
		ppobPage.inputtxtBpjsNumber(bpjsnumber);
		ppobPage.getpilihJumlahbayar("expected_2b");
		ppobPage.pressprosesPpob();
		
		prosesbpjsksPpob("expectedbranchCode",
				"expectednoVa", 
				"expectedname",
				"expectedparticipant",
				"expectedperiod2",
				"expectedamount2",
				"expectedadminCost",
				"expectedpaymentTotal2",
				"expected_lblnamebpjsk", 
				"expected_lblpricebpjsk2",  
				"bpjsk2");
	}
	
	@Test
	public void belibpjs3bPpob() {
		String bpjsnumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("bpjsKesehatan");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliBpjsppob();
		ppobPage.inputtxtBpjsNumber(bpjsnumber);
		ppobPage.getpilihJumlahbayar("expected_3b");
		ppobPage.pressprosesPpob();
		
		prosesbpjsksPpob("expectedbranchCode",
				"expectednoVa", 
				"expectedname",
				"expectedparticipant",
				"expectedperiod3",
				"expectedamount3",
				"expectedadminCost",
				"expectedpaymentTotal3",
				"expected_lblnamebpjsk", 
				"expected_lblpricebpjsk3",  
				"bpjsk3");
	}
	
	@Test
	public void belibpjs4bPpob() {
		String bpjsnumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("bpjsKesehatan");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliBpjsppob();
		ppobPage.inputtxtBpjsNumber(bpjsnumber);
		ppobPage.getpilihJumlahbayar("expected_4b");
		ppobPage.pressprosesPpob();
		
		prosesbpjsksPpob("expectedbranchCode",
				"expectednoVa", 
				"expectedname",
				"expectedparticipant",
				"expectedperiod4",
				"expectedamount4",
				"expectedadminCost",
				"expectedpaymentTotal4",
				"expected_lblnamebpjsk", 
				"expected_lblpricebpjsk4",  
				"bpjsk4");
	}
	
	@Test
	public void belibpjs5bPpob() {
		String bpjsnumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("bpjsKesehatan");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliBpjsppob();
		ppobPage.inputtxtBpjsNumber(bpjsnumber);
		ppobPage.getpilihJumlahbayar("expected_5b");
		ppobPage.pressprosesPpob();
		
		prosesbpjsksPpob("expectedbranchCode",
				"expectednoVa", 
				"expectedname",
				"expectedparticipant",
				"expectedperiod5",
				"expectedamount5",
				"expectedadminCost",
				"expectedpaymentTotal5",
				"expected_lblnamebpjsk", 
				"expected_lblpricebpjsk5",  
				"bpjsk5");
	}
	
	@Test
	public void belibpjs6bPpob() {
		String bpjsnumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("bpjsKesehatan");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliBpjsppob();
		ppobPage.inputtxtBpjsNumber(bpjsnumber);
		ppobPage.getpilihJumlahbayar("expected_6b");
		ppobPage.pressprosesPpob();
		
		prosesbpjsksPpob("expectedbranchCode",
				"expectednoVa", 
				"expectedname",
				"expectedparticipant",
				"expectedperiod6",
				"expectedamount6",
				"expectedadminCost",
				"expectedpaymentTotal6",
				"expected_lblnamebpjsk", 
				"expected_lblpricebpjsk6",  
				"bpjsk6");
	}
	
	@Test
	public void belibpjs7bPpob() {
		String bpjsnumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("bpjsKesehatan");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliBpjsppob();
		ppobPage.inputtxtBpjsNumber(bpjsnumber);
		ppobPage.getpilihJumlahbayar("expected_7b");
		ppobPage.pressprosesPpob();
		
		prosesbpjsksPpob("expectedbranchCode",
				"expectednoVa", 
				"expectedname",
				"expectedparticipant",
				"expectedperiod7",
				"expectedamount7",
				"expectedadminCost",
				"expectedpaymentTotal7",
				"expected_lblnamebpjsk", 
				"expected_lblpricebpjsk7",  
				"bpjsk7");
	}
	
	@Test
	public void belibpjs8bPpob() {
		String bpjsnumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("bpjsKesehatan");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliBpjsppob();
		ppobPage.inputtxtBpjsNumber(bpjsnumber);
		ppobPage.getpilihJumlahbayar("expected_8b");
		ppobPage.pressprosesPpob();
		
		prosesbpjsksPpob("expectedbranchCode",
				"expectednoVa", 
				"expectedname",
				"expectedparticipant",
				"expectedperiod8",
				"expectedamount8",
				"expectedadminCost",
				"expectedpaymentTotal8",
				"expected_lblnamebpjsk", 
				"expected_lblpricebpjsk8",  
				"bpjsk8");
	}
	
	@Test
	public void belibpjs9bPpob() {
		String bpjsnumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("bpjsKesehatan");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliBpjsppob();
		ppobPage.inputtxtBpjsNumber(bpjsnumber);
		ppobPage.getpilihJumlahbayar("expected_9b");
		ppobPage.pressprosesPpob();
		
		prosesbpjsksPpob("expectedbranchCode",
				"expectednoVa", 
				"expectedname",
				"expectedparticipant",
				"expectedperiod9",
				"expectedamount9",
				"expectedadminCost",
				"expectedpaymentTotal9",
				"expected_lblnamebpjsk", 
				"expected_lblpricebpjsk9",  
				"bpjsk9");
	}
	
	@Test
	public void belibpjs10bPpob() {
		String bpjsnumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("bpjsKesehatan");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliBpjsppob();
		ppobPage.inputtxtBpjsNumber(bpjsnumber);
		ppobPage.getpilihJumlahbayar("expected_10b");
		ppobPage.pressprosesPpob();
		
		prosesbpjsksPpob("expectedbranchCode",
				"expectednoVa", 
				"expectedname",
				"expectedparticipant",
				"expectedperiod10",
				"expectedamount10",
				"expectedadminCost",
				"expectedpaymentTotal10",
				"expected_lblnamebpjsk", 
				"expected_lblpricebpjsk10",  
				"bpjsk10");
	}
	
	@Test
	public void belibpjs11bPpob() {
		String bpjsnumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("bpjsKesehatan");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliBpjsppob();
		ppobPage.inputtxtBpjsNumber(bpjsnumber);
		ppobPage.getpilihJumlahbayar("expected_11b");
		ppobPage.pressprosesPpob();
		
		prosesbpjsksPpob("expectedbranchCode",
				"expectednoVa", 
				"expectedname",
				"expectedparticipant",
				"expectedperiod11",
				"expectedamount11",
				"expectedadminCost",
				"expectedpaymentTotal11",
				"expected_lblnamebpjsk", 
				"expected_lblpricebpjsk11",  
				"bpjsk11");
	}
	
	@Test
	public void belibpjs12bPpob() {
		String bpjsnumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("bpjsKesehatan");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliBpjsppob();
		ppobPage.inputtxtBpjsNumber(bpjsnumber);
//		scrollToElement("resourceId", "id.dretail.mpos:id/btnConfirm", "Cari Btn Confirm");
		ppobPage.getpilihJumlahbayar("expected_12b");
		ppobPage.pressprosesPpob();
		
		prosesbpjsksPpob("expectedbranchCode",
				"expectednoVa", 
				"expectedname",
				"expectedparticipant",
				"expectedperiod12",
				"expectedamount12",
				"expectedadminCost",
				"expectedpaymentTotal12",
				"expected_lblnamebpjsk", 
				"expected_lblpricebpjsk12",  
				"bpjsk12");
	}
	
	//	@Test (priority = 4)
	public LoginPage logout() {
		//		sidebar = PenjualanPage.showSidebar();
		sidebar.pressLogoutBtn();
		loginPage = sidebar.pressConfirmLogoutBtn();
		return new LoginPage();

	}


}
