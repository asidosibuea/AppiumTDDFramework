package com.qa.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.pages.setting.BahasaPage;
import com.qa.pages.setting.PajakPage;
import com.qa.pages.setting.PrinterPage;
import com.qa.pages.setting.ProfilPage;
import com.qa.pages.setting.SecondDisplayPage;
import com.qa.pages.setting.UbahPasswordPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingPage extends BaseTest{
	
	@AndroidFindBy(xpath = "//*[@resource-id = \"id.dretail.mpos:id/lblTitle\" and @text=\"Pengaturan\"]")
	private MobileElement pageTitle;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"Printer\")]")
	private MobileElement printerMenu;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"Second Display\")]")
	private MobileElement secondDisplayMenu;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"Pajak\")]")
	private MobileElement pajakMenu;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"Ubah Password\")]")
	private MobileElement ubahPasswordMenu;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"Profil\")]")
	private MobileElement profilMenu;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"Bahasa\")]")
	private MobileElement bahasaMenu;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnSaveProfile")
	private MobileElement btnSaveProfile;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/row1")
	private MobileElement footerRow1;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/row2")
	private MobileElement footerRow2;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/confirm_button")
	private MobileElement confirmButton;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/content_text")
	private MobileElement contentText;
	
	public SettingPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}

	public PrinterPage pressPrinterMenu() {
		click(printerMenu, "Press printer menu");
		return new PrinterPage();
	}
	
	public SecondDisplayPage pressSecondDisplayMenu() {
		click(pajakMenu, "Press second display menu");
		return new SecondDisplayPage();
	}
	
	public PajakPage pressPajakPage() {
		click(pajakMenu, "Press pajak menu");
		return new PajakPage();
	}
	
	public UbahPasswordPage pressUbahPasswordMenu() {
		click(ubahPasswordMenu, "Press menu ubah password");
		return new UbahPasswordPage();
	}
	
	
	public ProfilPage pressProfilMenu() {
		click(profilMenu, "Press menu profil");
		return new ProfilPage();
	}
	
	public BahasaPage pressBahasaMenu() {
		click(bahasaMenu, "Press menu bahasa");
		return new BahasaPage();
	}
	
	public SidebarPage showSidebar() {
		swipingElement(pageTitle, "right", "on profil page");
		
		return new SidebarPage();
	}
	
	public SettingPage scrollToBtnSaveProfile() {
		scrollToElement("resourceId", "id.dretail.mpos:id/btnSaveProfile", "Searching Element...");
		return this;
	}

	public SettingPage enterRow1(String row1) {
		clear(footerRow1);
		sendKeys(footerRow1, row1, "Enter Footer Row1: "+row1);
		return this;
	}
	
	public SettingPage enterRow2(String row2) {
		clear(footerRow2);
		sendKeys(footerRow2, row2, "Enter Footer Row1: "+row2);
		return this;
	}
	
	public BahasaPage pressBtnSaveProfile() {
		click(btnSaveProfile, "Press button SIMPAN FOOTER");
		return new BahasaPage();
	}
	
	public BahasaPage pressConfirmButton() {
		click(confirmButton, "Press button Confirm");
		return new BahasaPage();
	}
	
	public String getContentText() {
		return getText(contentText, "Status perubahan footer adalah: ");
	}
	
}
