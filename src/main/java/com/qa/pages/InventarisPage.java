package com.qa.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InventarisPage extends BaseTest{

	public InventarisPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}
	
	@AndroidFindBy(xpath = "//*[@resource-id = \"id.dretail.mpos:id/id_text\" and @text=\"Pembelian\"]")
	private MobileElement pembelianinvMenu;
	@AndroidFindBy(xpath = "//*[@resource-id = \"id.dretail.mpos:id/id_text\" and @text=\"Penerima\")]")
	private MobileElement penerimainvMenu;
	@AndroidFindBy(xpath = "//*[@resource-id = \"id.dretail.mpos:id/id_text\" and @text=\"Stok Opname\")]")
	private MobileElement stokopnameinvMenu;
	@AndroidFindBy(xpath = "//*[@resource-id = \"id.dretail.mpos:id/id_text\" and @text=\"Sisa Harian\")]")
	private MobileElement sisaharianinvMenu;
	@AndroidFindBy(id = "id.dretail.mpos:id/lblTitle")
	private MobileElement lblTitle;	
	
	public SidebarPage showSidebar() {
		getDriver().manage().timeouts().implicitlyWait(TestUtils.WAITFORSWIPE, TimeUnit.SECONDS);
		swipingElement(null, "right", "sidebar page");

		return new SidebarPage();
	}

	public String getlblTitle() {
		return getText(lblTitle, "Judul Halaman : ");
	}
	
	public PembelianinventarisPage presspembelianinvMenu() {
		click(pembelianinvMenu, "Pilih Sub Menu Pembelian Inventaris");
		return new PembelianinventarisPage();
	}
	
	public PenerimainventarisPage presspenerimainvMenu() {
		click(penerimainvMenu, "Pilih Sub Menu Penerima Inventaris");
		return new PenerimainventarisPage();
	}
	
	public StokopnameinventarisPage pressstokopnameinvMenu() {
		click(stokopnameinvMenu, "Pilih Sub Menu Stok Opname Inventaris");
		return new StokopnameinventarisPage();
	}
	
	public SisaharianinventarisPage presssisaharianinvMenu() {
		click(sisaharianinvMenu, "Pilih Sub Menu Stok Opname Inventaris");
		return new SisaharianinventarisPage();
	}

}
