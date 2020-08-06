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
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[1]")
	private MobileElement printerSubmenu;
	
	public SettingPage masukprinterSubmenu() {
		click(printerSubmenu, "Masuk Menu Printer");
		return this;
	}
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[2]")
	private MobileElement secondDisplay;
	
	public SettingPage masuksecondDisplay() {
		click(secondDisplay, "Masuk Menu Second Display");
		return this;
	}
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[3]")
	private MobileElement pajakSubmenu;
	
	public SettingPage masukpajakSubmenu() {
		click(pajakSubmenu, "Masuk Menu Pajak");
		return this;
	}
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[4]")
	private MobileElement ubahpassSubmenu;
	
	public SettingPage masukubahpassSubmenu() {
		click(ubahpassSubmenu, "Masuk Menu Ubah Password");
		return this;
	}

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[5]")
	private MobileElement profilSubmenu;
	
	public SettingPage masukprofilSubmenu() {
		click(profilSubmenu, "Masuk Menu Profil");
		return this;
	}
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.TextView[6]")
	private MobileElement bahasaSubmenu;
	
	public SettingPage masukbahasaSubmenu() {
		click(bahasaSubmenu, "Masuk Menu Bahasa");
		return this;
	}
	
	@AndroidFindBy(id = "id.dretail.mpos:id/swStatus")
	private MobileElement swStatusprinter;
	
	public SettingPage swipeswStatusprinter() {
		click(swStatusprinter, "Swipe Status Printer");
		return this;
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/btnBar")
	private MobileElement btnBar;
	
	public SidebarPage pressbtnBar() {
		click(btnBar, "Masuk Menu Pengaturan");
		return new SidebarPage();
	}
	
	@AndroidFindBy(id = "id.dretail.mpos:id/swKitchenDisplay")
	private MobileElement swKitchenDisplay;
	
	public SettingPage swipeswKitchenDisplay() {
		click(swKitchenDisplay, "Swipe Kitchen Printer Display");
		return this;
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/swOrderPrint")
	private MobileElement swOrderPrint;
	
	public SettingPage swipeswOrderPrint() {
		click(swOrderPrint, "Swipe Order Printer");
		return this;
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/swTableOrderPrint")
	private MobileElement swTableOrderPrint;

	public SettingPage swipeswTableOrderPrint() {
		click(swTableOrderPrint, "Swipe Table Order Printer");
		return this;
	}
	
	@AndroidFindBy(id = "id.dretail.mpos:id/oldPassword")
	private MobileElement oldPassword;
	
	public SettingPage enteroldPassword(String txtoldPassword) {
		clear(oldPassword);
		sendKeys(oldPassword, txtoldPassword, "Enter Old Password : "+txtoldPassword);
		return this;
	}
	
	@AndroidFindBy(id = "id.dretail.mpos:id/newPassword")
	private MobileElement newPassword;
	
	public SettingPage enternewPassword(String txtnewPassword) {
		clear(newPassword);
		sendKeys(newPassword, txtnewPassword, "Enter New Password : "+txtnewPassword);
		return this;
	}
	
	@AndroidFindBy(id = "id.dretail.mpos:id/reTypeNewPassword")
	private MobileElement reTypeNewPassword;
	
	public SettingPage enterreTypeNewPassword(String txtreTypeNewPassword) {
		clear(reTypeNewPassword);
		sendKeys(reTypeNewPassword, txtreTypeNewPassword, "Retype New Password : "+txtreTypeNewPassword);
		return this;
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/btnCreateNewCustomer")
	private MobileElement btnCreateNewPassCustomer;
	
	public SettingPage pressbtnCreateNewPassCustomer() {
		click(btnCreateNewPassCustomer, "Create New Password");
		return this;
	}
	
	@AndroidFindBy(id = "id.dretail.mpos:id/confirm_button")
	private MobileElement confirmUbahpass;
	
	public SettingPage pressconfirmUbahpass() {
		click(confirmUbahpass, "Confirm Ubah Password");
		return this;
	}
	
	

}
