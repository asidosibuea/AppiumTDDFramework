package com.qa.pages.popup;

import com.qa.base.BaseTest;
import com.qa.pages.PenjualanPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PopupBiayaKirim extends BaseTest{

	@AndroidFindBy(id = "id.dretail.mpos:id/txtDeliveryFee")
	private MobileElement txtDeliveryFee;

	@AndroidFindBy(id = "id.dretail.mpos:id/btnAddDeliveryFee")
	private MobileElement btnAddDeliveryFee;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnAddDelivery")
	private MobileElement btnAddDelivery;
	
	public PopupBiayaKirim pressbtnAddDelivery() {
		click(btnAddDelivery, "Press btn Tambah Biaya Pengiriman");
		return this;
	}
	
	public PopupBiayaKirim enterBiayaKirim(String discountHarga) {
		clear(txtDeliveryFee);
		sendKeys(txtDeliveryFee, discountHarga, "Enter Discount : "+discountHarga);
		return this;
	}
	
	public PenjualanPage pressbtnAddDeliveryFee() {
		click(btnAddDeliveryFee, "Press btn ok");
		return new PenjualanPage();
	}
	
	
}
