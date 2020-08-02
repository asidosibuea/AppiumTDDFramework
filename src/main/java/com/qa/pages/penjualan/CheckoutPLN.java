package com.qa.pages.penjualan;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutPLN extends BaseTest{
	
	@AndroidFindBy(id = "id.dretail.mpos:id/nama")
	private MobileElement namaPelanggan;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/electricNumber")
	private MobileElement idPelanggan;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/electricBill")
	private MobileElement tagihanListrik;
	
	@AndroidFindBy(id = "iid.dretail.mpos:id/total")
	private MobileElement totalHarga;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnConfirm")
	private MobileElement confirmBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/balanceTotal")
	private MobileElement totalSaldo;

	public CheckoutPLN() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}
	
	public String getNamaPelanggan() {
		return getText(namaPelanggan, "nama pelanggan : ");
	}
	
	
	public String getIdPelanggan() {
		return getText(idPelanggan, "ID pelanggan : ");
	}
	
	public String getTagihanListrik() {
		return getText(tagihanListrik, "Tagihan listrik : ");
	}
	
	public String getTotalHarga() {
		return getText(totalHarga, "Total harga : ");
	}
	
	public String getTotalSaldo() {
		return getText(totalSaldo, "Saldo : ");
	}
	
	public PPOBPage pressConfirmBtn() {
		click(confirmBtn, "Tekan tombol konfirmasi");
		return new PPOBPage();
	}
	
	public CheckoutPLN pressSaldo() {
		click(totalSaldo, "Menekan total saldo");
		return this;
	}

}
