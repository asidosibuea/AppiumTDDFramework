package com.qa.pages.setting;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.pages.SettingPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PrinterPage extends SettingPage{
	
	@AndroidFindBy(id = "id.dretail.mpos:id/swStatus")
	private MobileElement statusPrinterBtn;
	
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

}
