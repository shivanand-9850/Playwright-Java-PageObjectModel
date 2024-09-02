package com.qa.mwp.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

	private Page page;

	// 1. String Locators - OR
	private String emailId = "//input[@name='identifier']";
	private String password = "//input[@name='credentials.passcode']";
	private String loginBtn = "//a[text()='LOGIN']";
	private String nextButton = "//button[text()='Next']";
	private String verifyButton = "//button[text()='Verify']";
	private String PageHeader = "//h3[text()='Labelers']";
	private String labelerPage = "//span[text()='LABELERS']";
	private String title = "//h2[text()='Sign In']";
	// 2. page constructor:
	public LoginPage(Page page) {
		this.page = page;
	}
	
	// 3. page actions/methods:
	public String getLoginPageTitle() {
		String tit = page.textContent(title);
		System.out.println(tit);
		return tit;
	}
	
	public boolean isForgotPwdLinkExist() {
		return page.isVisible(loginBtn);
	}
	
	public boolean doLogin(String appUserName, String appPassword) {
		System.out.println("App creds: " + appUserName + ":" + appPassword);
//		page.click(loginBtn);
		page.fill(emailId, appUserName);
		page.click(nextButton);
		page.fill(password, appPassword);
		page.click(verifyButton);
		page.click(labelerPage);
		page.locator(PageHeader).waitFor();
		if(page.locator(PageHeader).isVisible()) {
			System.out.println("user is logged in successfully....");
			return true;
		}else {
			System.out.println("user is not logged in successfully....");
			return false;
		}
	}
}
