package com.qa.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PpobPage extends BaseTest{
	public PpobPage() {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}

	TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "id.dretail.mpos:id/balanceTotal")
	private MobileElement balanceTotal;

	public AllmenuPage pressbalanceTotal() {
		click(balanceTotal, "Kembali Ke All Menu");
		return new AllmenuPage();
	}
//	PDAM
	@AndroidFindBy(xpath = "//*[contains(@text, \"PDAM\")]")
	private MobileElement beliPdamppob;


	public PpobPage pressbeliPdamppob() {
		click(beliPdamppob, "Pilih Beli PDAM PPOB");
		return this;
	}

//	Kartu Halo
	@AndroidFindBy(xpath = "//*[contains(@text, \"Kartu Halo\")]")
	private MobileElement beliHaloppob;


	public PpobPage pressbeliHaloppob() {
		click(beliHaloppob, "Pilih Beli Kartu Halo PPOB");
		return this;
	}
	
	@AndroidFindBy(id = "id.dretail.mpos:id/codeCard")
	private MobileElement codeCard;
	public String getcodeCard() {
		return getText(codeCard, "Kode Kartu : ");
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/reffNo")
	private MobileElement reffNo;
	public String getreffNo() {
		return getText(reffNo, "No. Reff : ");
	}
	
	@AndroidFindBy(id = "id.dretail.mpos:id/customerId")
	private MobileElement customerId;
	public String getcustomerId() {
		return getText(customerId, "Id Pelanggan : ");
	}
	
	@AndroidFindBy(id = "id.dretail.mpos:id/customerName")
	private MobileElement customerName;
	public String getcustomerName() {
		return getText(customerName, "Nama Pelanggan : ");
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/bill")
	private MobileElement bill;
	public String getbill() {
		return getText(bill, "Tagihan : ");
	}


	@AndroidFindBy(xpath = "//*[contains(@text, \"BPJS Kesehatan\")]")
	private MobileElement beliBpjsppob;


	public PpobPage pressbeliBpjsppob() {
		click(beliBpjsppob, "Pilih Beli BPJS Kesehatan PPOB");
		return this;
	}
	
	@AndroidFindBy(id = "id.dretail.mpos:id/txtBpjsNumber")
	private MobileElement txtBpjsNumber;
	
	public PpobPage inputtxtBpjsNumber(String bpjsnumber) {
		clear(txtBpjsNumber);
		sendKeys(txtBpjsNumber, bpjsnumber, "Enter bpjsnumber : "+bpjsnumber);
		return this;
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/spSelectPaymentAmount")
	private MobileElement spSelectPaymentAmount;
	
	public PpobPage pressspSelectPaymentAmount() {
		click(spSelectPaymentAmount, "Pilih Jumlah Bayar BPJS Kesehatan PPOB");
		return this;
	}
	
	@AndroidFindBy(id = "android:id/text1")
	private MobileElement text1;
	
	public void pilihBulan(String txt) {
		try {
			MobileElement opsiBulan = (MobileElement) getDriver().findElement(By.xpath("//*[@text=\""+txt+"\"]"));
			System.out.println(opsiBulan.toString());

			click(opsiBulan, "memilih opsi "+txt);
		} catch (Exception e) {
			System.out.println("element nya ga ketemu");
//			e.printStackTrace();
//			System.out.println(e.getCause());
			System.out.println(e.getMessage());	
		}
		
	}
	
	public void piliharea(String txt) {
		try {
			MobileElement opsiarea = (MobileElement) getDriver().findElement(By.xpath("//*[@text=\""+txt+"\"]"));
			System.out.println(opsiarea.toString());

			click(opsiarea, "memilih opsi "+txt);
		} catch (Exception e) {
			System.out.println("element nya ga ketemu");
//			e.printStackTrace();
//			System.out.println(e.getCause());
			System.out.println(e.getMessage());	
		}
		
	}
	
	@AndroidFindBy(id = "id.dretail.mpos:id/spSelectAreaPdam")
	private MobileElement spSelectAreaPdam;
	
	public PpobPage pressspSelectAreaPdam() {
		click(spSelectAreaPdam, "Pilih Area PDAM PPOB");
		return this;
	}
	
	
	public PpobPage getpilihAreaPdam(String area) {
		String cekarea = getText(text1, "area Pilihan Jumlah Bayar : ").trim();
		System.out.println("actual area : "+cekarea);
		String expectedarea = getStrings().get(area).trim();
		System.out.println("expected area : "+expectedarea);
		
		if (!cekarea.equalsIgnoreCase(expectedarea)) {
			
			click(spSelectAreaPdam,"Pilih area :"+expectedarea);
			scrollToElement("textContains", expectedarea, "Scroll ke : "+expectedarea);
			piliharea(expectedarea);
			return this;
		}
		return this;
	}


	public PpobPage getpilihJumlahbayar(String bulan) {
		String cekbulan = getText(text1, "Bulan Pilihan Jumlah Bayar : ").trim();
		System.out.println("actual bulan : "+cekbulan);
		String expectedbulan = getStrings().get(bulan).trim();
		System.out.println("expected bulan : "+expectedbulan);
		
		if (!cekbulan.equalsIgnoreCase(expectedbulan)) {
			
			click(spSelectPaymentAmount,"Pilih Bulan :"+expectedbulan);
			scrollToElement("textContains", expectedbulan, "Scroll ke : "+expectedbulan);
			pilihBulan(expectedbulan);
			return this;
		}
		return this;
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/branchCode")
	private MobileElement branchCode;
	public String getbranchCode() {
		return getText(branchCode, "Detail branchCode : ");
	}
	@AndroidFindBy(id = "id.dretail.mpos:id/dateTime")
	private MobileElement dateTime;
	public String getdateTime() {
		return getText(dateTime, "Detail dateTime : ");
	}
	@AndroidFindBy(id = "id.dretail.mpos:id/noVa")
	private MobileElement noVa;
	public String getnoVa() {
		return getText(noVa, "Detail noVa : ");
	}
	@AndroidFindBy(id = "id.dretail.mpos:id/name")
	private MobileElement name;
	public String getname() {
		return getText(name, "Detail name : ");
	}
	@AndroidFindBy(id = "id.dretail.mpos:id/participant")
	private MobileElement participant;
	public String getparticipant() {
		return getText(participant, "Detail participant : ");
	}
	@AndroidFindBy(id = "id.dretail.mpos:id/period")
	private MobileElement period;
	public String getperiod() {
		return getText(period, "Detail period : ");
	}
	@AndroidFindBy(id = "id.dretail.mpos:id/amount")
	private MobileElement amount;
	public String getamount() {
		return getText(amount, "Detail amount : ");
	}
	@AndroidFindBy(id = "id.dretail.mpos:id/adminCost")
	private MobileElement adminCost;
	public String getadminCost() {
		return getText(adminCost, "Detail adminCost : ");
	}
	@AndroidFindBy(id = "id.dretail.mpos:id/paymentTotal")
	private MobileElement paymentTotal;
	public String getpaymentTotal() {
		return getText(paymentTotal, "Detail paymentTotal : ");
	}



	@AndroidFindBy(xpath = "//*[contains(@text, \"Pulsa\")]")
	private MobileElement beliPulsappob;


	public PpobPage pressbeliPulsappob() {
		click(beliPulsappob, "Pilih Beli Pulsa PPOB");
		return this;
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/numberPhone")
	private MobileElement inputnumberPhone;

	public PpobPage inputPhone(String phonenumber) {
		clear(inputnumberPhone);
		sendKeys(inputnumberPhone, phonenumber, "Enter phonenumber : "+phonenumber);
		return this;
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/btnProcess")
	private MobileElement prosesPpob;

	public PpobPage pressprosesPpob() {
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		click(prosesPpob, "Press Process Button");
		return this;

	}

	@AndroidFindBy(id = "id.dretail.mpos:id/btnClose")
	private MobileElement closePpob;

	public PpobPage pressclosePpob() {
		click(closePpob, "Close Menu Pulsa PPOB");
		return this;

	}

	public SidebarPage showSidebar() {
		getDriver().manage().timeouts().implicitlyWait(TestUtils.WAITFORSWIPE, TimeUnit.SECONDS);
		swipingElement(null, "right", "sidebar page");

		return new SidebarPage();
	}


	@AndroidFindBy(id = "id.dretail.mpos:id/btnBack")
	private MobileElement backPpob;


	public PpobPage pressbackPpob() {
		click(backPpob, "Press Back Button");
		return this;

	}


	@AndroidFindBy(xpath = "//*[@text = \"5.000\"]")
	private MobileElement denom5Ribu;

	public PpobPage pilihDenom5ribu() {
		click(denom5Ribu, "Pilih Denom 5 Ribu PPOB");
		return this;

	}

	@AndroidFindBy(xpath = "//*[@text = \"10.000\"]")
	private MobileElement denom10Ribu;

	public PpobPage pilihDenom10ribu() {
		click(denom10Ribu, "Pilih Denom 10 Ribu PPOB");
		return this;

	}

	@AndroidFindBy(xpath = "//*[@text = \"20.000\"]")
	private MobileElement denom20Ribu;

	public PpobPage pilihDenom20ribu() {
		click(denom20Ribu, "Pilih Denom 20 Ribu PPOB");
		return this;

	}

	@AndroidFindBy(xpath = "//*[@text = \"25.000\"]")
	private MobileElement denom25Ribu;

	public PpobPage pilihDenom25ribu() {
		click(denom25Ribu, "Pilih Denom 25 Ribu PPOB");
		return this;

	}

	@AndroidFindBy(xpath = "//*[@text = \"50.000\"]")
	private MobileElement denom50Ribu;

	public PpobPage pilihDenom50ribu() {
		click(denom50Ribu, "Pilih Denom 50 Ribu PPOB");
		return this;

	}

	@AndroidFindBy(xpath = "//*[@text = \"100.000\"]")
	private MobileElement denom100Ribu;

	public PpobPage pilihDenom100ribu() {
		click(denom100Ribu, "Pilih Denom 100 Ribu PPOB");
		return this;

	}

	@AndroidFindBy(xpath = "//*[@text = \"150.000\"]")
	private MobileElement denom150Ribu;

	public PpobPage pilihDenom150ribu() {
		click(denom150Ribu, "Pilih Denom 150 Ribu PPOB");
		return this;

	}

	@AndroidFindBy(xpath = "//*[@text = \"200.000\"]")
	private MobileElement denom200Ribu;

	public PpobPage pilihDenom200ribu() {
		click(denom200Ribu, "Pilih Denom 200 Ribu PPOB");
		return this;

	}

	@AndroidFindBy(xpath = "//*[@text = \"300.000\"]")
	private MobileElement denom300Ribu;

	public PpobPage pilihDenom300ribu() {
		click(denom300Ribu, "Pilih Denom 300 Ribu PPOB");
		return this;

	}

	@AndroidFindBy(xpath = "//*[@text = \"500.000\"]")
	private MobileElement denom500Ribu;

	public PpobPage pilihDenom500ribu() {
		click(denom500Ribu, "Pilih Denom 500 Ribu PPOB");
		return this;

	}

	@AndroidFindBy(xpath = "//*[@text = \"5.000.000\"]")
	private MobileElement denom5jt;

	public PpobPage pilihDenom5Jt() {
		click(denom5jt, "Pilih Denom 5 Juta PPOB");
		return this;

	}

	@AndroidFindBy(xpath = "//*[@text = \"1.000.000\"]")
	private MobileElement denom1Juta;

	public PpobPage pilihDenom1juta() {
		click(denom1Juta, "Pilih Denom 1 Juta PPOB");
		return this;

	}

	@AndroidFindBy(xpath = "//*[@text = \"10.000.000\"]")
	private MobileElement denom10jt;

	public PpobPage pilihDenom10Jt() {
		click(denom10jt, "Pilih Denom 10 Juta PPOB");
		return this;

	}


	@AndroidFindBy(id = "id.dretail.mpos:id/btnConfirm")
	private MobileElement btnConfirmppob;

	public PpobPage pressbtnConfirmppob() {
		click(btnConfirmppob, "Press Konfrimasi PPOB");
		return this;

	}


	@AndroidFindBy(id = "id.dretail.mpos:id/phoneNumber")
	private MobileElement detailphoneNumber;

	public String getdetailphoneNumber() {
		return getText(detailphoneNumber, "Detail Number : ");
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/pulsa")
	private MobileElement detaildenomPulsa;

	public String getdetaildenomPulsa() {
		return getText(detaildenomPulsa, "Detail Denom : ");
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/total")
	private MobileElement detailTotal;

	public String getdetailtotalPulsa() {
		return getText(detailTotal, "Detail Total Bayar : ");
	}

	// PLN
	@AndroidFindBy(xpath = "//*[contains(@text, \"PLN\")]")
	private MobileElement beliPlnppob;

	public PpobPage pressbeliPlnppob() {
		click(beliPlnppob, "Pilih Beli PLN PPOB");
		return this;
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/electricNumber")
	private MobileElement electricNumber;

	public PpobPage inputelectricNumber(String idPel) {
		clear(electricNumber);
		sendKeys(electricNumber, idPel, "Enter Id Pelanggan : "+idPel);
		return this;
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/prepaid")
	private MobileElement prepaid;
	public PpobPage pressbeliPlnprepaid() {
		click(prepaid, "Pilih Beli PLN Prepaid");
		return this;
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/postpaid")
	private MobileElement postpaid;
	public PpobPage pressbeliPlnpostpaid() {
		click(postpaid, "Pilih Beli PLN Postpaid");
		return this;
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/nontaglis")
	private MobileElement nontaglis;
	public PpobPage pressbeliPlnnontaglis() {
		click(nontaglis, "Pilih Beli PLN Nontaglis");
		return this;
	}


	@AndroidFindBy(id = "id.dretail.mpos:id/nama")
	private MobileElement nama;

	public String getdetailnama() {
		return getText(nama, "Detail Nama : ");
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/electricBill")
	private MobileElement electricBill;

	public String getdetailelectricBill() {
		return getText(electricBill, "Detail Tagihan PLN Postpaid : ");
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/electricNumber")
	private MobileElement konfirmelectricNumber;

	public String getdetailkonfirmelectricNumber() {
		return getText(konfirmelectricNumber, "Detail Id Pelanggan : ");
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/electric")
	private MobileElement electric;

	public String getdetailelectric() {
		return getText(electric, "Detail Nominal PLN : ");
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/total")
	private MobileElement konfirmtotal;

	public String getdetailkonfirmtotal() {
		return getText(konfirmtotal, "Detail Total Bayar : ");
	}


	@AndroidFindBy(id = "id.dretail.mpos:id/lblTitle")
	private MobileElement lblTitle;

	public String getlblTitle() {
		return getText(lblTitle, "Label Title : ");
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/content_text")
	private MobileElement content_text;

	public String getcontentText() {
		return getText(content_text, "Keterangan : ");
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/confirm_button")
	private MobileElement confirm_button;

	public PpobPage pressconfirmButton() {
		click(confirm_button, "Press Confirm Button");
		return this;
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/btnFavoriteMenu")
	private MobileElement btnFavoriteMenu;

	public PenjualanPage pressbtnFavoriteMenu() {
		click(btnFavoriteMenu, "Press Btn Menu");
		return new PenjualanPage();
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/lblPrice")
	private MobileElement lblPrice;

	public String getlblPrice() {
		return getText(lblPrice, "Harga Tercantum di Cart : ");
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/lblName")
	private MobileElement lblName;

	public String getlblName() {
		return getText(lblName, "Nama Item Tercantum di Cart : ");
	}
	@AndroidFindBy(id = "id.dretail.mpos:id/lblQty")
	private MobileElement lblQty;
	
	public String getlblQty() {
		return getText(lblQty, "Qty Item Tercantum di Cart : ");
	}
	
	@AndroidFindBy(id = "id.dretail.mpos:id/lblQuantity")
	private MobileElement lblQuantity;
	
	public String getlblQuantity() {
		return getText(lblQuantity, "Jumlah Qty Order : ");
	}

	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnShowOrder")
	private MobileElement btnShowOrder;
	
	public PpobPage pressbtnShowOrder() {
		click(btnShowOrder, "Press Btn Show Order");
		return this;
	}
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnHideOrder")
	private MobileElement btnHideOrder;
	
	public PpobPage pressbtnHideOrder() {
		click(btnHideOrder, "Press Btn Hide Order");
		return this;
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/lblPpob")
	private MobileElement lblPpob;
	
	public String getlblPpob() {
		return getText(lblPpob, "Jumlah Subotal PPOB : ");
	}

	@AndroidFindBy(id = "id.dretail.mpos:id/btnOrder")
	private MobileElement btnOrder;
	
	public String getbtnOrder() {
		return getText(btnOrder, "Jumlah Total Order : ");
	}
	
	public PembayaranPage pressbtnOrder() {
		click(btnOrder, "Press Tombol Order");
		return new PembayaranPage();
	}

	// Telkom
		@AndroidFindBy(xpath = "//*[contains(@text, \"Telekomunikasi\")]")
		private MobileElement beliTelkomppob;

		public PpobPage pressbeliTelkomppob() {
			click(beliTelkomppob, "Pilih Beli Telkom PPOB");
			return this;
		}
		
		@AndroidFindBy(id = "id.dretail.mpos:id/txtCustomerId")
		private MobileElement txtCustomerId;
		
		public PpobPage inputtxtCustomerId(String custId) {
			clear(txtCustomerId);
			sendKeys(txtCustomerId, custId, "Enter Customer ID : "+custId);
			return this;
		}
		
		@AndroidFindBy(id = "id.dretail.mpos:id/noJasTel")
		private MobileElement noJasTel;
		public String getnoJasTel() {
			return getText(noJasTel, "No. Jastel : ");
		}
		@AndroidFindBy(id = "id.dretail.mpos:id/telephone")
		private MobileElement telephone;
		public String gettelephone() {
			return getText(telephone, "Telepon : ");
		}
		@AndroidFindBy(id = "id.dretail.mpos:id/divreDatel")
		private MobileElement divreDatel;
		public String getdivreDatel() {
			return getText(divreDatel, "Divre/Datel : ");
		}		
		@AndroidFindBy(id = "id.dretail.mpos:id/noReffPeriod1")
		private MobileElement noReffPeriod1;
		public String getnoReffPeriod1() {
			return getText(noReffPeriod1, "No. Reff Periode 1 : ");
		}
		@AndroidFindBy(id = "id.dretail.mpos:id/noReffPeriod2")
		private MobileElement noReffPeriod2;
		public String getnoReffPeriod2() {
			return getText(noReffPeriod2, "No. Reff Periode 2 : ");
		}
		@AndroidFindBy(id = "id.dretail.mpos:id/noReffPeriod3")
		private MobileElement noReffPeriod3;
		public String getnoReffPeriod3() {
			return getText(noReffPeriod3, "No. Reff Periode 3 : ");
		}
		@AndroidFindBy(id = "id.dretail.mpos:id/period1")
		private MobileElement period1;
		public String getperiod1() {
			return getText(period1, "Tagihan Periode 1 : ");
		}
		@AndroidFindBy(id = "id.dretail.mpos:id/period2")
		private MobileElement period2;
		public String getperiod2() {
			return getText(period2, "Tagihan Periode 2 : ");
		}
		@AndroidFindBy(id = "id.dretail.mpos:id/period3")
		private MobileElement period3;
		public String getperiod3() {
			return getText(period3, "Tagihan Periode 3 : ");
		}



		


}
