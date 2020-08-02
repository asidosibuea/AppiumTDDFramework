package com.qa.pages;

import com.qa.base.BaseTest;

public class IntroScreenPage extends BaseTest{
	
	
	public LoginPage swipeToLogin() {
		swipingElement(null,"left", "intro screen page");
		swipingElement(null,"left", "intro screen page");
		swipingElement(null,"left", "intro screen page");
		return new LoginPage();
	}

	public IntroScreenPage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
