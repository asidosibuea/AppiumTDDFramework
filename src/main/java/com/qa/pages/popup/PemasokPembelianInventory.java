package com.qa.pages.popup;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.pages.PembelianinventarisPage;
import com.qa.pages.PpobPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PemasokPembelianInventory extends PembelianinventarisPage{

	public PemasokPembelianInventory() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}
	
	@AndroidFindBy(id = "id.dretail.mpos:id/lbl")
	private MobileElement lbl;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/searchItem")
	private MobileElement searchItem;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/searchImage")
	private MobileElement searchImage;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnClose")
	private MobileElement btnClose;

	@AndroidFindBy(xpath = "//*[@resource-id = \"id.dretail.mpos:id/tvSupplier\" and @text=\"JAYA LOGISTIK\"]")
	private MobileElement jayaLogistiksupplier;
	
	@AndroidFindBy(xpath = "//*[@resource-id = \"id.dretail.mpos:id/tvSupplier\" and @text=\"SENTRA SUPPLIER\"]")
	private MobileElement sentraSupplier;
	
	public PembelianinventarisPage presssentraSupplier() {
		click(sentraSupplier, "Pilih Supplier Sentra Supplier");
		return new PembelianinventarisPage();
	}

	public PembelianinventarisPage pressjayaLogistiksupplier() {
		click(jayaLogistiksupplier, "Pilih Supplier Jaya Logistik");
		return new PembelianinventarisPage();
	}
	
	public PembelianinventarisPage pressbtnClose() {
		click(btnClose, "Tutup Halaman Pemasok Pembelian Inventory");
		return new PembelianinventarisPage();
	}
	
	public PemasokPembelianInventory presssearchImage() {
		click(searchImage, "Proses Pencarian");
		return this;
	}
	
	public PemasokPembelianInventory inputsearchItem(String search) {
		clear(searchItem);
		sendKeys(searchItem, search, "Pencarian Pemasok : "+search);
		return this;
	}
	
	public String getlbl() {
		return getText(lbl, "Judul Halaman : ");
	}

}
