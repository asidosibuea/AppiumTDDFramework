package com.qa.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.pages.AllmenuPage;
import com.qa.pages.PenjualanPage;
import com.qa.pages.IntroScreenPage;
import com.qa.pages.InventarisPage;
import com.qa.pages.LoginPage;
import com.qa.pages.PembayaranPage;
import com.qa.pages.PembelianinventarisPage;
import com.qa.pages.PpobPage;
import com.qa.pages.popup.PemasokPembelianInventory;
import com.qa.pages.popup.TambahPembelianInventory;
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
public class InventoryTest extends BaseTest{

	IntroScreenPage introPage;
	LoginPage loginPage;
	PenjualanPage PenjualanPage;
	SidebarPage sidebar;
	AllmenuPage allmenuPage;
	PpobPage ppobPage;
	PembayaranPage pembayaranPage;
	InventarisPage inventoryPage;
	PembelianinventarisPage pembelianinventarisPage;
	PemasokPembelianInventory pemasokpembelianInventory;
	TambahPembelianInventory tambahpembelianInventory;

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

	

	@Test
	public void beliInventory() {
		String cariItem = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("inventaris").getString("cariItem");
		String cariItem2 = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("inventaris").getString("cariItem2");
		String nominal = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("inventaris").getString("nomItem");
		
		PenjualanPage = loginValidUser();
		sidebar = PenjualanPage.showSidebar();
		inventoryPage = sidebar.pressInventarisMenu();
		pembelianinventarisPage = inventoryPage.presspembelianinvMenu();
		pemasokpembelianInventory = pembelianinventarisPage.pressbtnSupplier();
		pembelianinventarisPage = pemasokpembelianInventory.pressjayaLogistiksupplier();
		pembelianinventarisPage.inputetSearch(cariItem);
		pembelianinventarisPage.inputetSubtotal(nominal);
		pembelianinventarisPage.pressbtnPlus();
		pembelianinventarisPage.pressbtnPlus();
		pembelianinventarisPage.pressbtnPlus();
		pembelianinventarisPage.pressbtnMin();
		pembelianinventarisPage.pressbtnMin();
		tambahpembelianInventory = pembelianinventarisPage.pressibDone();
		pembelianinventarisPage = tambahpembelianInventory.pressbtnClose(); 
		pemasokpembelianInventory = pembelianinventarisPage.pressbtnSupplier();
		pembelianinventarisPage = pemasokpembelianInventory.presssentraSupplier();
		pembelianinventarisPage.inputetSearch(cariItem2);
		pembelianinventarisPage.inputetSubtotal(nominal);
		pembelianinventarisPage.pressbtnPlus();
		pembelianinventarisPage.pressbtnPlus();
		pembelianinventarisPage.pressbtnPlus();
		pembelianinventarisPage.pressbtnMin();
		pembelianinventarisPage.pressbtnMin();
		tambahpembelianInventory = pembelianinventarisPage.pressibDone();
		tambahpembelianInventory.pressbtnConfirm();
		pembelianinventarisPage = tambahpembelianInventory.pressconfirm_button();
		sidebar = pembelianinventarisPage.showSidebar();
		logout();
	}
	
	
	//	@Test (priority = 4)
	public LoginPage logout() {
		//		sidebar = PenjualanPage.showSidebar();
		sidebar.pressLogoutBtn();
		loginPage = sidebar.pressConfirmLogoutBtn();
		return new LoginPage();

	}


}
