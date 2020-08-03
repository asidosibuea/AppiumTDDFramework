package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends BaseTest{

	//test2
	TestUtils utils = new TestUtils();
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtUsername")
	private MobileElement usernameTxtFld;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtPassword")
	private MobileElement passwordTxtFld;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnLogin")
	private MobileElement loginBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/content_text")
	private MobileElement errorMessage;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/confirm_button")
	private MobileElement confirmErrorBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnLang")
	private MobileElement languageDropdown;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"Indonesia\")]")
	private MobileElement indonesianLang;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"English\")]")
	private MobileElement englishLang;
	
	
	public LoginPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}
	
	public LoginPage enterUsername(String username) {
		clear(usernameTxtFld);
		sendKeys(usernameTxtFld, username, "Enter username : "+username);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		clear(passwordTxtFld);
		sendKeys(passwordTxtFld, password, "Enter password : "+password);
		return this;
	}
	
	public PenjualanPage pressLoginBtn() {
		click(loginBtn, "Press Login Button");
		
		return new PenjualanPage();
	}
	
	public PenjualanPage login(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		pressLoginBtn();
		return new PenjualanPage();
	}
	
	public String getErroMessage() {
		return getText(errorMessage, "Error text is : ");
	}
	
	public LoginPage pressConfirmErrorBtn() {
		click(confirmErrorBtn, "Press OK on popup failed login.");
		return this;
	}
	
	public LoginPage pressLanguageDropdown() {
		click(languageDropdown, "Press Select Language");
		return this;
	}
	
	public LoginPage pressIndonesianLang() {
		click(indonesianLang, "Select Bahasa Indonesia");
		return this;
	}
	
	public LoginPage pressEnglishLang() {
		click(englishLang, "Select English Language");
		return this;
	}
	
	

}
