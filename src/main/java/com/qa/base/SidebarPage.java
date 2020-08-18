package com.qa.base;
import com.qa.pages.AbsensiPage;
import com.qa.pages.AktifitasPage;
import com.qa.pages.InventarisPage;
import com.qa.pages.LoginPage;
import com.qa.pages.SettingPage;
import com.qa.pages.RiwayatPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SidebarPage extends BaseTest{
	TestUtils utils = new TestUtils();
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btn_logout")
	private MobileElement logoutBtn;
	
	@AndroidFindBy(id =  "id.dretail.mpos:id/confirm_button")
	private MobileElement confirmLogoutBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/cancel_button")
	private MobileElement cancelLogoutBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/lblCashierName")
	private MobileElement cashierNameLabel;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"Penjualan\")]")
	private MobileElement penjualanMenu;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"Aktifitas\")]")
	private MobileElement aktifitasMenu;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"Inventaris\")]")
	private MobileElement inventarisMenu;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"Riwayat\")]")
	private MobileElement riwayatMenu;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"Absensi\")]")
	private MobileElement absensiMenu;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"Pengaturan\")]")
	private MobileElement pengaturanMenu;
	
	public SidebarPage pressLogoutBtn() {
		click(logoutBtn, "Press logout button");
		return this;
	}
	
	public LoginPage pressConfirmLogoutBtn() {
		click(confirmLogoutBtn, "Press confirm logout button");
		
		return new LoginPage();
	}
	
	public String getCashierName() {
		return getText(cashierNameLabel, "Cashier name is : ");
	}
	
	public Object hideSideBar(Object obj) {
		swipingElement(null, "left", "on dashboard page");
		
		return obj;
	}
	
	public AktifitasPage pressAktifitasMenu() {
		click(aktifitasMenu, "Pilih menu aktifitas on sidebar");
		return new AktifitasPage();
	}
	
	public InventarisPage pressInventarisMenu() {
		click(inventarisMenu, "Pilih menu inventaris on sidebar");
		
		return new InventarisPage();
	}
	
	public RiwayatPage pressRiwayatMenu() {
		click(riwayatMenu, "Pilih menu riwayat on sidebar");
		
		return new RiwayatPage();
	}
	
	public AbsensiPage pressAbsensiMenu() {
		click(absensiMenu, "Pilih menu absensi on sidebar");
		return new AbsensiPage();
	}
	
	public SettingPage pressPengaturanMenu() {
		click(pengaturanMenu, "Pilih menu pengaturan on sidebar");
		
		return new SettingPage();
	}
	
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btn_logout")
	private MobileElement btnLogout;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/confirm_button")
	private MobileElement confirmButton;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/cancel_button")
	private MobileElement cancelButton;
	
	
	
	public SidebarPage pressBtnLogout() {
		click(btnLogout, "Press Logout");
		return this;
	}
	
	public LoginPage pressConfirmButton() {
		click(confirmButton, "Press Confirm Logout");
		return new LoginPage();
	}
	
	public SidebarPage pressCancelButton() {
		click(cancelButton, "Press Confirm Logout");
		return this;
	}
	
	public AktifitasPage pressaktifitasMenu() {
		click(aktifitasMenu, "Pilih Menu Aktivasi");
		return new AktifitasPage();
	}
	
	public SettingPage presspengaturanPage() {
		click(pengaturanMenu, "Pilih Menu Pengaturan");
		return new SettingPage();
	}

}
