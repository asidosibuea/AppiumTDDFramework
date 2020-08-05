package com.qa.pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.base.SidebarPage;
import com.qa.pages.penjualan.AllMenuPage;
import com.qa.pages.penjualan.OrderCartPage;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PenjualanPage extends BaseTest{
	
	@AndroidFindBy(id = "id.dretail.mpos:id/customerName")
	private MobileElement namaPelangganTxt;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnAllMenu")
	private MobileElement allMenuBtn;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/customerName")
	private MobileElement customerName;
	@AndroidFindBy(id = "id.dretail.mpos:id/btnOrderType")
	private MobileElement btnOrderType;
	@AndroidFindBy(id = "id.dretail.mpos:id/btnOrderTakeAway")
	private MobileElement btnOrderTakeAway;
	@AndroidFindBy(id = "id.dretail.mpos:id/btnOrderDineIn")
	private MobileElement btnOrderDineIn;
	@AndroidFindBy(id = "id.dretail.mpos:id/btnOrderMore")
	private MobileElement btnOrderMore;
	@AndroidFindBy(id = "id.dretail.mpos:id/content_text")
	private MobileElement confrimMoreorder;
	@AndroidFindBy(id = "id.dretail.mpos:id/confirm_button")
	private MobileElement btnconfrimMoreorder;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.ImageView")
	private MobileElement contohMenusatu;
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.FrameLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.ImageView")
	private MobileElement contohMenudua;
	
	@AndroidFindBy(xpath = "//*[contains(@text, \"TOTAL\")]")
	private MobileElement btnTotal;
	public AllmenuPage pressbtnAllMenu() {
		click(allMenuBtn,"Masuk Page All Menu");
		return new AllmenuPage();
	}
	public PembayaranPage pressbtnTotal() {
		click(btnTotal,"Klik Bayar");
		return new PembayaranPage();
	}
	public PenjualanPage beliMenusatu() {
		click(contohMenusatu,"Beli Menu Satu");
		return this;
	}
	
	public PenjualanPage beliMenudua() {
		click(contohMenudua,"Beli Menu Dua");
		return this;
	}
	public CustomerPage pressCustomerName() {
		click(customerName, "Press Customer Name");
		return new CustomerPage();
	}
	public PenjualanPage pressbtnOrderDineIn() {
		click(btnOrderDineIn, "Press Type Pesanan Dine In");
		return this;
	}
	public PenjualanPage pressbtnconfrimMoreorder() {
		click(btnconfrimMoreorder, "Press Confirm Type Pesanan Lainnya");
		return this;
	}
	public PenjualanPage pressbtnOrderMore() {
		click(btnOrderMore, "Press Type Pesanan Lainnya");
		return this;
	}
	public PenjualanPage pressbtnOrderTakeAway() {
		click(btnOrderTakeAway, "Press Type Pesanan Take Away");
		return this;
	}
	public PenjualanPage pressbtnOrderType() {
		click(btnOrderType, "Press Type Pesanan");
		return this;
	}
	public SidebarPage swipeToSidebar() {
		swipingElement(customerName, "right","On Dashboard Page");
		return new SidebarPage();
	}
	public String getHasilcustomernameText() {
		return getText(customerName, "Customer Name adalah ");
	}
	public String getHasilbtnOrderType() {
		return getText(btnOrderType, "Type Pesanan adalah ");
	}
	public String getHasilconfrimMoreorder() {
		return getText(confrimMoreorder, "Confirm Pesanan Lainnya");
	}
	
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
	
	

}
