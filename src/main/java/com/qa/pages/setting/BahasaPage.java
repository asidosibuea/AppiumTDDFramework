package com.qa.pages.setting;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.pages.SettingPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BahasaPage extends SettingPage{
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnEnUs")
	private MobileElement englishLangBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnIndonesia")
	private MobileElement indonesianLangBtn;

	public BahasaPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}
	
	public BahasaPage pressEnglishLangBtn() {
		click(englishLangBtn, "Menekan pilih bahasa inggris");
		return this;
	}
	
	public BahasaPage pressIndonesianLangBtn() {
		click(indonesianLangBtn, "Menekan pilih bahasa Indonesia");
		return this;
	}
	
	public boolean getStatusBahasa() {
		String status = getText(indonesianLangBtn, "Status bahasa indonesia : ");
		if(status.equalsIgnoreCase(getStrings().get("selected_bahasa_indonesia"))){
			return true;
		}
		
		return false;
	}
	
	public boolean getStatusEnglish() {
		String status = getText(englishLangBtn, "Status bahasa inggris : ");
		if(status.equalsIgnoreCase(getStrings().get("selected_bahasa_inggris"))){
			return true;
		}
		
		return false;
	}

}
