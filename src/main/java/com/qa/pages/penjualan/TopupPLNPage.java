package com.qa.pages.penjualan;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TopupPLNPage extends BaseTest{
	
	@AndroidFindBy(id = "id.dretail.mpos:id/balanceTotal")
	private MobileElement totalSaldo;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/electricNumber")
	private MobileElement idpelangganTxtField;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/prepaid")
	private MobileElement opsiPrabayar;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/postpaid")
	private MobileElement opsiPascabayar;

	@AndroidFindBy(id = "id.dretail.mpos:id/nontaglis")
	private MobileElement opsiNonTaglis;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnProcess")
	private MobileElement prosesOrderBtn;

	public TopupPLNPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}
	
	
	public TopupPLNPage selectOpsiPrabayar() {
		click(opsiPrabayar, "Pilih opsi prabayar");
		return this;
	}
	
	public TopupPLNPage selectOpsiPascabayar() {
		click(opsiPascabayar, "Pilih opsi pasca bayar");
		return this;
	}
	
	public TopupPLNPage selectOpsiNonTaglisr() {
		click(opsiPascabayar, "Pilih opsi non taglis");
		return this;
	}
	
	public TopupPLNPage enterIdPelanggan(String idPelanggan) {
		sendKeys(idpelangganTxtField, idPelanggan, "Input id pelanggan : "+idPelanggan);
		return this;
	}
	
	public PLNDenomPage pressProsesOrderBtn()
	{
		click(prosesOrderBtn, "Tekan tombol proses order");
		return new PLNDenomPage();
	}
	
	public CheckoutPLN nonTaglisPressOrderBtn()
	{
		click(prosesOrderBtn, "Tekan tombol proses order");
		return new CheckoutPLN();
	}
	
	public CheckoutPLN postPaidPressOrderBtn()
	{
		click(prosesOrderBtn, "Tekan tombol proses order");
		return new CheckoutPLN();
	}
	
	public String getTotalSaldo() {
		return getText(totalSaldo, "Total saldo : ");
	}
	
	

}
