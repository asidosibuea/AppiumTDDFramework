package com.qa.pages.popup;

import com.qa.base.BaseTest;
import com.qa.pages.PenjualanPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PopupStatusOrder extends BaseTest{
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnOrderTakeAway")
	private MobileElement btnTakeAway;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnOrderDineIn")
	private MobileElement btnDineIn;
	
	public PenjualanPage pressbtnTakeAway() {
		click(btnTakeAway, "Press btn take away");
		return new PenjualanPage();
	}
	
}
