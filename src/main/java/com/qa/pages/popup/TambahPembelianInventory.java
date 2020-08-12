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

public class TambahPembelianInventory extends PembelianinventarisPage{

	public TambahPembelianInventory() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}
	
	@AndroidFindBy(id = "id.dretail.mpos:id/lbl")
	private MobileElement lbl;	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnClose")
	private MobileElement btnClose;
	@AndroidFindBy(id = "id.dretail.mpos:id/tvType")
	private MobileElement tvType;
	@AndroidFindBy(id = "id.dretail.mpos:id/tvName")
	private MobileElement tvName;
	@AndroidFindBy(id = "id.dretail.mpos:id/tvUnit")
	private MobileElement tvUnit;
	@AndroidFindBy(id = "id.dretail.mpos:id/tvPrice")
	private MobileElement tvPrice;
	@AndroidFindBy(id = "id.dretail.mpos:id/tvQuantity")
	private MobileElement tvQuantity;
	@AndroidFindBy(id = "id.dretail.mpos:id/tvSubTotal")
	private MobileElement tvSubTotal;
	@AndroidFindBy(id = "id.dretail.mpos:id/count")
	private MobileElement count;
	@AndroidFindBy(id = "id.dretail.mpos:id/total")
	private MobileElement total;
	@AndroidFindBy(id = "id.dretail.mpos:id/btnConfirm")
	private MobileElement btnConfirm;
	@AndroidFindBy(id = "id.dretail.mpos:id/content_text")
	private MobileElement content_text;
	@AndroidFindBy(id = "id.dretail.mpos:id/confirm_button")
	private MobileElement confirm_button;

	public PembelianinventarisPage pressconfirm_button() {
		click(confirm_button, "Konfirmasi Pembelian Inventaris Lagi");
		return new PembelianinventarisPage();
	}
	
	public String getcontent_text() {
		return getText(content_text, "Keterangan : ");
	}
	
	public TambahPembelianInventory pressbtnConfirm() {
		click(btnConfirm, "Konfirmasi Pembelian Inventaris");
		return this;
	}

	public String gettotal() {
		return getText(total, "Total Harga Pembelian Seluruh Item : ");
	}
	
	public String getcount() {
		return getText(count, "Banyaknya Jenis Item : ");
	}
	
	public String gettvSubTotal() {
		return getText(tvSubTotal, "Jumlah Sub Total Item : ");
	}
	
	public String gettvQuantity() {
		return getText(tvQuantity, "Jumlah Unit Item : ");
	}
	
	public String gettvPrice() {
		return getText(tvPrice, "Harga Satuan Unit Item : ");
	}
	
	public String gettvUnit() {
		return getText(tvUnit, "Satuan Unit Item : ");
	}
	
	public String gettvName() {
		return getText(tvName, "Nama Item : ");
	}
	
	public String gettvType() {
		return getText(tvType, "Tipe Item : ");
	}
	
	public PembelianinventarisPage pressbtnClose() {
		click(btnClose, "Kembali Ke Halaman Pembelian Inventaris");
		return new PembelianinventarisPage();
	}
	
	public String getlbl() {
		return getText(lbl, "Judul halaman : ");
	}

}
