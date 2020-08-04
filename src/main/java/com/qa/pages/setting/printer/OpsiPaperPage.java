package com.qa.pages.setting.printer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OpsiPaperPage extends BaseTest{
	
	private MobileElement jenisKertas = null;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnClose")
	private MobileElement closeBtn;

	public OpsiPaperPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}
	
	public JenisKoneksiPrinter pilihJenisKertas(String param) {
		scrollToElement("textContains", param, "scroll to "+param);
		jenisKertas = (MobileElement) getDriver().findElement(By.xpath("//*[@resource-id = \"id.dretail.mpos:id/title\" and @text=\""+param+"\"]"));
		click(jenisKertas, "memilih "+param);
		return new JenisKoneksiPrinter();
	}
	
	public OpsiDriverPrinterPage pressCloseBtn() {
		click(closeBtn, "Menekan tombol close");
		return new OpsiDriverPrinterPage();
	}
	
	
	
	

}
