package com.qa.pages;

import com.qa.base.BaseTest;
import com.qa.pages.popup.PopupItem;
import com.qa.pages.popup.PopupJlhUangTunai;
import com.qa.pages.popup.PopupNotifikasiPembayaran;
import com.qa.pages.popup.PopupStatusOrder;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PembayaranPage extends BaseTest {
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtCashAmount")
	private MobileElement txtCashAmount;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnPay")
	private MobileElement btnPay;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnOther")
	private MobileElement btnOther;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[4]")
	private MobileElement btnVoucher;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[3]")
	private MobileElement btnPending;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[2]")
	private MobileElement btnTransfer;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtCustomerName")
	private MobileElement txtCustomerName;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtPhone")
	private MobileElement txtPhone;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtEmail")
	private MobileElement txtEmail;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnOk")
	private MobileElement btnOk;	
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtAccountHolderName")
	private MobileElement txtAccountHolderName;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtAccountNumber")
	private MobileElement txtAccountNumber;

	@AndroidFindBy(id = "id.dretail.mpos:id/txtBankName")
	private MobileElement txtBankName;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtTransactId")
	private MobileElement txtVoucherCode;
	
	
	public PopupJlhUangTunai enterCash() {
		click(txtCashAmount, "Masukan Jumlah Uang Tunai");
		return new PopupJlhUangTunai();
	}
	
	public PembayaranPage pressBtnOther() {
		click(btnOther, "Press btn Pembayaran Lainnya");
		return this;
	}
	
	public PembayaranPage pressBtnPending() {
		click(btnPending, "Press btn Pending");
		return this;
	}
	
	public PopupItem PilihKeranjang2(){
		click(btnPay, "Pilih Keranjang " + getStrings().get("expected_menu2_searched"));
		return new PopupItem();
	}
	
	public PopupNotifikasiPembayaran pressBtnPay() {
		click(btnPay, "Press button pay");
		return new PopupNotifikasiPembayaran();
	}
	
	public PembayaranPage enterNameCustomer(String customerName) {
		clear(txtCustomerName);
		sendKeys(txtCustomerName, customerName, "Enter customer's name : "+customerName);
		return this;
	}
	
	public PembayaranPage enterEmailCustomer(String customerEmail) {
		clear(txtEmail);
		sendKeys(txtEmail, customerEmail, "Enter customer's email : "+customerEmail);
		return this;
	}
	
	public PembayaranPage enterTlpCustomer(String customerTlp) {
		clear(txtPhone);
		sendKeys(txtPhone, customerTlp, "Enter customer's phone	 : "+customerTlp);
		return this;
	}
	
	public PopupNotifikasiPembayaran pressBtnOk() {
		click(btnOk, "Press button OK");
		return new PopupNotifikasiPembayaran();
	}
	
	public PembayaranPage pressBtnTransfer() {
		click(btnTransfer, "Press button Transfer");
		return this;
	}
	
	public PembayaranPage pressBtnVoucher() {
		click(btnVoucher, "Press button Voucher");
		return this;
	}
	
	public PembayaranPage enterNamaRek(String customerName) {
		scrollToElement("textMatches", "Nama Pemilik Rekening", "Searching Element...");
		clear(txtAccountHolderName);
		sendKeys(txtAccountHolderName, customerName, "Enter customer's name account: "+customerName);
		return this;
	}
	
	public PembayaranPage enterNoRek(String customerRek) {
		scrollToElement("textMatches", "Nomor Rekening", "Searching Element...");
		clear(txtAccountNumber);
		sendKeys(txtAccountNumber, customerRek, "Enter customer's account numbers: "+customerRek);
		return this;
	}

	public PembayaranPage enterBankName(String bankName) {
		scrollToElement("textMatches", "Nama Bank", "Searching Element...");
		clear(txtBankName);
		sendKeys(txtBankName, bankName, "Enter Bank name: "+bankName);
		return this;
	}
	
	public PembayaranPage enterKodeVoucher(String voucherCode) {
		scrollToElement("textMatches", "Kode Voucher", "Searching Element...");
		clear(txtVoucherCode);
		sendKeys(txtVoucherCode, voucherCode, "Enter voucher code: "+voucherCode);
		return this;
	}
	
}
