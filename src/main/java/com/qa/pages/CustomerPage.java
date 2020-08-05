package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CustomerPage extends BaseTest{
	
	public CustomerPage() {
		super();
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}

	TestUtils utils = new TestUtils();
	
	@AndroidFindBy(id = "id.dretail.mpos:id/lbl")
	private MobileElement lblName;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnClose")
	private MobileElement btnClose;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/searchItem")
	private MobileElement searchItem;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/searchImage")
	private MobileElement searchImage;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnAdd")
	private MobileElement btnAddmember;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/spFilter")
	private MobileElement btnfilterAddmember;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/content_text")
	private MobileElement noresultAddmember;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/confirm_button")
	private MobileElement confirmnoresultAddmember;


	

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[1]")
	private MobileElement btnfilternameAddmember;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[2]")
	private MobileElement btnfiltertlpAddmember;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[3]")
	private MobileElement btnfilteremailAddmember;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[4]")
	private MobileElement btnfilterfreeidAddmember;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]")
	private MobileElement hasilnameMember;
	
	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[2]")
	private MobileElement hasiltlpMember;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/confirm_button")
	private MobileElement btnconfirmemailAddmember;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[1]")
	private MobileElement hasilfreeidMember;

	
	public PenjualanPage pressbtnClose() {
		click(btnClose, "Close Customer Page");
		return new PenjualanPage();
	}
	
	public AddmemberPage pressbtnAddmember() {
		click(btnAddmember, "Add Customer Page");
		return new AddmemberPage();
	}
	
	public CustomerPage enterSearchmember(String member) {
		clear(searchItem);
		sendKeys(searchItem, member, "Enter username : "+member);
		return this;
	}
	
	public CustomerPage pressconfirmnoresultAddmember() {
		click(confirmnoresultAddmember, "Confirm No Result");
		return this;
	}
	
	public CustomerPage pressbtnconfirmemailAddmember() {
		click(btnconfirmemailAddmember, "Confirm Hasil Customer By Email Ada");
		return this;
	}
	
	public CustomerPage pressCustomerImage() {
		click(searchImage, "Search Member");
		return this;
	}
	
	public CustomerPage pressbtnfilterAddmember() {
		click(btnfilterAddmember, "Filter Search Member");
		return this;
	}
	
	public CustomerPage pressbtnfiltertlpAddmember() {
		click(btnfiltertlpAddmember, "Filter Search Member By Phone Number");
		return this;
	}
	
	public CustomerPage pressbtnfilteremailAddmember() {
		click(btnfilteremailAddmember, "Filter Search Member By Email");
		return this;
	}
	
	public CustomerPage pressbtnfilterfreeidAddmember() {
		click(btnfilterfreeidAddmember, "Filter Search Member By Free ID");
		return this;
	}
	
	public CustomerPage pressbtnfilternameAddmember() {
		click(btnfilternameAddmember, "Filter Search Member By Name");
		return this;
	}
	
	public String getHasilnameMemberText() {
		return getText(hasilnameMember, "Nama customer adalah ");
	}
	
	public String getHasiltlpMemberText() {
		return getText(hasiltlpMember, "Telp customer adalah ");
	}
	
	public String getHasilfreeidMemberText() {
		return getText(hasilfreeidMember, "Free ID adalah ");
	}
	
	public String getHasilnoresultText() {
		return getText(noresultAddmember, "Return No Result adalah ");
	}
	
	public PenjualanPage pressExamplemember() {
		click(hasilnameMember, "Click Example Customer By Name ");
		return new PenjualanPage();
	}

}
