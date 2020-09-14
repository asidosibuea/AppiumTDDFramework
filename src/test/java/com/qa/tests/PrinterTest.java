package com.qa.tests;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.time.Duration;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.pages.PenjualanPage;
import com.qa.pages.IntroScreenPage;
import com.qa.pages.LoginPage;
import com.qa.pages.SettingPage;
import com.qa.pages.setting.PrinterPage;
import com.qa.pages.setting.ProfilPage;
import com.qa.pages.setting.printer.AddPrinterPage;
import com.qa.pages.setting.printer.BluetoothDeviceListPage;
import com.qa.pages.setting.printer.JenisKoneksiPrinter;
import com.qa.pages.setting.printer.OpsiPaperPage;
import com.qa.pages.setting.printer.OpsiPortPrinterPage;
import com.qa.reports.ExtentReport;
import com.qa.pages.setting.printer.OpsiDriverPrinterPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PrinterTest extends BaseTest{
	
	LoginPage loginPage;
	PenjualanPage penjualanPage;
	SidebarPage sidebar;
	SettingPage settingPage;
	PrinterPage settingPrinterPage;
	OpsiDriverPrinterPage opsiDriverPage;
	OpsiPaperPage opsiPaperPage;
	JenisKoneksiPrinter jenisKoneksiPrinterPage;
	OpsiPortPrinterPage opsiPortPage;
	BluetoothDeviceListPage btListPage;
	AddPrinterPage addStasiunPrinterPage;
	
	JSONObject dataTest;
	TestUtils utils = new TestUtils();
	

	public PrinterTest() {
		super();
	}

	@BeforeClass
	public void beforeClass() throws Exception {
		dataTest = utils.getDataTest();
	}

	@AfterClass
	public void afterClass() {
	}
	
	@BeforeMethod
	public void beforeMethod(Method m) {		
		launchApp();
		utils.log().info("\n\n *******Starting test: "+ m.getName() + " *******\n");	
		loginPage = new LoginPage();
	}

	@AfterMethod
	public void afterMethod() {
		utils.log().info("--- After test method ----");
		closeApp();
	}
	
	public PenjualanPage validLogin() {
		loginPage.pressLanguageDropdown().pressIndonesianLang();
		String username = dataTest.getJSONObject("validUserPass").getString("username");
		String password = dataTest.getJSONObject("validUserPass").getString("password");
		
		return loginPage.login(username, password);
	}
	
	public LoginPage logout() {
		return settingPrinterPage.showSidebar().pressLogoutBtn().pressConfirmLogoutBtn();
	}
	
	
	@Test
	public void nyalakanPrinter() {
		penjualanPage = validLogin();
		settingPrinterPage = penjualanPage.showSidebar().pressPengaturanMenu().pressPrinterMenu();
		settingPrinterPage.switchOnStatusPrinter();
		
		String actualStatusPrinter = settingPrinterPage.getStatusPrinter();
		String expectedStatusPrinter = getStrings().get("expected_turnon_printer");
		Assert.assertEquals(actualStatusPrinter, expectedStatusPrinter);
		loginPage = logout();
		
	}
	
	@Test
	public void matikanPrinter() {
		penjualanPage = validLogin();
		settingPrinterPage = penjualanPage.showSidebar().pressPengaturanMenu().pressPrinterMenu();
		settingPrinterPage.switchOffStatusPrinter();
		
		String actualStatusPrinter = settingPrinterPage.getStatusPrinter();
		String expectedStatusPrinter = getStrings().get("expected_turnoff_printer");
		Assert.assertEquals(actualStatusPrinter, expectedStatusPrinter);
		loginPage = logout();
	}
	
	@Test
	public void setMainPrinterBluetooth() {
		penjualanPage = validLogin();
		settingPrinterPage = penjualanPage.showSidebar().pressPengaturanMenu().pressPrinterMenu();
		
		boolean changePrinterFlag = settingPrinterPage.isChangePrinterVisible();
		
		if(!changePrinterFlag) {
			opsiDriverPage = settingPrinterPage.switchOnStatusPrinter().pressPilihPrinterBtn();
		} else {
			opsiDriverPage = settingPrinterPage.switchOnStatusPrinter().pressChangePrinterBtn();
		}

		opsiPaperPage = opsiDriverPage.pilihRongtaPrinter();
		
		jenisKoneksiPrinterPage = opsiPaperPage.pilihJenisKertas(dataTest.getString("paperSize48"));
		opsiPortPage = jenisKoneksiPrinterPage.pressJenisKoneksiBtn();
		
		btListPage = opsiPortPage.pressRadioBluetooth();
		
		String btDeviceId = dataTest.getString("bluetoothId");
		
		opsiPortPage = btListPage.pilihBluetoothDevice(btDeviceId);
		jenisKoneksiPrinterPage = opsiPortPage.pressOkBtn();
		
		settingPrinterPage = jenisKoneksiPrinterPage.pressConnectBtn();
		settingPrinterPage.pressTestPrinter();
		
		String actualPrintResult = settingPrinterPage.getPopupMsg().trim();
		String expectedPrintResult = getStrings().get("expected_success_print");
		Assert.assertEquals(actualPrintResult, expectedPrintResult);
		
		settingPrinterPage.pressPopupConfirm();
		
		loginPage = logout();
	}
	
	@Test
	public void setMainPrinterLAN() {
		penjualanPage = validLogin();
		settingPrinterPage = penjualanPage.showSidebar().pressPengaturanMenu().pressPrinterMenu();
		boolean changePrinterFlag = settingPrinterPage.isChangePrinterVisible();
		
		if(!changePrinterFlag) {
			opsiDriverPage = settingPrinterPage.switchOnStatusPrinter().pressPilihPrinterBtn();
		} else {
			opsiDriverPage = settingPrinterPage.switchOnStatusPrinter().pressChangePrinterBtn();
		}
		
		opsiPaperPage = opsiDriverPage.pilihRongtaPrinter();
		
		jenisKoneksiPrinterPage = opsiPaperPage.pilihJenisKertas(dataTest.getString("paperSize48"));
		opsiPortPage = jenisKoneksiPrinterPage.pressJenisKoneksiBtn();
		
		opsiPortPage.pressRadioEthernet();
		
		String ipPrinter = dataTest.getString("ipPrinter");
		
		opsiPortPage.enterIpAddress(ipPrinter);
		jenisKoneksiPrinterPage = opsiPortPage.pressOkBtn();
		
		settingPrinterPage = jenisKoneksiPrinterPage.pressConnectBtn();
		settingPrinterPage.pressTestPrinter();
		
		String actualPrintResult = settingPrinterPage.getPopupMsg().trim();
		String expectedPrintResult = getStrings().get("expected_success_print");
		Assert.assertEquals(actualPrintResult, expectedPrintResult);
		
		settingPrinterPage.pressPopupConfirm();
		
		loginPage = logout();
	}
	
	@Test
	public void addStasiunPrinter() {
		penjualanPage = validLogin();
		settingPrinterPage = penjualanPage.showSidebar().pressPengaturanMenu().pressPrinterMenu();
		settingPrinterPage.switchOnStatusPrinter();
		
		boolean isVisibleFoodStasiun = settingPrinterPage.isKitchenStasiunVisible();
		
		if (!isVisibleFoodStasiun) {
			addStasiunPrinterPage = settingPrinterPage.pressAddPrinterBtn();
			addStasiunPrinterPage.enterNamaStasiun(dataTest.getString("namaStasiun1"));
			addStasiunPrinterPage.switchOnKategori(dataTest.getString("namaKategori1"), TestUtils.ON);
			opsiDriverPage = addStasiunPrinterPage.pressSelectPrinterBtn();
			opsiPaperPage = opsiDriverPage.pilihRongtaPrinter();
			jenisKoneksiPrinterPage = opsiPaperPage.pilihJenisKertas(dataTest.getString("paperSize48"));
			opsiPortPage = jenisKoneksiPrinterPage.pressJenisKoneksiBtn();
			opsiPortPage.pressRadioEthernet();
			String ipPrinter = dataTest.getString("ipStasiunPrinter1");
			opsiPortPage.enterIpAddress(ipPrinter);
			jenisKoneksiPrinterPage = opsiPortPage.pressOkBtn();
			addStasiunPrinterPage = jenisKoneksiPrinterPage.pressConnectBtnByStasiun();
			settingPrinterPage = addStasiunPrinterPage.pressOkBtn();
			
			settingPrinterPage.pressTestPrintStasiun(dataTest.getString("namaStasiun1"));

			String actualPrintResult = settingPrinterPage.getPopupMsg().trim();
			String expectedPrintResult = getStrings().get("expected_success_print");
			Assert.assertEquals(actualPrintResult, expectedPrintResult);
			
			settingPrinterPage.pressPopupConfirm();
		} else {
			utils.log().info("Printer food sudah ada tidak perlu menambah lagi");
			ExtentReport.getTest().log(Status.INFO, "Printer food sudah ada tidak perlu menambah lagi");
		}
		
		loginPage = logout();

	}
	
	@Test
	public void hapusStasiunPrinter() {
		penjualanPage = validLogin();
		settingPrinterPage = penjualanPage.showSidebar().pressPengaturanMenu().pressPrinterMenu();
		settingPrinterPage.switchOnStatusPrinter();
		
		boolean isVisibleFoodStasiun = settingPrinterPage.isKitchenStasiunVisible();
		
		if (isVisibleFoodStasiun) {
			settingPrinterPage.pressFoodStasiunLbl().pressHapusPrinterBtn();
			settingPrinterPage.pressConfirmHapusPrinter();
			settingPrinterPage.pressPopupConfirm();
			
			boolean isVisible = false;
			boolean actualisVisible = settingPrinterPage.isKitchenStasiunVisible();
			
			Assert.assertEquals(actualisVisible, isVisible);
			
			
		}
	}


}
