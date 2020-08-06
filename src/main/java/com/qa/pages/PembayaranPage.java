package com.qa.pages;


import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import com.qa.pages.popup.PopupItem;
import com.qa.pages.popup.PopupJlhUangTunai;
import com.qa.pages.popup.PopupNotifikasiPembayaran;

public class PembayaranPage extends BaseTest{
	public PembayaranPage() {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}

	TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "id.dretail.mpos:id/lblTitle")
	private MobileElement lblTitle;

	public String getlblTitle() {
		return getText(lblTitle, "Keterangan Pembayaran : ");
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/lblPay")
	private MobileElement lblPay;

	public String getlblPay() {
		return getText(lblPay, "Total Pembayaran : ");
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/txtCashAmount")
	private MobileElement txtCashAmount;
	
	public String gettxtCashAmount() {
		return getText(txtCashAmount, "Pilihan Uang Tunai : ");
	}

	public PembayaranPage inputtxtCashAmount(String cashAmount ) {
		clear(txtCashAmount);
		sendKeys(txtCashAmount, cashAmount , "Jumlah Uang Tunai : "+cashAmount );
		return this;
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/lblChange")
	private MobileElement lblChange;

	public String getlblChange() {
		return getText(lblChange, "Total Kembalian : ");
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/btnOk")
	private MobileElement btnOk;

	public PpobPage pressbtnOkppob() {
		click(btnOk,"Press Button OK");
		return new PpobPage();
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/lblMethod")
	private MobileElement lblMethod;

	public String getlblMethod() {
		return getText(lblMethod, "Metode Pembayaran : ");
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/lblTotal")
	private MobileElement lblTotal;

	public String getlblTotal() {
		return getText(lblTotal, "Total	Nominal Order : ");
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/btnRedeem")
	private MobileElement btnRedeem;

	@AndroidFindBy(id = "id.dretail.mpos:id/btnClose")
	private MobileElement btnClosepembayaran;

	@AndroidFindBy(id = "id.dretail.mpos:id/btnCash")
	private MobileElement btnCash;

	@AndroidFindBy(id = "id.dretail.mpos:id/btnEdcDebit")
	private MobileElement btnEdcDebit;

	@AndroidFindBy(id = "id.dretail.mpos:id/btnEdcCredit")
	private MobileElement btnEdcCredit;

	@AndroidFindBy(id = "id.dretail.mpos:id/btnOther")
	private MobileElement btnOtherpembayaran;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.Button[1]")
	private MobileElement pilihPecahansatu;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.Button[2]")
	private MobileElement pilihPecahandua;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.Button[3]")
	private MobileElement pilihPecahantiga;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.Button[4]")
	private MobileElement pilihPecahanempat;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout/android.widget.TableRow/android.widget.Button[5]")
	private MobileElement pilihPecahanlima;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TableLayout[1]/android.widget.TableRow/android.widget.Button")
	private MobileElement pilihNone;

	@AndroidFindBy(id = "id.dretail.mpos:id/txtCustomerAccountNo")
	private MobileElement txtCustomerAccountNo;

	@AndroidFindBy(id = "id.dretail.mpos:id/txtBankName")
	private MobileElement txtBankName;

	@AndroidFindBy(id = "id.dretail.mpos:id/txtApprovalCode")
	private MobileElement txtApprovalCode;

	@AndroidFindBy(id = "id.dretail.mpos:id/txtCustomerPhoneCash")
	private MobileElement txtCustomerPhoneCash;

	@AndroidFindBy(id = "id.dretail.mpos:id/txtCustomerNameCash")
	private MobileElement txtCustomerNameCash;

	@AndroidFindBy(id = "id.dretail.mpos:id/txtCustomerEmail")
	private MobileElement txtCustomerEmail;

	@AndroidFindBy(id = "id.dretail.mpos:id/txtCustomerPhone")
	private MobileElement txtCustomerPhone;

	@AndroidFindBy(id = "id.dretail.mpos:id/txtCustomerName")
	private MobileElement txtCustomerName;

	@AndroidFindBy(id = "id.dretail.mpos:id/txtCustomerEmailCash")
	private MobileElement txtCustomerEmailCash;

	@AndroidFindBy(id = "id.dretail.mpos:id/btnOk")
	private MobileElement btnOkconfirmpembayaran;

	@AndroidFindBy(id = "id.dretail.mpos:id/btnPay")
	private MobileElement btnPay;

	@AndroidFindBy(id = "id.dretail.mpos:id/btnMultiPay")
	private MobileElement btnMultiPay;

	@AndroidFindBy(id = "id.dretail.mpos:id/swEdc")
	private MobileElement swEdc;

	@AndroidFindBy(id = "id.dretail.mpos:id/swEmailReceipt")
	private MobileElement swEmailReceipt;

	@AndroidFindBy(id = "id.dretail.mpos:id/swDoubleReceipt")
	private MobileElement swDoubleReceipt;

	@AndroidFindBy(id = "id.dretail.mpos:id/ip1")
	private MobileElement ip1;

	@AndroidFindBy(id = "id.dretail.mpos:id/ip2")
	private MobileElement ip2;

	@AndroidFindBy(id = "id.dretail.mpos:id/ip3")
	private MobileElement ip3;

	@AndroidFindBy(id = "id.dretail.mpos:id/ip4")
	private MobileElement ip4;

	@AndroidFindBy(id = "id.dretail.mpos:id/txtPort")
	private MobileElement txtPort;

	@AndroidFindBy(id = "id.dretail.mpos:id/btnOk")
	private MobileElement btnOkedc;

	public PembayaranPage inputIpedc1 (String txtip1) {
		clear(ip1);
		sendKeys(ip1, txtip1 , "Input Ip1: "+txtip1 );
		return this;
	}

	public PembayaranPage inputIpedc2 (String txtip2) {
		clear(ip2);
		sendKeys(ip2, txtip2 , "Input Ip2: "+txtip2 );
		return this;
	}

	public PembayaranPage inputIpedc3 (String txtip3) {
		clear(ip3);
		sendKeys(ip3, txtip3 , "Input Ip3: "+txtip3);
		return this;
	}

	public PembayaranPage inputIpedc4 (String txtip4) {
		clear(ip4);
		sendKeys(ip4, txtip4 , "Input Ip4: "+txtip4);
		return this;
	}

	public PembayaranPage inputPortedc (String portedc) {
		clear(txtPort);
		sendKeys(txtPort, portedc , "Input Ip4: "+portedc);
		return this;
	}

	public PembayaranPage pressbtnOkedc () {
		click(btnOkedc,"Konfirmasi IP dan Port EDC");
		return this;
	}

	public PembayaranPage presspilihNone () {
		click(pilihNone,"Konfirmasi Pilih Tombol None");
		return this;
	}

	public PembayaranPage inputtxtApprovalCode (String ApprovalCode ) {
		clear(txtApprovalCode);
		sendKeys(txtApprovalCode, ApprovalCode , "Input Approval Code: "+ApprovalCode );
		return this;
	}

	public PembayaranPage inputtxtCustomerAccountNo (String CustomerAccountNo ) {
		clear(txtCustomerAccountNo);
		sendKeys(txtCustomerAccountNo, CustomerAccountNo , "Input Nomor Kartu : "+CustomerAccountNo );
		return this;
	}

	public PembayaranPage inputtxtBankName (String BankName ) {
		clear(txtBankName);
		sendKeys(txtBankName, BankName , "Input Nama Bank: "+BankName );
		return this;
	}

	public PembayaranPage inputtxtCustomerNameCash (String CustomerNameCash ) {
		clear(txtCustomerNameCash);
		sendKeys(txtCustomerNameCash, CustomerNameCash , "Input Nama Pelanggan : "+CustomerNameCash );
		return this;
	}

	public PembayaranPage inputtxtCustomerPhoneCash(String CustomerPhoneCash) {
		clear(txtCustomerPhoneCash);
		sendKeys(txtCustomerPhoneCash, CustomerPhoneCash , "Input Telepone Pelanggan : "+CustomerPhoneCash);
		return this;
	}

	public PembayaranPage inputtxtCustomerEmailCash(String CustomerEmailCash) {
		clear(txtCustomerEmailCash);
		sendKeys(txtCustomerEmailCash, CustomerEmailCash , "Input Email Pelanggan : "+CustomerEmailCash);
		return this;
	}

	public PembayaranPage inputtxtCustomerName (String CustomerName) {
		clear(txtCustomerName);
		sendKeys(txtCustomerName, CustomerName, "Input Nama Pelanggan : "+CustomerName);
		return this;
	}

	public PembayaranPage inputtxtCustomerPhone(String CustomerPhone) {
		clear(txtCustomerPhone);
		sendKeys(txtCustomerPhone, CustomerPhone, "Input Telepone Pelanggan : "+CustomerPhone);
		return this;
	}

	public PembayaranPage inputtxtCustomerEmail(String CustomerEmail) {
		clear(txtCustomerEmail);
		sendKeys(txtCustomerEmail, CustomerEmail, "Input Email Pelanggan : "+CustomerEmail);
		return this;
	}

	public PembayaranPage pilihPecahansatu() {
		click(pilihPecahansatu,"Pilih Pecahan Satu");
		return this;
	}

	public PenjualanPage pressbtnOkconfirmpembayaran() {
		click(btnOkconfirmpembayaran,"Konfirmasi Pembayaran");
		return new PenjualanPage();
	}

	public PembayaranPage pilihPecahandua() {
		click(pilihPecahandua,"Pilih Pecahan Dua");
		return this;
	}

	public PembayaranPage pilihPecahantiga() {
		click(pilihPecahantiga,"Pilih Pecahan Tiga");
		return this;
	}

	public PembayaranPage pilihPecahanempat() {
		click(pilihPecahanempat,"Pilih Pecahan Empat");
		return this;
	}

	public PembayaranPage pilihPecahanlima() {
		click(pilihPecahanlima,"Pilih Pecahan Lima");
		return this;
	}

	public PembayaranPage pressbtnCash() {
		click(btnCash,"Pilih Pembayaran Tunai");
		return this;
	}

	public PembayaranPage pressbtnOtherpembayaran() {
		click(btnOtherpembayaran,"Pilih Pembayaran Lainnya");
		return this;
	}

	public PembayaranPage pressbtnEdcDebit() {
		click(btnEdcDebit,"Pilih Pembayaran Debit");
		return this;
	}

	public PembayaranPage pressbtnEdcCredit() {
		click(btnEdcCredit,"Pilih Pembayaran Kredit");
		return this;
	}

	public PembayaranPage pressswDoubleReceipt() {
		String cekresi = getText(swDoubleReceipt, "Status resi : ");
		String expectedcekresi = getStrings().get("expected_status_printer");
		if (cekresi.equals(expectedcekresi)) {
			click(swDoubleReceipt,"Pilih Cetak 2x");
		}
		return this;
	}

	public PembayaranPage pressswEmailReceipt() {
		String cekemail = getText(swEmailReceipt, "Status email : ");
		String expectedcekemail = getStrings().get("expected_status_email");
		if (cekemail.equals(expectedcekemail)) {
			click(swEmailReceipt,"Pilih Email Resi");
		}
		return this;
	}

	public PembayaranPage pressswEdc() {
		click(swEdc,"Aktifkan EDC");
		return this;
	}

	public PembayaranPage pressbtnPay() {
		click(btnPay,"Eksekusi Bayar");
		return this;
	}


	public PopupJlhUangTunai enterCash() {
		click(txtCashAmount, "Masukan Jumlah Uang Tunai");
		return new PopupJlhUangTunai();
	}
	
	public PopupItem PilihKeranjang2(){
		click(btnPay, "Pilih Keranjang " + getStrings().get("expected_menu2_searched"));
		return new PopupItem();
	}
	
	public PopupNotifikasiPembayaran pressBtnPay() {
		click(btnPay, "Press button pay");
		return new PopupNotifikasiPembayaran();
	}
	

}
