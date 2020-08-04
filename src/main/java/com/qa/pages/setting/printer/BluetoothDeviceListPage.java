package com.qa.pages.setting.printer;

import org.openqa.selenium.By;

import com.qa.base.BaseTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BluetoothDeviceListPage extends BaseTest{
	
	@AndroidFindBy(id = "com.pactindo.mpospac.pandaprinter:id/btBluetoothScan")
	private MobileElement scanBtn;
	
//	@AndroidFindBy(xpath = "//android.widget.ListView[descendant::android.widget.TextView]")
	@AndroidFindBy(xpath = "//android.widget.ListView[@resource-id= \"com.pactindo.mpospac.pandaprinter:id/lvPairedDevices\"]//*")
	private MobileElement pairedBluetoothDevice;
	
	
	public BluetoothDeviceListPage pressScanBtn() {
		click(scanBtn, "menekan tombol scan");
		return this;
	}
	
	public OpsiPortPrinterPage pilihBluetoothDevice(String param) {
		
		String actualPaired = getText(pairedBluetoothDevice, "Actual paired device : ").trim();
		System.out.println("zActual paired device "+actualPaired);
		
		String expectedPaired = getStrings().get("expected_paired_bt").trim();
		
		
		if(!actualPaired.equalsIgnoreCase(expectedPaired)) {
			pressScanBtn();
			scrollToElement("textContains", param, "Scroll ke device : "+param);
			MobileElement element = (MobileElement) getDriver().findElement(By.xpath("//*[contains(@text, \""+param+"\")]"));
		
			click(element, "Memilih device : "+param);	
			return new OpsiPortPrinterPage();
		}

		click(pairedBluetoothDevice, "Memilih device "+param);
		return new OpsiPortPrinterPage();
	}
	
	
	
	
	

}
