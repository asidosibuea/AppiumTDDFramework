package com.qa.pages.setting.printer;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OpsiPortPrinterPage extends BaseTest{
	
	@AndroidFindBy(id = "com.pactindo.mpospac.pandaprinter:id/rbBluetooth")
	private MobileElement radioBluetooth;
	
	@AndroidFindBy(id = "com.pactindo.mpospac.pandaprinter:id/rbUsb")
	private MobileElement radioUsb;
	
	@AndroidFindBy(id = "com.pactindo.mpospac.pandaprinter:id/rbEthernet")
	private MobileElement radioEthernet;
	
	@AndroidFindBy(id = "com.pactindo.mpospac.pandaprinter:id/etIpAddress")
	private MobileElement ipAddressField;
	
	@AndroidFindBy(id = "com.pactindo.mpospac.pandaprinter:id/btOk")
	private MobileElement okBtn;
	
	
	public OpsiPortPrinterPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}
	
	
	public JenisKoneksiPrinter backToSelectConnection() {
		forceBack();
		return new JenisKoneksiPrinter();
	}
	
	public OpsiPortPrinterPage pressRadioEthernet() {
		click(radioEthernet, "Memilih ethernet");
		return this;
	}
	
	public OpsiPortPrinterPage enterIpAddress(String param) {
		clear(ipAddressField);
		sendKeys(ipAddressField, param, "Input ip address : "+param);
		return this;
	}
	
	public BluetoothDeviceListPage pressRadioBluetooth() {
		click(radioBluetooth, "Memilih opsi bluetooth");
		
		return new BluetoothDeviceListPage();
	}
	
	public JenisKoneksiPrinter pressOkBtn() {
		click(okBtn, "Menekan tombol ok");
		return new JenisKoneksiPrinter();
	}
	

}
