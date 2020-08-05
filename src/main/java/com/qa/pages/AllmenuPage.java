package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AllmenuPage extends BaseTest{
	public AllmenuPage() {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}

	TestUtils utils = new TestUtils();
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnSwitchToPPOB")
	private MobileElement btnSwitchToPPOB;
	
	public PpobPage pressbtnSwitchToPPOB() {
		click(btnSwitchToPPOB, "Masuk Menu PPOB");
		return new PpobPage();
	}
	
	


}
