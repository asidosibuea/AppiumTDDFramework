package com.qa.pages.popup;

import com.qa.base.BaseTest;
import com.qa.pages.DetailTransaksiPage;
import com.qa.pages.PembayaranPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PopupOtorisasi extends BaseTest{

	@AndroidFindBy(id =  "id.dretail.mpos:id/txtUsername")
	private MobileElement txtUsername;
	
	@AndroidFindBy(id =  "id.dretail.mpos:id/txtPassword")
	private MobileElement txtPasswords;
	
	@AndroidFindBy(id =  "id.dretail.mpos:id/btnSend")
	private MobileElement btnSend;
	
	@AndroidFindBy(id =  "id.dretail.mpos:id/content_text")
	private MobileElement statusPrint;
	
	@AndroidFindBy(id =  "id.dretail.mpos:id/confirm_button")
	private MobileElement btnConfirm;
	
	
	public PopupOtorisasi enterUsername(String username) {
		clear(txtUsername);
		sendKeys(txtUsername, username, "Enter Username: "+username);
		return this;
	}
	
	public PopupOtorisasi enterPassword(String password) {
		clear(txtPasswords);
		sendKeys(txtPasswords, password, "Enter Password: "+password);
		return this;
	}
	
	public DetailTransaksiPage pressBtnSend() {
		click(btnSend, "Press button OK");
		return new DetailTransaksiPage();
	}
	
	public DetailTransaksiPage pressBtnConfirm() {
		click(btnConfirm, "Press confirm button");
		return new DetailTransaksiPage();
	}
	
	public String getPrintStatus() {
		return getText(statusPrint, "Status Print adalah: ");
	}
	
}
