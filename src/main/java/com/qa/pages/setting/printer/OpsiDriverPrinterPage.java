package com.qa.pages.setting.printer;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.pages.setting.PrinterPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OpsiDriverPrinterPage extends BaseTest{
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnClose")
	private MobileElement closeBtn;
	
	@AndroidFindBy(xpath = "//*[@resource-id = \"id.dretail.mpos:id/title\" and @text=\"GPRINTER\"]")
	private MobileElement gprinterBtn;
	
	@AndroidFindBy(xpath = "//*[@resource-id = \"id.dretail.mpos:id/title\" and @text=\"RONGTA\"]")
	private MobileElement rongtaBtn;
	
	@AndroidFindBy(xpath = "//*[@resource-id = \"id.dretail.mpos:id/title\" and @text=\"EPSON\"]")
	private MobileElement epsonBtn;
	
	@AndroidFindBy(xpath = "//*[@resource-id = \"id.dretail.mpos:id/title\" and @text=\"Bluetooth Printer\"]")
	private MobileElement bluetoothPrinterBtn;
	
	@AndroidFindBy(xpath = "//*[@resource-id = \"id.dretail.mpos:id/title\" and @text=\"Universal Printer\"]")
	private MobileElement universalPrinterBtn;

	public OpsiDriverPrinterPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}
	
	public OpsiPaperPage pilihGprinter(){
		click(gprinterBtn, "pilih GPRINTER");
		return new OpsiPaperPage();
	}
	
	public OpsiPaperPage pilihRongtaPrinter(){
		click(rongtaBtn, "pilih RONGTA");
		return new OpsiPaperPage();
	}
	
	public OpsiPaperPage pilihEpsonPrinter(){
		click(epsonBtn, "pilih EPSON");
		return new OpsiPaperPage();
	}
	
	public OpsiPaperPage pilihBluetoothPrinter(){
		click(bluetoothPrinterBtn, "pilih Bluetooth Printer");
		return new OpsiPaperPage();
	}
	
	public OpsiPaperPage pilihUniversalPrinter(){
		click(universalPrinterBtn, "pilih Universal Printer");
		return new OpsiPaperPage();
	}
	
	public PrinterPage pressCloseBtn() {
		click(closeBtn, "Menekan tombol close");
		return new PrinterPage();
	}


}
