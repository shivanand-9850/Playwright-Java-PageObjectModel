package com.qa.mwp.pages;

import com.microsoft.playwright.Page;

public class UserPage {

	private Page page;
	// 1. String Locators - OR
	private String labelerIcon = "//span[text()='LABELERS']";
	private String labeler = "//td[text()='A00002']";
	private String usersIcon = "//span[text()='USERS']";
	private String addUser = "//button[@class='btn btn-sm btn-secondary ']";
	private String users = "//h3[text()='Users']";

	// 2. page constructor:
	public UserPage(Page page) {
		this.page = page;
	}
	
	// 3. page actions/methods:
	public String addUser() {
		page.click(labelerIcon);
		page.click(labeler);
		page.isVisible(usersIcon);
		page.dblclick(usersIcon);
		String Usre = page.textContent(users);  
		page.click(addUser);
		return Usre;
	}

}
