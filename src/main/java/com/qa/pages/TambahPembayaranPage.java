package com.qa.pages;

import com.qa.base.BaseTest;
import com.qa.pages.popup.PopupJlhUangTunai;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TambahPembayaranPage extends BaseTest{
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtCashAmount")
	private MobileElement txtCashAmount;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnAdd")
	private MobileElement btnAdd;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtApprovalCode")
	private MobileElement txtApprovalCode;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtEdcAmount")
	private MobileElement txtEdcAmount;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtCustomerAccountNo")
	private MobileElement txtCustomerAccountNo;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtBankName")
	private MobileElement txtBankName;

	public PopupJlhUangTunai pressTxtCashAmount() {
		click(txtCashAmount, "Masukan jumlah uang tunai");
		return new PopupJlhUangTunai();
	}
	
	public PopupJlhUangTunai pressTxtEdcAmount() {
		click(txtEdcAmount, "Masukan jumlah uang tunai");
		return new PopupJlhUangTunai();
	}
	
	public MultiPaymentPage pressBtnAdd() {
		click(btnAdd, "Press button Tambah");
		return new MultiPaymentPage();
	}
	
	public TambahPembayaranPage scrollToAccountNo() {
		scrollToElement("resourceId", "id.dretail.mpos:id/txtCustomerAccountNo", "Searching Element...");
		return this;
	}
	
	public TambahPembayaranPage enterNomorKartu(String rek_number) {
		clear(txtCustomerAccountNo);
		sendKeys(txtCustomerAccountNo, rek_number, "Enter Nomor Kartu: "+rek_number);
		return this;
	}
	
	public TambahPembayaranPage scrollToApprovalCode() {
		scrollToElement("resourceId", "id.dretail.mpos:id/txtApprovalCode", "Searching Element...");
		return this;
	}
	
	public TambahPembayaranPage enterNamaBank(String nama_bank) {
		clear(txtBankName);
		sendKeys(txtBankName, nama_bank, "Enter Nama Bank: "+nama_bank);
		return this;
	}
	
	public TambahPembayaranPage enterApprovalCode(String approval_code) {
		clear(txtApprovalCode);
		sendKeys(txtApprovalCode, approval_code, "Enter Approval Code: "+approval_code);
		return this;
	}
	
}
