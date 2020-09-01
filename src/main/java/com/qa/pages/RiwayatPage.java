package com.qa.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RiwayatPage extends BaseTest{

	@AndroidFindBy(id =  "id.dretail.mpos:id/lblTitle")
	private MobileElement lblTitle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = \"120820002\"]")
	private MobileElement noOrder;
	
	public RiwayatPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}
	
	public String getLblTitle() {
		return getText(lblTitle, "Label pada title adalah: ");
	}
	
	public SidebarPage showSidebar() {
		getDriver().manage().timeouts().implicitlyWait(TestUtils.WAITFORSWIPE, TimeUnit.SECONDS);
		swipingElement(lblTitle, "right", "on dashboard page");
		
		return new SidebarPage();
	}
	
	public DetailTransaksiPage pressOrderNumber(String orderNumber) {
		getDriver().manage().timeouts().implicitlyWait(TestUtils.WAITFORSWIPE, TimeUnit.SECONDS);
		scrollToElement("textMatches", orderNumber, "Searching Order Number...");
		click(noOrder, "Press the order number");
		
		return new DetailTransaksiPage();
	}
	
	public RiwayatPage pressBackBtn() {
		forceBack();
		return this;
	}
}
