package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseTest;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AddmemberPage extends BaseTest{
	
	public AddmemberPage() {
		super();
		PageFactory.initElements(new AppiumFieldDecorator(this.getDriver(), Duration.ofSeconds(TestUtils.WAIT)), this);
	}

	TestUtils utils = new TestUtils();
	
	@AndroidFindBy(id = "id.dretail.mpos:id/id")
	private MobileElement inputIdmember;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/name")
	private MobileElement inputNamemember;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/phoneNumber")
	private MobileElement inputPhonemember;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/email")
	private MobileElement inputEmailmember;

	@AndroidFindBy(id = "id.dretail.mpos:id/idNumber")
	private MobileElement inputIdnumbermember;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/birthDate")
	private MobileElement inputBirthmember;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/address")
	private MobileElement inputAddressmember;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/male")
	private MobileElement pilihMalemember;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/female")
	private MobileElement pilihFemalemember;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnCreateNewCustomer")
	private MobileElement btnCreatenewcustomer;
	
	@AndroidFindBy(id = "android:id/button1")
	private MobileElement btnOkcreatenewcustomer;
	
	@AndroidFindBy(id = "android:id/button2")
	private MobileElement btnBatalcreatenewcustomer;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/confirm_button")
	private MobileElement btnConfirmcreatenewcustomer;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/lblTitle")
	private MobileElement btnBackcreatenewcustomer;
	

	public AddmemberPage idMember(String idmember) {
		clear(inputIdmember);
		sendKeys(inputIdmember, idmember, "Input ID Member : "+idmember);
		return this;
	}
	
	public AddmemberPage namaMember(String namamember) {
		clear(inputNamemember);
		sendKeys(inputNamemember, namamember, "Input Nama Member : "+namamember);
		return this;
	}
	
	public AddmemberPage tlpMember(String tlpmember) {
		clear(inputPhonemember);
		sendKeys(inputPhonemember, tlpmember, "Input Telephone Member : "+tlpmember);
		return this;
	}
	
	public AddmemberPage emailMember(String emailmember) {
		clear(inputEmailmember);
		sendKeys(inputEmailmember, emailmember, "Input Email Member : "+emailmember);
		return this;
	}
	
	public AddmemberPage idnumberMember(String idnumbermember) {
		clear(inputIdnumbermember);
		sendKeys(inputIdnumbermember, idnumbermember, "Input Telephone Member : "+idnumbermember);
		return this;
	}
	
	public AddmemberPage pressbtnPilihmale() {
		click(pilihMalemember, "Pilih Male Member");
		return this;
	}
	
	public AddmemberPage pressbtnPilihfemale() {
		click(pilihFemalemember, "Pilih Female Member");
		return this;
	}
	
	public AddmemberPage birthMember(String birthmember) {
		clear(inputBirthmember);
		sendKeys(inputBirthmember, birthmember, "Input Birth Date Member : "+birthmember);
		return this;
	}
	
	public AddmemberPage addressMember(String addressmember) {
		clear(inputAddressmember);
		sendKeys(inputAddressmember, addressmember, "Input Address Member : "+addressmember);
		return this;
	}
	
	public AddmemberPage pressbtnCreatenewcustomer() {
		click(btnCreatenewcustomer, "Click Add Customer");
		return this;
	}
	
	public CustomerPage pressbtnConfirmcreatenewcustomer() {
		click(btnConfirmcreatenewcustomer, "Confirm Add Customer Page");
		return new CustomerPage();
	}
	
	public CustomerPage pressbtnBackcreatenewcustomer() {
		click(btnBackcreatenewcustomer, "Back To Customer Page");
		return new CustomerPage();
	}
	
	


	

}
