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
import com.qa.pages.PenjualanPage;
import com.qa.pages.IntroScreenPage;
import com.qa.pages.LoginPage;
import com.qa.pages.PembayaranPage;
import com.qa.pages.popup.PopupItem;
import com.qa.pages.popup.PopupJlhUangTunai;
import com.qa.pages.popup.PopupNotifikasiPembayaran;
import com.qa.pages.popup.PopupTopping;
import com.qa.utils.TestUtils;

public class MelakukanPembelianDanPembayaranTest extends BaseTest {

	IntroScreenPage introPage;
	LoginPage loginPage;
	PenjualanPage penjualanPage;
	SidebarPage sidebar;
	PopupItem itemPopUp;
	PembayaranPage pembayaranPage;
	PopupJlhUangTunai popupJlhUangTunai;
	PopupNotifikasiPembayaran popupNotifikasiPembayaran;
	
	
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
	public void tambahJumlahPembelian() {
		penjualanPage.pilihKategori1();
		penjualanPage.TambahKeranjang1();
		pembayaranPage = penjualanPage.pressBtnOrder();
		popupJlhUangTunai = pembayaranPage.enterCash();
		popupJlhUangTunai.PressBtn1();
		popupJlhUangTunai.PressBtn5();
		popupJlhUangTunai.PressBtnThousand();
		pembayaranPage = popupJlhUangTunai.PressBtnOk();
		popupNotifikasiPembayaran = pembayaranPage.pressBtnPay();
		
		String expectedStatus = getStrings().get("status_pembayaran_sukses");
		String actualStatus = popupNotifikasiPembayaran.getStatusPembayaran();
		
		Assert.assertEquals(actualStatus, expectedStatus);
		
		penjualanPage = popupNotifikasiPembayaran.PressBtnOk();
	}
	
	@Test(priority = 3)
	public void logout() {
		sidebar = penjualanPage.showSidebar();
		sidebar.pressLogoutBtn();
		loginPage = sidebar.pressConfirmLogoutBtn();
		
	}
	
}
