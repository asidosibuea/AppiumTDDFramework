package com.qa.pages.setting.printer;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.pages.setting.PrinterPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class JenisKoneksiPrinter extends BaseTest{
	
	@AndroidFindBy(id = "com.pactindo.mpospac.pandaprinter:id/tvOperationItem")
	private MobileElement jenisKoneksiBtn;
	
	@AndroidFindBy(id = "com.pactindo.mpospac.pandaprinter:id/btTestConnect")
	private MobileElement connectBtn;

	public JenisKoneksiPrinter() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}
	

	public OpsiPortPrinterPage pressJenisKoneksiBtn() {
		click(jenisKoneksiBtn, "Menekan jenis koneksi");
		return new OpsiPortPrinterPage();
	}
	
	public PrinterPage pressConnectBtn() {
		click(connectBtn, "menekan tombol connect");
		return new PrinterPage();
	}
	
	public AddPrinterPage pressConnectBtnByStasiun() {
		click(connectBtn, "menekan tombol connect");
		return new AddPrinterPage();
	}

}
