package com.qa.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.pages.penjualan.AllMenuPage;
import com.qa.pages.penjualan.OrderCartPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PenjualanPage extends BaseTest{
	
	@AndroidFindBy(id = "id.dretail.mpos:id/customerName")
	private MobileElement namaPelangganTxt;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnAllMenu")
	private MobileElement allMenuBtn;
	
	public PenjualanPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}

	public SidebarPage showSidebar() {
		getDriver().manage().timeouts().implicitlyWait(TestUtils.WAITFORSWIPE, TimeUnit.SECONDS);
		swipingElement(namaPelangganTxt, "right", "on dashboard page");
		
		return new SidebarPage();
	}
		
	public String getNamaPelanggan() {
		return getText(namaPelangganTxt, "username is ");
		
	}
	
	public AllMenuPage pressAllMenuBtn() {
		click(allMenuBtn, "Press all menu");
		return new AllMenuPage();
	}
	

}
