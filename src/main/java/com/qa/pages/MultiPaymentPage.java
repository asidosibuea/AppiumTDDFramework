package com.qa.pages;

import com.qa.base.BaseTest;
import com.qa.pages.popup.PopupNotifikasiPembayaran;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MultiPaymentPage extends BaseTest{

	@AndroidFindBy(id = "id.dretail.mpos:id/btnAddPayment")
	private MobileElement btnAddPayment;
	
	@AndroidFindBy(xpath = "//*[@resource-id = \"id.dretail.mpos:id/lblTitle\" and @text=\"Cash\"]")
	private MobileElement multiPayment1;
	
	@AndroidFindBy(xpath = "//*[@resource-id = \"id.dretail.mpos:id/lblTitle\" and @text=\"Debit\"]")
	private MobileElement multiPayment2;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnPay")
	private MobileElement btnPay;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtCustomerName")
	private MobileElement txtCustomerName;
	
	public TambahPembayaranPage pressBtnAddPayment() {
		click(btnAddPayment, "Press button +Tambah Metode Pembayaran");
		return new TambahPembayaranPage();
	}
	
	public String getMultiPayment1() {
		return getText(multiPayment1, "Metode payment pertama adalah ");
	}
	
	public String getMultiPayment2() {
		return getText(multiPayment2, "Metode payment kedua adalah ");
	}
	
	public PopupNotifikasiPembayaran pressBtnPay() {
		click(btnPay, "Press button Bayar");
		return new PopupNotifikasiPembayaran();
	}
	
	public MultiPaymentPage enterCustomerName(String customer_name) {
		clear(txtCustomerName);
		sendKeys(txtCustomerName, customer_name, "Enter customer's name: "+customer_name);
		return this;
	}
}
