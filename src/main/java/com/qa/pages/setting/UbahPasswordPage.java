package com.qa.pages.setting;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.pages.SettingPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UbahPasswordPage extends SettingPage{
	
	@AndroidFindBy(id = "id.dretail.mpos:id/oldPassword")
	private MobileElement oldPasswordField;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/newPassword")
	private MobileElement newPasswordField;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/reTypeNewPassword")
	private MobileElement retypePasswordField;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnCreateNewCustomer")
	private MobileElement simpanBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/content_text")
	private MobileElement popupMsg;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/confirm_button")
	private MobileElement popupConfirmBtn;

	public UbahPasswordPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}
	
	public UbahPasswordPage enterOldPassword(String param) {
		clear(oldPasswordField);
		sendKeys(oldPasswordField, param, "mengisi password lama : ");
		return this;
	}
	
	public UbahPasswordPage enterNewPassword(String param) {
		clear(newPasswordField);
		sendKeys(newPasswordField, param, "mengisi password baru : ");
		return this;
	}
	
	public UbahPasswordPage retypePassword(String param) {
		clear(retypePasswordField);
		sendKeys(retypePasswordField, param, "konfirmasi password baru : ");
		return this;
	}
	
	public UbahPasswordPage pressSimpanBtn() {
		click(simpanBtn, "menekan tombol simpan kata sandi");
		return this;
	}
	
	public String getPopupMsg() {
		return getText(popupMsg, "Teks popup : ");
	}
	
	public UbahPasswordPage pressPopupConfirmBtn() {
		click(popupConfirmBtn, "menekan ok pada popup");
		return this;
	}
	

}
