package com.qa.pages.setting.printer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.pages.setting.PrinterPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddPrinterPage extends BaseTest{
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnClose")
	private MobileElement closeBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/lblPrinter")
	private MobileElement labelSelectedPrinter;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/lblTitle")
	private MobileElement labelTitle;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtPrinter")
	private MobileElement namaStasiunPrinterField;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnSelectPrinter")
	private MobileElement selectPrinterBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnOk")
	private MobileElement okBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/lblCategory")
	private MobileElement labelKategoriMenu;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = \"Combo\"]/following-sibling::android.widget.Switch[@resource-id =\"id.dretail.mpos:id/swOnOff\"]")
	private MobileElement switchOnOffCombo;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = \"Food\"]/following-sibling::android.widget.Switch[@resource-id =\"id.dretail.mpos:id/swOnOff\"]")
	private MobileElement switchOnOffFood;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = \"Grab Food\"]/following-sibling::android.widget.Switch[@resource-id =\"id.dretail.mpos:id/swOnOff\"]")
	private MobileElement switchOnOffGrab;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = \"Kopi\"]/following-sibling::android.widget.Switch[@resource-id =\"id.dretail.mpos:id/swOnOff\"]")
	private MobileElement switchOnOffKopi;
	
	public AddPrinterPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}
	
	
	public AddPrinterPage switchOnKategori(String kategori, String status) {
		MobileElement element = (MobileElement) getDriver().findElement(By.xpath("//android.widget.TextView[@text = \""+kategori+"\"]/following-sibling::android.widget.Switch[@resource-id =\"id.dretail.mpos:id/swOnOff\"]"));
		
		switchElement(element, status, "Mengaktifkan switch : "+kategori);
		return this;
	}
	
	public OpsiDriverPrinterPage pressSelectPrinterBtn() {
		click(selectPrinterBtn, "Menekan tombol pilih printer");
		return new OpsiDriverPrinterPage();
	}
	
	public AddPrinterPage enterNamaStasiun(String param) {
		clear(namaStasiunPrinterField);
		sendKeys(namaStasiunPrinterField, param, "mengisi nama stasiun printer :"+param);
		
		return this;
	}
	
	public PrinterPage pressOkBtn() {
		click(okBtn, "menekan tombol OK");
		return new PrinterPage();
	}
	

}
