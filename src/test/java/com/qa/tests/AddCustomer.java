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
import org.testng.asserts.SoftAssert;

import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.pages.AddmemberPage;
import com.qa.pages.CustomerPage;
import com.qa.pages.PenjualanPage;
import com.qa.pages.IntroScreenPage;
import com.qa.pages.LoginPage;
import com.qa.pages.SettingPage;
import com.qa.pages.setting.PrinterPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddCustomer extends BaseTest{

	LoginPage loginPage;
	PenjualanPage PenjualanPage;
	SidebarPage sidebar;
	SettingPage settingPage;
	PrinterPage printerPage;
	CustomerPage customerPage;
	AddmemberPage addmemberPage;

	JSONObject dataTest;
	TestUtils utils = new TestUtils();


	public AddCustomer() {
		super();
	}

	@BeforeClass
	public void beforeClass() throws Exception {
		InputStream dataInStream = null;

		//dataTest
		dataInStream = null;
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

	@BeforeMethod(alwaysRun=true)
	public void beforeMethod(Method m) {
		utils.log().info("\n\n *******Starting test: "+ m.getName() + " *******\n");

		System.out.println("lagi jalanin before method");
		loginPage = new LoginPage();


		//		try {	
		//			loginPage = new LoginPage();
		//			loginPage.pressLanguageDropdown();
		//			//			loginPage.pressIndonesianLang().login(username, password);
		//
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//			System.out.println(e.getCause());
		//			System.out.println(e.getMessage());
		//		}



	}

	@AfterMethod
	public void afterMethod() {
		utils.log().info("Printer test after method");
		loginPage = printerPage.showSidebar().pressLogoutBtn().pressConfirmLogoutBtn();
	}

	//	public PenjualanPage validLogin() {
	//		loginPage.pressLanguageDropdown().pressIndonesianLang();
	//		String username = dataTest.getJSONObject("validUserPass").getString("username");
	//		String password = dataTest.getJSONObject("validUserPass").getString("password");
	//		
	//		return loginPage.login(username, password);
	//	}

	public LoginPage logout() {
		return printerPage.showSidebar().pressLogoutBtn().pressConfirmLogoutBtn();
	}

	public PenjualanPage loginWithValidUser() {

		//		loginPage = introPage.swipeToLogin();

		String username = dataTest.getJSONObject("validUserPass").getString("username");
		String password = dataTest.getJSONObject("validUserPass").getString("password");

		loginPage.enterUsername(username);
		loginPage.enterPassword(password);

		PenjualanPage = loginPage.pressLoginBtn();
		return PenjualanPage;

	}

	//test tambah member baru
	@Test
	public void addNewcustomer() {
		String id = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("newMember").getString("id");
		String tlp = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("newMember").getString("tlp");
		String email = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("newMember").getString("email");
		String idnumber = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("newMember").getString("idnumber");
		String birth = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("newMember").getString("birth");
		String address = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("newMember").getString("address");
		String name = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("newMember").getString("name");

		PenjualanPage = loginWithValidUser();
		customerPage = PenjualanPage.pressCustomerName();
		addmemberPage = customerPage.pressbtnAddmember();
		addmemberPage = addmemberPage.idMember(id);
		addmemberPage = addmemberPage.namaMember(name);
		addmemberPage = addmemberPage.tlpMember(tlp);
		addmemberPage = addmemberPage.emailMember(email);
		addmemberPage = addmemberPage.idnumberMember(idnumber);
		addmemberPage = addmemberPage.pressbtnPilihfemale();
		addmemberPage = addmemberPage.birthMember(birth);
		addmemberPage = addmemberPage.addressMember(address);
		scrollToElement("textContains", "BUAT MEMBER BARU", "scroll ke element : Buat Member Baru");
		addmemberPage = addmemberPage.pressbtnCreatenewcustomer();
		customerPage = addmemberPage.pressbtnConfirmcreatenewcustomer();
		PenjualanPage = customerPage.pressbtnClose();


		//		SoftAssert softAssert = new SoftAssert();
		//		softAssert.assertEquals(actualResult, expectResult);

		loginPage = logout();
		//		softAssert.assertAll();
		//		Assert.assertEquals(actualResult, expectResult);



	}

	//	test cancel add new customer
	//	@Test (priority = 3)
	public void canceladdNewcustomer() {

		//		loginPage = introPage.swipeToLogin();
		PenjualanPage = loginWithValidUser();
		customerPage = PenjualanPage.pressCustomerName();
		addmemberPage = customerPage.pressbtnAddmember();
		customerPage = addmemberPage.pressbtnBackcreatenewcustomer();
		customerPage.pressbtnClose();

		//		SoftAssert softAssert = new SoftAssert();
		//		softAssert.assertEquals(actualResult, expectResult);

		loginPage = logout();
		//		softAssert.assertAll();
		//		Assert.assertEquals(actualResult, expectResult);



	}

	//test cari customer
	@Test 
	public void masukcariCustomerall() {

		String byname = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("searchMember").getString("byname");
		String byphone = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("searchMember").getString("byphone");
		String byemail = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("searchMember").getString("byemail");
		String byid = dataTest.getJSONObject("BangAcilDataTest").getJSONObject("searchMember").getString("byid");

		PenjualanPage = loginWithValidUser();	

		customerPage = PenjualanPage.pressCustomerName();
		customerPage.pressCustomerImage();
		String actualnoResult = customerPage.getHasilnoresultText();
		String expectnoResult = getStrings().get("expected_true_noresult_searched");
		customerPage.pressconfirmnoresultAddmember();


		customerPage.pressbtnfilterAddmember();
		customerPage.pressbtnfilternameAddmember();
		customerPage.enterSearchmember(byname);
		customerPage.pressCustomerImage();
		String actualnameResult = customerPage.getHasilnameMemberText();
		String expectnameResult = getStrings().get("expected_true_customer_searched");

		customerPage.pressbtnfilterAddmember();
		customerPage.pressbtnfiltertlpAddmember();
		customerPage.enterSearchmember(byphone);
		customerPage.pressCustomerImage();
		String actualtlpResult = customerPage.getHasiltlpMemberText();
		String expecttlpResult = getStrings().get("expected_true_searchcustomerbytlp");

		customerPage.pressbtnfilterAddmember();
		customerPage.pressbtnfilterfreeidAddmember();
		customerPage.enterSearchmember(byid);
		customerPage.pressCustomerImage();
		String actualidResult = customerPage.getHasilfreeidMemberText();
		String expectidResult = getStrings().get("expected_true_searchcustomerbyid");

		customerPage.pressbtnfilterAddmember();
		customerPage.pressbtnfilteremailAddmember();
		customerPage.enterSearchmember(byemail);
		customerPage.pressCustomerImage();
		customerPage.pressbtnconfirmemailAddmember();


		//		Assert.assertEquals(actualResult, expectResult);

		customerPage.pressbtnClose();

		SoftAssert softAssertname = new SoftAssert();
		softAssertname.assertEquals(actualnameResult, expectnameResult);

		SoftAssert softAsserttlp = new SoftAssert();
		softAsserttlp.assertEquals(actualtlpResult, expecttlpResult);

		SoftAssert softAssertid = new SoftAssert();
		softAssertid.assertEquals(actualidResult, expectidResult);

		SoftAssert softAssertnoresult = new SoftAssert();
		softAssertnoresult.assertEquals(actualnoResult, expectnoResult);

		loginPage = logout();
		softAssertname.assertAll();
		softAsserttlp.assertAll();
		softAssertid.assertAll();
		softAssertnoresult.assertAll();

	}


}
