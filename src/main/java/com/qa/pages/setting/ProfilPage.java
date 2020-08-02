package com.qa.pages.setting;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.qa.pages.SettingPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfilPage extends SettingPage{
	
	@AndroidFindBy(id = "id.dretail.mpos:id/row1")
	private MobileElement fieldFooterRow1;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/row2")
	private MobileElement fieldFooterRow2;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/confirm_button")
	private MobileElement confirmBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/content_text")
	private MobileElement popupMsg;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnSaveProfile")
	private MobileElement saveFooterBtn;
	
	
	public ProfilPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}

	public ProfilPage enterFooterRow1(String txt) {
		clear(fieldFooterRow1);
		sendKeys(fieldFooterRow1, txt, "Text footer row-1 : "+txt);
		return this;
	}
	
	public ProfilPage enterFooterRow2(String txt) {
		clear(fieldFooterRow2);
		sendKeys(fieldFooterRow2, txt, "Text footer row-2 : "+txt);
		return this;
	}
	
	public ProfilPage scrollToFooterDescription() {
		getDriver().manage().timeouts().implicitlyWait(TestUtils.WAITFORSWIPE, TimeUnit.SECONDS);
		scrollToElement("textContains", "Row 2", "scroll to footer description in profil page");
		return this;
	}
	
	public ProfilPage pressConfirmationButton(String popupType) {
		click(confirmBtn, "Press OK on " + popupType + " popup");
		return this;
	}
	
	public ProfilPage pressSaveFooterButton() {
		click(saveFooterBtn, "Press save ");
		return this;
	}
	
	public String getPopupMsg() {
		return getText(popupMsg, "Popup message is :");
	}

}
