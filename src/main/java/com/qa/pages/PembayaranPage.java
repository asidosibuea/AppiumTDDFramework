package com.qa.pages;

import com.qa.base.BaseTest;
import com.qa.pages.popup.PopupItem;
import com.qa.pages.popup.PopupJlhUangTunai;
import com.qa.pages.popup.PopupNotifikasiPembayaran;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PembayaranPage extends BaseTest {
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtCashAmount")
	private MobileElement txtCashAmount;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnPay")
	private MobileElement btnPay;
	
	
	public PopupJlhUangTunai enterCash() {
		click(txtCashAmount, "Masukan Jumlah Uang Tunai");
		return new PopupJlhUangTunai();
	}
	
	public PopupItem PilihKeranjang2(){
		click(btnPay, "Pilih Keranjang " + getStrings().get("expected_menu2_searched"));
		return new PopupItem();
	}
	
	public PopupNotifikasiPembayaran pressBtnPay() {
		click(btnPay, "Press button pay");
		return new PopupNotifikasiPembayaran();
	}
	
	
}
