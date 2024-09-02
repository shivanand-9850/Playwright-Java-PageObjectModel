package com.qa.mwp.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.mwp.base.BaseTest;
import com.qa.mwp.constants.AppConstants;

public class LabelerPageTest extends BaseTest {

	@Test
	public void homePageTitleTest() {
		String actualTitle = labelerPage.getHomePageTitle();
		Assert.assertEquals(actualTitle, AppConstants.HOME_PAGE_TITLE);
	}

	@Test
	public void homePageURLTest() {
		String actualURL = labelerPage.getHomePageURL();
		Assert.assertEquals(actualURL, AppConstants.LOGIN_PAGE_URL);
	}

	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
				{ "Macbook" }, 
				{ "iMac" }, 
				{ "Samsung" }
		};
	}

//	@Test(dataProvider = "getProductData")
//	public void searchTest(String productName) throws InterruptedException {
//		Thread.sleep(5000);
//		String actualSearchHeader = labelerPage.doSearch(productName);
//		Assert.assertEquals(actualSearchHeader, "Search - " + productName);
//	}

}
