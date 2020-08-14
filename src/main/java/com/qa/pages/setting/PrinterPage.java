package com.qa.pages.setting;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import com.qa.pages.SettingPage;
import com.qa.pages.setting.printer.AddPrinterPage;
import com.qa.pages.setting.printer.OpsiDriverPrinterPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PrinterPage extends SettingPage{
	
	@AndroidFindBy(id = "id.dretail.mpos:id/swStatus")
	private MobileElement statusPrinterBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnChangePrinter")
	private MobileElement changePrinterBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnTestPrinter")
	private MobileElement testPrinterBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnAddPrinter")
	private MobileElement addStasiunPrinterBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/swOrderPrint")
	private MobileElement switchKitchenOrder;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/swTableOrderPrint")
	private MobileElement switchTableOrder;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/swKitchenDisplay")
	private MobileElement switchKDO;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/confirm_button")
	private MobileElement confirmBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/content_text")
	private MobileElement popupMsg;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnSelectPrinter")
	
	private MobileElement pilihPrinterBtn;
	
	@AndroidFindBy(xpath = "//*[@text = \"food\"]")
	private MobileElement foodStasiun;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/neutral_button")
	private MobileElement popupCancelBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/cancel_button")
	private MobileElement popupHapusPrinterBtn;
	
	@AndroidFindBy(xpath = "//*[@resource-id=\"id.dretail.mpos:id/cancel_button\" and @text = \"Ya, hapus printer\"]")
	private MobileElement popupConfirmHapusPrinterBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/confirm_button")
	private MobileElement popupUbahPrinterBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/content_text")
	@CacheLookup
	private MobileElement popupHapusPrinterMsg;
	
	private MobileElement testStasiunBtn = null;
	
	public PrinterPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}

	public PrinterPage switchOnStatusPrinter() {
		switchElement(statusPrinterBtn, TestUtils.ON, "Switch on status printer");
		return this;
	}
	
	public PrinterPage switchOffStatusPrinter() {
		switchElement(statusPrinterBtn, TestUtils.OFF, "Switch off status printer");
		return this;
	}
	
	public String getStatusPrinter() {
		return getText(statusPrinterBtn, "Status printer : ");
	}
	
	public OpsiDriverPrinterPage pressChangePrinterBtn() {
		try {
			click(changePrinterBtn, "menekan tombol ganti printer");
			return new OpsiDriverPrinterPage();
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public AddPrinterPage pressAddPrinterBtn() {
		click(addStasiunPrinterBtn, "menekan tombol tambah printer");
		return new AddPrinterPage();
	}
	
	public PrinterPage scrolldown() {
		getDriver().manage().timeouts().implicitlyWait(TestUtils.WAITFORSWIPE, TimeUnit.SECONDS);
		scrollToElement("textContains", "Kitchen Display Order", "scrolldown di halaman printer");
		return this;
	}
	
	public PrinterPage switchOnKitchenOrder() {
		switchElement(switchKitchenOrder, TestUtils.ON, "Switch on kitchen order");
		return this;
	}
	
	public PrinterPage switchOffKitchenOrder() {
		switchElement(switchKitchenOrder, TestUtils.OFF, "Switch off kitchen order");
		return this;
	}
	
	public PrinterPage switchOnTableOrder() {
		switchElement(switchTableOrder, TestUtils.ON, "Switch on table order");
		return this;
	}
	
	public PrinterPage switchOffTableOrder() {
		switchElement(switchTableOrder, TestUtils.OFF, "Switch off table order");
		return this;
	}
	
	public PrinterPage switchOnKDO() {
		switchElement(switchKDO, TestUtils.ON, "Switch on KDO");
		return this;
	}
	
	public PrinterPage switchOffKDO() {
		switchElement(switchKDO, TestUtils.OFF, "Switch off KDO");
		return this;
	}
	
	public PrinterPage pressTestPrinter() {
		click(testPrinterBtn, "Menekan tombol tes printer");
		return this;
	}
	
	public PrinterPage pressPopupConfirm() {
		click(confirmBtn, "Menekan tombol ok di popup");
		return this;
	}
	
	public String getPopupMsg() {
		return getText(popupMsg, "hasil cetak : ");
	}
	
	public PrinterPage pressTestPrintStasiun(String namaStasiun) {
		testStasiunBtn = (MobileElement) getDriver().findElement(By.xpath("//android.widget.TextView[@text = \""+namaStasiun+"\"]/following-sibling::android.widget.Button[@resource-id =\"id.dretail.mpos:id/btnTestPrinter\"]"));
		
		click(testStasiunBtn, "menekan tombol test print pada stasiun : "+namaStasiun);
		return this;
	}
	
	public OpsiDriverPrinterPage pressPilihPrinterBtn() {
		click(pilihPrinterBtn, "Menekan tombol pilih printer");
		return new OpsiDriverPrinterPage();
	}
	
	public boolean isChangePrinterVisible() {
		return checkVisiblityOfElement(changePrinterBtn, "mengecek apakah tombol ganti printer ada");
	}
	
	public boolean isKitchenStasiunVisible() {
		return checkVisiblityOfElement(foodStasiun, "stasiun printer food : ");
	}
	
	public PrinterPage pressCancelPopup() {
		click(popupCancelBtn, "menekan tombol cancel di popup");
		return this;
	}
	
	public PrinterPage pressHapusPrinterBtn() {
		click(popupHapusPrinterBtn, "Menekan tombol hapus printer");
		return this;
	}
	
	public PrinterPage pressFoodStasiunLbl() {
		click(foodStasiun,	"menekan food stasiun");
		return this;
	}
	
	public PrinterPage pressConfirmHapusPrinter() {
		click(popupConfirmHapusPrinterBtn, "Menekan konfirmasi hapus printer");
		return this;
	}
	
	
	public String getPopupHapusPrinterMsg() {
		
		PrinterPage printerPage = PageFactory.initElements(getDriver(), PrinterPage.class);
		
		MobileElement element = (MobileElement) getDriver().findElement(By.id("id.dretail.mpos:id/content_text"));
		return getText(element, "text pop up: ");
	}
	
	
	

}
