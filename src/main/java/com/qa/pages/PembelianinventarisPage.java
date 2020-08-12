package com.qa.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.pages.popup.PemasokPembelianInventory;
import com.qa.pages.popup.TambahPembelianInventory;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PembelianinventarisPage extends InventarisPage{

	public PembelianinventarisPage() {
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
	@AndroidFindBy(id = "id.dretail.mpos:id/title")
	private MobileElement title;
	@AndroidFindBy(id = "id.dretail.mpos:id/btnSupplier")
	private MobileElement btnSupplier;
	@AndroidFindBy(id = "id.dretail.mpos:id/etSearch")
	private MobileElement etSearch;
	@AndroidFindBy(id = "id.dretail.mpos:id/ivSearchImage")
	private MobileElement ivSearchImage;
	@AndroidFindBy(id = "id.dretail.mpos:id/name")
	private MobileElement name;
	@AndroidFindBy(id = "id.dretail.mpos:id/type")
	private MobileElement type;
	@AndroidFindBy(id = "id.dretail.mpos:id/unit")
	private MobileElement unit;
	@AndroidFindBy(id = "id.dretail.mpos:id/price")
	private MobileElement price;
	@AndroidFindBy(id = "id.dretail.mpos:id/btnMin")
	private MobileElement btnMin;
	@AndroidFindBy(id = "id.dretail.mpos:id/etQty")
	private MobileElement etQty;
	@AndroidFindBy(id = "id.dretail.mpos:id/btnPlus")
	private MobileElement btnPlus;
	@AndroidFindBy(id = "id.dretail.mpos:id/etSubtotal")
	private MobileElement etSubtotal;
	@AndroidFindBy(id = "id.dretail.mpos:id/ibDone")
	private MobileElement ibDone;

	public TambahPembelianInventory pressibDone() {
		click(ibDone, "Konfirmasi Tambah Jumlah Pembelian Item");
		return new TambahPembelianInventory();
	}
	
	public PembelianinventarisPage inputetSubtotal(String nom) {
		clear(etSubtotal);
		sendKeys(etSubtotal, nom, "Input Harga : "+nom);
		return this;
	}

	public PembelianinventarisPage pressbtnPlus() {
		click(btnPlus, "Tambah Jumlah Pembelian Item");
		return this;
	}
	
	public String getetQty() {
		return getText(etQty, "Jumlah Pembelian Inventaris : ");
	}
	
	public PembelianinventarisPage pressbtnMin() {
		click(btnMin, "Mengurangi Jumlah Pembelian Item");
		return this;
	}
	
	public String getprice() {
		return getText(price, "Harga Satuan Item : ");
	}

	public String getunit() {
		return getText(unit, "Satuan Ukuran Unit Item : ");
	}
	
	public String gettype() {
		return getText(type, "Tipe Item : ");
	}
	
	public String getname() {
		return getText(name, "Nama Item : ");
	}
	
	public PembelianinventarisPage pressivSearchImage() {
		click(ivSearchImage, "Proses Pencarian Item");
		return this;
	}
	
	public PembelianinventarisPage inputetSearch(String search) {
		clear(etSearch);
		sendKeys(etSearch, search, "Pencarian Item : "+search);
		return this;
	}

	public String getbtnSupplier() {
		return getText(btnSupplier, "Pilihan Supplier : ");
	}
	
	public PemasokPembelianInventory pressbtnSupplier() {
		click(btnSupplier, "Pilih Pemasok Sub Menu Pembelian Inventaris");
		return new PemasokPembelianInventory();
	}
	
	public SidebarPage showSidebar() {
		getDriver().manage().timeouts().implicitlyWait(TestUtils.WAITFORSWIPE, TimeUnit.SECONDS);
		swipingElement(null, "right", "sidebar page");

		return new SidebarPage();
	}
	
	public String gettitle() {
		return getText(title, "Judul Halaman : ");
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
