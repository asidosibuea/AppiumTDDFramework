package com.qa.pages.penjualan;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AllMenuPage extends OrderCartPage {
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnSwitchToPPOB")
	private MobileElement switchToPPOBbtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnNotif")
	private MobileElement notifBtn;
	
	@AndroidFindBy(id="id.dretail.mpos:id/txtSearchMenu")
	private MobileElement searchBox;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/balanceTotal")
	private MobileElement balanceTotalBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnFavoriteMenu")
	private MobileElement favoriteMenuBtn;
	
	
	public AllMenuPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}

	public PPOBPage pressSwitchToPPOBBtn() {
		click(switchToPPOBbtn, "Press switch to ppob");
		return new PPOBPage();
	}
	

}
