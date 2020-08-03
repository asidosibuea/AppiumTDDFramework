package com.qa.pages.popup;

import com.qa.base.BaseTest;
import com.qa.pages.PenjualanPage;
import com.qa.pages.LoginPage;
import com.qa.pages.PenjualanPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PopupItem extends BaseTest {

	@AndroidFindBy(id = "id.dretail.mpos:id/btnPlus")
	private MobileElement btnPlus;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnMin")
	private MobileElement btnMin;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/spDiscount")
	private MobileElement spDiscount;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtDiscount")
	private MobileElement txtDiscount;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtTotalPrice")
	private MobileElement txtTotalPrice;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtUnitPrice")
	private MobileElement txtUnitPrice;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtNote")
	private MobileElement txtNote;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnCancel")
	private MobileElement btnCancel;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnSave")
	private MobileElement btnSave;
	
	@AndroidFindBy(id =  "id.dretail.mpos:id/confirm_button")
	private MobileElement confirmLogoutBtn;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"Diskon Harga\")]")
	private MobileElement diskonHarga;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"Diskon Persen\")]")
	private MobileElement diskonPersen;
	
	public PenjualanPage CloseChartPopup(){
		click(btnCancel, "Press Button BATAL");
		return new PenjualanPage();
	}
	
	public PopupItem tambahItem(){
		click(btnPlus, "Tambah Qty Item : 1");
		return this;
	}
	
	public PenjualanPage pressSaveBtn(){
		click(btnSave, "Press Save Button");
		return new PenjualanPage();
	}
	
	public PenjualanPage pressCancelBtn(){
		click(btnCancel, "Press Cancel Button");
		return new PenjualanPage();
	}
	
	public PopupItem NominalTxt() {
		getText(txtTotalPrice, "Nominal saat ini adalah " + txtUnitPrice.getText() + " & Total saat ini adalah ");
		return this;
	}
	
	public PopupItem selectDiskonHarga() {
		click(spDiscount, "Pilih Diskon: ");
		click(diskonHarga, "Diskon Harga Terpilih");
		return this;
	}
	
	public PopupItem selectDiskonPersen() {
		click(spDiscount, "Pilih Diskon: ");
		click(diskonPersen, "Diskon Persen Terpilih");
		return this;
	}
	
	public PopupItem pressBtnMin() {
		click(btnMin, "Press button Min(-)");
		return this;
	}
	
	public PopupItem enterDiskonHarga(String discountHarga) {
		clear(txtDiscount);
		sendKeys(txtDiscount, discountHarga, "Enter Discount : "+discountHarga);
		return this;
	}
	
	public PopupItem enterHargaSatuan(String hargaSatuan) {
		clear(txtUnitPrice);
		sendKeys(txtUnitPrice, hargaSatuan, "Enter price : "+hargaSatuan);
		return this;
	}
	
	public PopupItem enterDiskonPersen(String discountPersen) {
		clear(txtDiscount);
		sendKeys(txtDiscount, discountPersen, "Enter Discount : "+discountPersen);
		return this;
	}
	
	public PopupItem enterNote(String note) {
		clear(txtNote);
		sendKeys(txtNote, note, "Enter Note: "+note);
		return this;
	}
	
	public PopupItem txtTotalPrice() {
		getText(txtTotalPrice, "Total harga setelah diskon adalah " + txtTotalPrice.getText());
		return this;
	}
	
	public PopupItem totMenu1() {
		getText(txtTotalPrice, "Total harga Jus Mangga setelah diskon adalah  " + txtTotalPrice.getText());
		return this;
	}
	
	public PopupItem totMenu2() {
		getText(txtTotalPrice, "Total harga Bubur Ayam Biasa setelah diskon adalah " + txtTotalPrice.getText());
		return this;
	}	
	
	public PenjualanPage pressConfirmLogoutBtn() {
		click(confirmLogoutBtn, "Press confirm delete chart button");
		
		return new PenjualanPage();
	}

}
