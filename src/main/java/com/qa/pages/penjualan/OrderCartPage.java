package com.qa.pages.penjualan;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OrderCartPage extends BaseTest{
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnSelectTable")
	private MobileElement pilihMejaBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/tvCustomerName")
	private MobileElement customerNameLabel;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnOrderOption")
	private MobileElement daftarPesananBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnOrderType")
	private MobileElement orderTypeBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnOrder")
	private MobileElement submitOrderBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/customerName")
	private MobileElement pilihPelangganBtn;
	
	public OrderCartPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}

	public OrderCartPage pressPilihMejaBtn() {
		
		return this;
	}
	
	public OrderCartPage pressCustomerNameLabel() {
		
		return this;
	}
	
	public OrderCartPage pressDaftarPesananBtn() {
		
		return this;
	}
	
	public OrderCartPage pressOrderTypeBtn() {
		
		return this;
	}
	
	public OrderCartPage pressSubmitOrderBtn() {
		 
		return this;
	}
	
	public OrderCartPage pressPilihPelangganBtn() {
		
		return this;
	}

}
