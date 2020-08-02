package com.qa.pages.penjualan;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PLNDenomPage extends BaseTest{
	
	@AndroidFindBy(id = "id.dretail.mpos:id/balanceTotal")
	private MobileElement totalSaldo;

	@AndroidFindBy(xpath = "//*[@text = \"20.000\"]")
	private MobileElement denom20ribu;
	
	@AndroidFindBy(xpath = "//*[@text = \"50.000\"]")
	private MobileElement denom50ribu;
	
	@AndroidFindBy(xpath = "//*[@text = \"100.000\"]")
	private MobileElement denom100ribu;
	
	@AndroidFindBy(xpath = "//*[@text = \"200.000\"]")
	private MobileElement denom200ribu;
	
	@AndroidFindBy(xpath = "//*[@text = \"500.000\"]")
	private MobileElement denom500ribu;
	
	@AndroidFindBy(xpath = "//*[@text = \"1.000.000\"]")
	private MobileElement denom1juta;
	
	@AndroidFindBy(xpath = "//*[@text = \"5.000.000\"]")
	private MobileElement denom5juta;
	
	@AndroidFindBy(xpath = "//*[@text = \"10.000.000\"]")
	private MobileElement denom10juta;
	
	public PLNDenomPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}
	
	public CheckoutPLN pilihDenom20Ribu() {
		click(denom20ribu, "Pilih denom 20ribu");
		return new CheckoutPLN();
	}
	
	public CheckoutPLN pilihDenom50Ribu() {
		click(denom50ribu, "Pilih denom 50ribu");
		return new CheckoutPLN();
	}
	
	public CheckoutPLN pilihDenom100Ribu() {
		click(denom100ribu, "Pilih denom 100ribu");
		return new CheckoutPLN();
	}
	
	public CheckoutPLN pilihDenom200Ribu() {
		click(denom200ribu, "Pilih denom 200ribu");
		return new CheckoutPLN();
	}
	
	public CheckoutPLN pilihDenom500Ribu() {
		click(denom500ribu, "Pilih denom 500ribu");
		return new CheckoutPLN();
	}
	
	public CheckoutPLN pilihDenom1juta() {
		click(denom1juta, "Pilih denom 1juta");
		return new CheckoutPLN();
	}
	
	public CheckoutPLN pilihDenom5juta() {
		click(denom5juta, "Pilih denom 5juta");
		return new CheckoutPLN();
	}
	
	public CheckoutPLN pilihDenom10juta() {
		click(denom10juta, "Pilih denom 10juta");
		return new CheckoutPLN();
	}
	
	public String getTotalSaldo() {
		return getText(totalSaldo, "Total saldo :");
	}
	
	public PLNDenomPage pressSaldo() {
		click(totalSaldo, "Menekan total saldo");
		return this;
	}

}
