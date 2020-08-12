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
public class TvkabelppobTest extends BaseTest{

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

	public void prosestvkabelPpob(String a,String b,String c,String d,String e,String f,String g,String h,String i,String j,String l,String m,String n,String o) {

		String actualproductCode = ppobPage.getproductCode();
		String expectedproductCode = getStrings().get(a);
		String actualdateTime = ppobPage.getdateTime();
		String expecteddateTime = utils.getFormattedDateTimeV2();
		String actualtitleConfirmation = ppobPage.gettitleConfirmation();
		String expectedtitleConfirmation = getStrings().get(b);
		String actualcustomerId = ppobPage.getcustomerId();
		String expectedcustomerId = getStrings().get(c);
		String actualcustomerName = ppobPage.getcustomerName();
		String expectedcustomerName = getStrings().get(d);
		String expectedbill = getStrings().get(e);
		String actualbill = ppobPage.getbill();
		String expectedpenalty = getStrings().get(f);
		String actualpenalty = ppobPage.getpenalty();
		String actualperiod = ppobPage.getperiod();
		String expectedperiod= getStrings().get(g);
		String actualamount = ppobPage.getamount();
		String expectedamount = getStrings().get(h);
		String actualadminCost = ppobPage.getadminCost();
		String expectedadminCost = getStrings().get(i);
		String actualpaymentTotal = ppobPage.getpaymentTotal();
		String expectedpaymentTotal = getStrings().get(j);
//		String actualnoReff = ppobPage.getnoReff();
//		String expectednoReff = getStrings().get(k);
		
		ppobPage.pressbtnConfirmppob();
		String expectedKet = getStrings().get("expected_keterangan");
		String actualKet = ppobPage.getcontentText();
		
		ppobPage.pressconfirmButton();
		String expectedLbl = getStrings().get(l);
		String actualLbl = ppobPage.getlblName();
		String expectedPrice = getStrings().get(m);
		String actualPrice = ppobPage.getlblPrice();
		String expectedQty = getStrings().get("expected_qty");
		String actualQty = ppobPage.getlblQty();
		ppobPage.pressbtnShowOrder();
		String expectedSubtotalppob = getStrings().get(n);
		String actualSubtotalppob = ppobPage.getlblPpob();
		String expectedQtyorder = getStrings().get("expected_qty");
		String actualQtyorder = ppobPage.getlblQuantity();
		String expectedbtnOrder = getStrings().get(o);
		String actualbtnOrder = ppobPage.getbtnOrder();
		ppobPage.pressbtnHideOrder();
		pembayaranPage = ppobPage.pressbtnOrder();
		String uangTunai = getStrings().get(m);
		pembayaranPage = beliBarangcash(uangTunai);
		pembayaranPage.pressbtnPay();
		String expectedlblTitle = getStrings().get("expected_lbltitlebayar");
		String actuallblTitle = pembayaranPage.getlblTitle();
		String expectedlblTotal = getStrings().get(m);
		String actuallblTotal = pembayaranPage.getlblTotal();
		String expectedlblMethod = getStrings().get("expected_lblMethodbayar");
		String actuallblMethod = pembayaranPage.getlblMethod();
		String expectedlblPay = getStrings().get(m);
		String actuallblPay = pembayaranPage.getlblPay();
		String expectedlblChange = getStrings().get("expected_changebayar");
		String actuallblChange = pembayaranPage.getlblChange();
		ppobPage = pembayaranPage.pressbtnOkppob();
		sidebar = ppobPage.showSidebar();
		loginPage = logout();
		SoftAssert softassert= new SoftAssert();
		softassert.assertEquals(actualproductCode, expectedproductCode);
		softassert.assertEquals(actualdateTime, expecteddateTime);
		softassert.assertEquals(actualtitleConfirmation, expectedtitleConfirmation);
		softassert.assertEquals(actualcustomerId, expectedcustomerId);
		softassert.assertEquals(actualcustomerName, expectedcustomerName);
		softassert.assertEquals(actualbill, expectedbill);
		softassert.assertEquals(actualpenalty, expectedpenalty);
		softassert.assertEquals(actualperiod, expectedperiod);
		softassert.assertEquals(actualamount, expectedamount);
		softassert.assertEquals(actualadminCost, expectedadminCost);
		softassert.assertEquals(actualpaymentTotal, expectedpaymentTotal);
//		softassert.assertEquals(actualnoReff, expectednoReff);
		softassert.assertEquals(actualKet, expectedKet);
		softassert.assertEquals(actualKet, expectedKet);
		softassert.assertEquals(actualLbl, expectedLbl);
		softassert.assertEquals(actualLbl, expectedLbl);
		softassert.assertEquals(actualQty, expectedQty);
		softassert.assertEquals(actualPrice, expectedPrice);
		softassert.assertEquals(actualSubtotalppob, expectedSubtotalppob);
		softassert.assertEquals(actualQtyorder, expectedQtyorder);
		softassert.assertEquals(actualbtnOrder, expectedbtnOrder);
		softassert.assertEquals(actuallblTitle, expectedlblTitle);
		softassert.assertEquals(actuallblTotal, expectedlblTotal);
		softassert.assertEquals(actuallblMethod, expectedlblMethod);
		softassert.assertEquals(actuallblPay, expectedlblPay);
		softassert.assertEquals(actuallblChange, expectedlblChange);
		softassert.assertAll();
		

	}

	@Test
	public void belitvkabel1bPpob() {
		String tvkabelnumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("trxPpob").getString("tvkabel");
		PenjualanPage = loginValidUser();
		allmenuPage = PenjualanPage.pressbtnAllMenu();
		ppobPage = allmenuPage.pressbtnSwitchToPPOB();
		ppobPage.pressbeliPdamppob();
		ppobPage.inputcustomerId(tvkabelnumber);
		ppobPage.getpilihAreaPdam("expected_1areapam");
		ppobPage.pressprosesPpob();
		
		prosestvkabelPpob("expected_1productCodepam",
				"expected_1titleConfirmationpam", 
				"expected_customerIdpam",
				"expected_customerNamepam",
				"expected_billpam",
				"expected_penaltypam",
				"expected_periodpam",
				"expected_amountpam",
				"expected_adminCostpam", 
				"expected_paymentTotalpam", 
				"expected_1lblNamepam",
				"expected_lblPricepam",
				"expected_lblPpobpam",
				"expected_btnOrderpam");
	}
	
	
	//	@Test (priority = 4)
	public LoginPage logout() {
		//		sidebar = PenjualanPage.showSidebar();
		sidebar.pressLogoutBtn();
		loginPage = sidebar.pressConfirmLogoutBtn();
		return new LoginPage();

	}


}
