package com.qa.pages.setting;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.pages.SettingPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BahasaPage extends SettingPage{

	public BahasaPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}
	
	

}
