package com.qa.mwp.pages;

import com.microsoft.playwright.Page;

public class LabelerPage {

	private Page page;

	// 1. String Locators - OR
	private String search = "input[name='search']";
	private String searchIcon = "div#search button";
	private String searchPageHeader = "div#content h1";
	private String loginLink = "a:text('Login')";
	private String myAccountLink = "a[title='My Account']";
	private String title ="//h3[text()='Labelers']";
	private String loginBtn = "//a[text()='LOGIN']";

	// 2. page constructor:
	public LabelerPage(Page page) {
		this.page = page;
	}

	// 3. page actions/methods:
	public String getHomePageTitle() {
		page.click(title);
		String tit = page.textContent(title);
		System.out.println("page title: "+ tit);
		return tit;
	}

	public String getHomePageURL() {
		String url =  page.url();
		System.out.println("page url : " + url);
		return url;
	}

//	public String doSearch(String productName) {
//		page.fill(search, productName);
//		page.click(searchIcon);
//		String header =  page.textContent(searchPageHeader);
//		System.out.println("search header: " + header);
//		return header;
//	}
	
	public LoginPage navigateToLoginPage() {
		page.click(loginBtn);
		return new LoginPage(page);
	}

	public ProductPage navigateToProductPage1() {
		//page.click(loginBtn);
		return new ProductPage(page);
	}
	public UserPage navigateToUserPage() {
		//page.click(loginBtn);
		return new UserPage(page);
	}
}
