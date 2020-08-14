package com.qa.pages;

import com.qa.base.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class DiskonBillPage extends BaseTest{
	@AndroidFindBy(xpath = "//*[contains(@text, \"Diskon 10%\")]")
	private MobileElement selectDiskon;
	
	public PenjualanPage diskonSepuluhPersen() {
		click(selectDiskon, "Select Diskon 10%");
		return new PenjualanPage();
	}
	
}
