package com.qa.pages;

import com.qa.base.BaseTest;
import com.qa.pages.popup.PopupOtorisasi;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DetailTransaksiPage extends BaseTest{
	
	@AndroidFindBy(id =  "id.dretail.mpos:id/labelOrderNumber")
	private MobileElement lblTitle;
	
	@AndroidFindBy(id =  "id.dretail.mpos:id/btnClose")
	private MobileElement btnClose;
	
	@AndroidFindBy(id =  "id.dretail.mpos:id/btnPrintReceipt")
	private MobileElement btnPrint;
	
	public String getNomorOrder() {
		return getText(lblTitle, "Nomor Order adalah: ");
	}
	
	public RiwayatPage pressBtnClose() {
		click(btnClose, "Press button close");
		return new RiwayatPage();
	}
	
	public PopupOtorisasi pressBtnPrint() {
		click(btnPrint, "Press button Print Resi");
		return new PopupOtorisasi();
	}
}
