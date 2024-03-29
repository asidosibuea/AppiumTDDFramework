package com.qa.pages;

import java.time.Duration;

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
	
	@AndroidFindBy(id = "id.dretail.mpos:id/lblTitle")
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
	
	public String getPageTitle() {
		return getText(pageTitle, "Page title : ");
	}

}
