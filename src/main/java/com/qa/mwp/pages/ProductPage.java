package com.qa.mwp.pages;

import com.microsoft.playwright.Page;

public class ProductPage {
	private Page page;

	// 1. String Locators - OR
	private String labelerIcon = "//span[text()='LABELERS']";
	private String labeler = "//td[text()='A00002']";
	private String productIcon = "//a[@href='/products']";
	private String addProducts = "//button[text()='ADD PRODUCT(S)']";
	private String addSingleProduct = "//a[text()='SINGLE PRODUCT']";
	private String products = "//h3[text()='Products']";
	
	// 2. page constructor:
	public ProductPage(Page page) {
		this.page = page;
	}
	
	// 3. page actions/methods:
	public String addsingleProduct() {
		page.click(labelerIcon);
		page.click(labeler);
		page.isVisible(productIcon);
		page.dblclick(productIcon);
		String Product = page.textContent(products);
		page.click(addProducts);
		page.click(addSingleProduct);
		
		return Product;
	}

}
