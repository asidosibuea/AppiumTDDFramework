package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.pages.setting.SecondDisplayPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AktifitasPage extends BaseTest{

	@AndroidFindBy(xpath = "//*[@resource-id = \"id.dretail.mpos:id/lblTitle\" and @text=\"Aktifitas\"]")
	private MobileElement pageTitle;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnSync")
	private MobileElement btnSync;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id = \"id.dretail.mpos:id/id_text\" and @text=\"Settlement\"]")
	private MobileElement menuSettlement;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/etUsername")
	private MobileElement etUsername;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/etPassword")
	private MobileElement etPassword;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnSettlement")
	private MobileElement btnSettlement;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtCashAmount")
	private MobileElement txtCashAmount;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/title_text")
	private MobileElement titleText;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/cancel_button")
	private MobileElement btnCancel;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnClose")
	private MobileElement btnClose;
	
	public AktifitasPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}
	
	public AktifitasPage pressMenuSettlement() {
		click(menuSettlement, "Select menu Settlement");
		return this;
	}
	
	public AktifitasPage pressSecondDisplayMenu() {
		click(btnSync, "Press second display menu");
		return this;
	}

	public AktifitasPage enterUsername(String username) {
		clear(etUsername);
		sendKeys(etUsername, username, "Enter username: "+username);
		return this;
	}
	
	public AktifitasPage enterPassword(String password) {
		clear(etPassword);
		sendKeys(etPassword, password, "Enter password: "+password);
		return this;
	}
	
	public AktifitasPage pressBtnSettlement() {
		click(btnSettlement, "Press button Settlement");
		return this;
	}
	
	public AktifitasPage enterCashAmount(String cash_amount) {
		clear(txtCashAmount);
		sendKeys(txtCashAmount, cash_amount, "Enter cash amount: "+cash_amount);
		return this;
	}
	
	public String getTitleText() {
		return getText(titleText, "Status settlement adalah: ");
	}
	
	public AktifitasPage pressBtnCancel() {
		click(btnCancel, "Press button No");
		return this;
	}
	
	public AktifitasPage pressBtnClose() {
		click(btnClose, "Press button close pop up pratinjau settlement");
		return this;
	}
	
	public SidebarPage showSidebar() {
		swipingElement(pageTitle, "right", "on Aktifitas page");
		
		return new SidebarPage();
	}
}
