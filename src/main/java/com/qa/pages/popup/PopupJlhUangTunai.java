package com.qa.pages.popup;

import com.qa.base.BaseTest;
import com.qa.pages.PembayaranPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PopupJlhUangTunai extends BaseTest {
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btn1")
	private MobileElement btn1;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btn5")
	private MobileElement btn5;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnThousand")
	private MobileElement btnThousand;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnOk")
	private MobileElement btnOk;
	
	
	public PopupJlhUangTunai PressBtn1(){
		click(btn1, "Press angka 1");
		return this;
	}
	
	public PopupJlhUangTunai PressBtn5(){
		click(btn5, "Press angka 5");
		return this;
	}
	
	public PopupJlhUangTunai PressBtnThousand(){
		click(btnThousand, "Press angka 000");
		return this;
	}
	
	public PembayaranPage PressBtnOk(){
		click(btnOk, "Press button Ok");
		return new PembayaranPage();
	}
	
}
