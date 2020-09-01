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
import com.qa.pages.MultiPaymentPage;
import com.qa.pages.PembayaranPage;
import com.qa.pages.PenjualanPage;
import com.qa.pages.TambahPembayaranPage;
import com.qa.pages.popup.PopupBiayaKirim;
import com.qa.pages.popup.PopupItem;
import com.qa.pages.popup.PopupJlhUangTunai;
import com.qa.pages.popup.PopupNotifikasiPembayaran;
import com.qa.pages.popup.PopupStatusOrder;
import com.qa.pages.popup.PopupTopping;
import com.qa.utils.TestUtils;

public class SplitPaymentTest extends BaseTest{
	IntroScreenPage introPage;
	LoginPage loginPage;
	PenjualanPage penjualanPage;
	SidebarPage sidebar;
	PopupItem itemPopUp;
	PopupTopping popupTopping;
	PopupStatusOrder popupStatusOrder;
	PopupBiayaKirim popupBiayaKirim;
	PembayaranPage pembayaranPage;
	PopupNotifikasiPembayaran popupNotifikasiPembayaran;
	MultiPaymentPage multiPaymentPage;
	PopupJlhUangTunai popupJlhUangTunai;
	TambahPembayaranPage tambahPembayaranPage;
	
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
	public void splitPayment() {
		penjualanPage.pilihKategori1();
		penjualanPage.TambahKeranjang1();
		pembayaranPage = penjualanPage.pressBtnOrder();
		multiPaymentPage = pembayaranPage.pressBtnMultiPay();
		tambahPembayaranPage = multiPaymentPage.pressBtnAddPayment();
		popupJlhUangTunai = tambahPembayaranPage.pressTxtCashAmount();
		popupJlhUangTunai.PressBtn1();
		popupJlhUangTunai.PressBtn0();
		popupJlhUangTunai.PressBtnThousand();
		tambahPembayaranPage = popupJlhUangTunai.PressBtnOk2();
		multiPaymentPage = tambahPembayaranPage.pressBtnAdd();
		
		String expectedPayment1 = getStrings().get("multi_payment1");
		String actualPayment1 = multiPaymentPage.getMultiPayment1();
		
		Assert.assertEquals(actualPayment1, expectedPayment1);
		
		tambahPembayaranPage = multiPaymentPage.pressBtnAddPayment();
		tambahPembayaranPage.scrollToAccountNo();
		popupJlhUangTunai = tambahPembayaranPage.pressTxtEdcAmount();
		popupJlhUangTunai.PressBtn3();
		popupJlhUangTunai.PressBtn8();
		popupJlhUangTunai.PressBtn0();
		popupJlhUangTunai.PressBtn3();
		tambahPembayaranPage = popupJlhUangTunai.PressBtnOk2();
		tambahPembayaranPage.enterNomorKartu(getStrings().get("rek_number"));
		tambahPembayaranPage.scrollToApprovalCode();
		tambahPembayaranPage.enterNamaBank(getStrings().get("bank_name"));
		tambahPembayaranPage.enterApprovalCode(getStrings().get("approval_code"));
		multiPaymentPage = tambahPembayaranPage.pressBtnAdd();
		
		String expectedPayment2 = getStrings().get("multi_payment2");
		String actualPayment2 = multiPaymentPage.getMultiPayment2();
		
		Assert.assertEquals(actualPayment2, expectedPayment2);
		
		multiPaymentPage.enterCustomerName(getStrings().get("customer_name"));
		popupNotifikasiPembayaran = multiPaymentPage.pressBtnPay();
		
		String expectedPaymentStatus = getStrings().get("status_pembayaran_sukses");
		String actualPaymentStatus = popupNotifikasiPembayaran.getStatusPembayaran();
		
		Assert.assertEquals(actualPaymentStatus, expectedPaymentStatus);
		
		String expectedPaymentMethod = getStrings().get("pembayaran_multi");
		String actualPaymentMethod = popupNotifikasiPembayaran.getStatusMethod();
		
		Assert.assertEquals(actualPaymentMethod, expectedPaymentMethod);
		
		popupNotifikasiPembayaran.PressBtnOk();
		}
	
	@Test(priority = 3)
	public void logout() {
		sidebar = penjualanPage.showSidebar();
		sidebar.pressLogoutBtn();
		loginPage = sidebar.pressConfirmLogoutBtn();
		
	}

}
