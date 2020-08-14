package com.qa.pages;

import java.util.List;

import com.qa.base.BaseTest;
import com.qa.utils.TestUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MemberPage extends BaseTest{
	TestUtils utils = new TestUtils();

	@AndroidFindBy(id = "id.dretail.mpos:id/searchItem")
	private MobileElement searchMemberFld;

	@AndroidFindBy(id = "id.dretail.mpos:id/searchImage")
	private MobileElement searchBtnMember;

	@AndroidFindBy(id = "id.dretail.mpos:id/name")
	private MobileElement listMemberSch;
	
	@AndroidFindBy(id = "id.dretail.mpos:id/btnClose")
	private MobileElement closeBtnSearchMember;
	
	
	public MemberPage enterNameMember(String memberName) {
		clear(searchMemberFld);
		sendKeys(searchMemberFld, memberName, "Enter member : "+memberName);
		return this;
	}

	public MemberPage pressSearchBtn() {
		click(searchBtnMember, "Press Search Button Member");
		return this;
	}
	
	public PenjualanPage pressCloseBtn() {
		click(closeBtnSearchMember, "Press close Button search Member");
		return new PenjualanPage();
	}
	
	public MemberPage resultSearchMember() {
		getText(listMemberSch, "Hasil pencarian member adalah: ");
		return this;
	}

	public MemberPage listMember() {
		String name = listMemberSch.getText();
		System.out.println(name);
		return this;

	}
}
