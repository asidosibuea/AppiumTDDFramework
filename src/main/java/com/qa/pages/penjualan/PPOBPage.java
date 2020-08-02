package com.qa.pages.penjualan;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.pages.setting.ProfilPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PPOBPage extends OrderCartPage{
	
	@AndroidFindBy(id = "id.dretail.mpos:id/balanceTotal")
	private MobileElement balanceTotalBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnNotif")
	private MobileElement notifBtn;
	
	@AndroidFindBy(id="id.dretail.mpos:id/txtSearchMenu")
	private MobileElement searchBox;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnFavoriteMenu")
	private MobileElement favoriteMenuBtn;
	
	@AndroidFindBy(xpath = "//*[@text = \"Pulsa\"]")
	private MobileElement bayarPulsa;
	
	@AndroidFindBy(xpath = "//*[@text = \"PLN\"]")
	private MobileElement bayarPLN;
	
	@AndroidFindBy(xpath = "//*[@text = \"BPJS Kesehatan\"]")
	private MobileElement bayarBPJSKesehatan;
	
	@AndroidFindBy(xpath = "//*[@text = \"Jasa Telekomunikasi\"]")
	private MobileElement bayarJasTel;
	
	@AndroidFindBy(xpath = "//*[@text = \"Kartu Halo\"]")
	private MobileElement bayarKartuHalo;
	
	@AndroidFindBy(xpath = "//*[@text = \"PDAM\"]")
	private MobileElement bayarPDAM;
	
	@AndroidFindBy(xpath = "//*[@text = \"TV Kabel\"]")
	private MobileElement bayarTVKabel;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/content_text")
	private MobileElement popupMsg;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/confirm_button")
	private MobileElement confirmPopupBtn;
	
	public PPOBPage() {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}
	
	public AllMenuPage pressBalanceTotalBtn() {
		click(balanceTotalBtn, "Kembali ke halaman all menu");
		return new AllMenuPage();
	}
	
	public PPOBPage pressBayarPulsa() {
		click(bayarPulsa, "Pilih menu pembayaran pulsa");
		return this;
	}
	
	public TopupPLNPage pressBayarPLN() {
		click(bayarPLN, "Pilih menu pembayaran PLN");
		return new TopupPLNPage();
	}
	
	public String getPopupMsg() {
		return getText(popupMsg, "pesan pop-up : ");
	}
	
	public PPOBPage pressConfirmPopup(String popupType) {
		click(confirmPopupBtn, "Press OK on " + popupType + " popup");
		return this;
	}
	
	
	public String getTotalSaldo() {
		return getText(balanceTotalBtn, "Total balance di halaman awal ppob");
	}
	
	

}
