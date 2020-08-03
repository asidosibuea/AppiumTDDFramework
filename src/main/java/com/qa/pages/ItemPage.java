package com.qa.pages;

import com.qa.base.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ItemPage extends BaseTest {

	@AndroidFindBy(xpath = "//*[contains(@text, \"Beverage\")]")
	private MobileElement kategoriMenu1;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"Food\")]")
	private MobileElement kategoriMenu2;
	
	public ItemPage pressMenu1Btn() {
		click(kategoriMenu1, "Press Button Kategori1 menu Beverage");
		return new ItemPage();
	}
	
	public ItemPage pressMenu2Btn() {
		click(kategoriMenu2, "Press Button Kategori2 menu Food");
		return new ItemPage();
	}
}
