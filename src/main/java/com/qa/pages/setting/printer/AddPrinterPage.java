package com.qa.pages.setting.printer;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.utils.TestUtils;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddPrinterPage extends BaseTest{

	public AddPrinterPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}

}
