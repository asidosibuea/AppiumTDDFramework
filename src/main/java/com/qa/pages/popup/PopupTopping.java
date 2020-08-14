package com.qa.pages.popup;

import com.qa.base.BaseTest;
import com.qa.pages.PenjualanPage;
import com.qa.pages.ItemPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PopupTopping extends BaseTest{
	@AndroidFindBy(id = "id.dretail.mpos:id/btnSave")
	private MobileElement btnSave;

	public PenjualanPage pressSaveBtn() {
		click(btnSave, "Press Save Button");
		return new PenjualanPage();
	}
}
