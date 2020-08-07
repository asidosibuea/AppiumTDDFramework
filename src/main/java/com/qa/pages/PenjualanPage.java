package com.qa.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.pages.penjualan.AllMenuPage;
import com.qa.pages.penjualan.OrderCartPage;
import com.qa.pages.popup.PopupBiayaKirim;
import com.qa.pages.popup.PopupItem;
import com.qa.pages.popup.PopupStatusOrder;
import com.qa.pages.popup.PopupTopping;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PenjualanPage extends BaseTest{
	
	@AndroidFindBy(id = "id.dretail.mpos:id/customerName")
	private MobileElement namaPelangganTxt;
	
	@AndroidFindBy(xpath = "//*[@resource-id = \"id.dretail.mpos:id/lblPrice\" and @text=\"30.000\"]")
	private MobileElement totMenu2;
	
	@AndroidFindBy(xpath = "//*[@resource-id = \"id.dretail.mpos:id/lblPrice\" and @text=\"24.000\"]")
	private MobileElement totMenu1;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.ImageView[2]")
	private MobileElement kategori1;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = \"Service Resto 7.50% (7,50%)\"]")
	private MobileElement lblService;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text = \"Pajak 7% (7%)\"]")
	private MobileElement lblTax;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.ImageView[2]")
	private MobileElement kategori2;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"Beverage\")]")
	private MobileElement resultKategori1;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"Food\")]")
	private MobileElement resultKategori2;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnAllMenu")
	private MobileElement allMenuBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/lblNote")
	private MobileElement lblNote;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/customerName")
	private MobileElement namaPelangganBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnShowOrder")
	private MobileElement btnShowOrder;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnOrder")
	private MobileElement btnOrder;

	@AndroidFindBy(id = "id.dretail.mpos:id/lblDiscountInfo")
	private MobileElement lblDiskon;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/lblDiscountInfo")
	private MobileElement lblDiskonOrder;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/lblDiscountValue")
	private MobileElement valDiskon;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/lblPrice")
	private MobileElement lblHarga;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"JUS MANGGA\")]")
	private MobileElement item1;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"BUBUR AYAM BIASA\")]")
	private MobileElement item2;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnOrderType")
	private MobileElement btnOrderType;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/rowDelivery")
	private MobileElement btnDelivery;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/lblRounding")
	private MobileElement lblRounding;

	
	public PenjualanPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}

	public SidebarPage showSidebar() {
		getDriver().manage().timeouts().implicitlyWait(TestUtils.WAITFORSWIPE, TimeUnit.SECONDS);
		swipingElement(namaPelangganTxt, "right", "on dashboard page");
		
		return new SidebarPage();
	}
		
	public String getNamaPelanggan() {
		return getText(namaPelangganTxt, "username is ");
		
	}
	
	public AllMenuPage pressAllMenuBtn() {
		click(allMenuBtn, "Press all menu");
		return new AllMenuPage();
	}
	
	public String resultAddKategori2() {
		return getText(resultKategori2, "kategori 2 adalah ");
	}
	
	public PenjualanPage pilihKategori1(){
		click(resultKategori1, "Pilih kategori " + getStrings().get("expected_kategori1_searched"));
		return this;
	}
	
	public PenjualanPage pilihKategori2(){
		click(resultKategori2, "Pilih kategori " + getStrings().get("expected_kategori2_searched"));
		return this;
	}
	
	public PenjualanPage pilihMenu1(){
		click(item1, "Pilih Menu " + getStrings().get("expected_menu1_searched"));
		return this;
	}
	
	public PenjualanPage pressBtnShowOrder(){
		click(btnShowOrder, "Press button show order");
		return this;
	}
	
	public DiskonBillPage pressLblDiskon(){
		click(lblDiskonOrder, "Press label Diskon");
		return new DiskonBillPage();
	}
	
	public String resultAddMenu1() {
		return getText(item1, "menu 1 adalah ");
	}
	
	public PopupTopping pilihMenu2(){
		click(item2, "Pilih Menu " + getStrings().get("expected_menu2_searched"));
		return new PopupTopping();
	}
	
	public String resultAddMenu2() {
		return getText(item2, "menu 2 adalah ");
	}
	
	public PopupItem TambahKeranjang1(){
		click(item1, "Tambah Keranjang " + getStrings().get("expected_menu1_searched"));
		return new PopupItem();
	}
	
	public PopupItem PilihKeranjang1(){
		click(item1, "Pilih Keranjang " + getStrings().get("expected_menu1_searched"));
		return new PopupItem();
	}

	public PopupTopping TambahKeranjang2(){
		click(item2, "Tambah Keranjang " + getStrings().get("expected_menu2_searched"));
		return new PopupTopping();
	}
	
	public PopupItem PilihKeranjang2(){
		click(item2, "Pilih Keranjang " + getStrings().get("expected_menu2_searched"));
		return new PopupItem();
	}
	
	public PenjualanPage totMenu1() {
		getText(totMenu1, "Total harga Jus Mangga adalah ");
		return this;
	}
	
	public PenjualanPage totHarga() {
		getText(btnOrder, "btnOrder ");
		return this;
	}
	
	public PenjualanPage totMenu2() {
		getText(totMenu2, "Total harga Bubur Ayam Biasa adalah " + totMenu2.getText());
		return this;
	}
	
	public PembayaranPage pressBtnOrder() {
		click(btnOrder, "Press button order");
		return new PembayaranPage();
	}
	
	public PenjualanPage labelDiskonPersen() {
		getText(lblDiskon, "Diskon sebesar ");
		return this;
	}
	
	public PenjualanPage valueDiskon() {
		getText(lblHarga, "diskon sebesar " + valDiskon.getText() + " dari ");
		return this;
	}

	public String getStatusService() {
		return getText(lblService, "Label pada service adalah: ");
	}	
	
	public String getStatusTax() {
		return getText(lblTax, "Label pada tax adalah: ");
	}
	
	public String getStatusDiskon() {
		return getText(lblDiskonOrder, "Label pada Diskon adalah: ");
	}
	
	public String getStatusNote() {
		return getText(lblNote, "Note pada PenjualanPage adalah: ");
	}
	
	public String getHarga() {
		return getText(lblHarga, "Harga pada PenjualanPage adalah ");
	}
	
	public String getDiskonNominal() {
		return getText(valDiskon, "Diskon pada PenjualanPage adalah ");
	}
	
	public String getDiskonPersen() {
		return getText(lblDiskon, "Diskon pada PenjualanPage adalah ");
	}
	
	public String getBtnOrder() {
		return getText(btnOrder, "btnOrder ");
	}
	
	public PopupStatusOrder pressbtnOrderType() {
		click(btnOrderType, "Press btn order type");
		return new PopupStatusOrder();
	}
	
	public String getStatusOrder() {
		return getText(btnOrderType, "Status order adalah ");
	}
	
	public PopupBiayaKirim pressbtnDelivery() {
		click(btnDelivery, "Press btn Biaya Kirim");
		return new PopupBiayaKirim();
	}
	
	public PenjualanPage totalHarga() {
		getText(btnOrder, "Total belanja adalah ");
		return this;
	}
	
	public PenjualanPage lableRounding() {
		getText(lblRounding, "Pembulatan sebesar ");
		return this;
	}
	
}
