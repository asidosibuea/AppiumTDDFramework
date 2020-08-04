package com.qa.pages.setting;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.qa.pages.SettingPage;
import com.qa.pages.setting.printer.AddPrinterPage;
import com.qa.pages.setting.printer.OpsiDriverPrinterPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PrinterPage extends SettingPage{
	
	@AndroidFindBy(id = "id.dretail.mpos:id/swStatus")
	private MobileElement statusPrinterBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnChangePrinter")
	private MobileElement changePrinterBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnTestPrinter")
	private MobileElement testPrinterBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnAddPrinter")
	private MobileElement addPrinterBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/swOrderPrint")
	private MobileElement switchKitchenOrder;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/swTableOrderPrint")
	private MobileElement switchTableOrder;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/swKitchenDisplay")
	private MobileElement switchKDO;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/confirm_button")
	private MobileElement confirmBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/content_text")
	private MobileElement popupMsg;
	
	public PrinterPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}

	public PrinterPage switchOnStatusPrinter() {
		switchElement(statusPrinterBtn, TestUtils.ON, "Switch on status printer");
		return this;
	}
	
	public PrinterPage switchOffStatusPrinter() {
		switchElement(statusPrinterBtn, TestUtils.OFF, "Switch on status printer");
		return this;
	}
	
	public OpsiDriverPrinterPage pressChangePrinterBtn() {
		click(changePrinterBtn, "menekan tombol ganti printer");
		return new OpsiDriverPrinterPage();
	}
	
	public AddPrinterPage pressAddPrinterBtn() {
		click(addPrinterBtn, "menekan tombol tambah printer");
		return new AddPrinterPage();
	}
	
	public PrinterPage scrolldown() {
		getDriver().manage().timeouts().implicitlyWait(TestUtils.WAITFORSWIPE, TimeUnit.SECONDS);
		scrollToElement("textContains", "Kitchen Display Order", "scrolldown di halaman printer");
		return this;
	}
	
	public PrinterPage switchOnKitchenOrder() {
		switchElement(switchKitchenOrder, TestUtils.ON, "Switch on kitchen order");
		return this;
	}
	
	public PrinterPage switchOffKitchenOrder() {
		switchElement(switchKitchenOrder, TestUtils.OFF, "Switch off kitchen order");
		return this;
	}
	
	public PrinterPage switchOnTableOrder() {
		switchElement(switchTableOrder, TestUtils.ON, "Switch on table order");
		return this;
	}
	
	public PrinterPage switchOffTableOrder() {
		switchElement(switchTableOrder, TestUtils.OFF, "Switch off table order");
		return this;
	}
	
	public PrinterPage switchOnKDO() {
		switchElement(switchKDO, TestUtils.ON, "Switch on KDO");
		return this;
	}
	
	public PrinterPage switchOffKDO() {
		switchElement(switchKDO, TestUtils.OFF, "Switch off KDO");
		return this;
	}
	
	public PrinterPage pressTestPrinter() {
		click(testPrinterBtn, "Menekan tombol tes printer");
		return this;
	}
	
	public PrinterPage pressPopupConfirm() {
		click(confirmBtn, "Menekan tombol ok di popup");
		return this;
	}
	
	public String getPopupMsg() {
		return getText(popupMsg, "hasil cetak : ");
	}

}
