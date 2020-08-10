package com.qa.pages.popup;

import com.qa.base.BaseTest;
import com.qa.pages.PenjualanPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PopupNotifikasiPembayaran extends BaseTest{
	
	@AndroidFindBy(id = "id.dretail.mpos:id/lblTitle")
	private MobileElement lblTitle;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnOk")
	private MobileElement btnOk;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/lblMethod")
	private MobileElement lblMethod;
	

	public String getStatusPembayaran() {
		return getText(lblTitle, "Status Pembayaran : ");
	}
	
	public String getStatusMethod() {
		return getText(lblMethod, "Metode Pembayaran : ");
	}
	
	public PenjualanPage PressBtnOk(){
		click(btnOk, "Press button ok");
		return new PenjualanPage();
	}
	

}
