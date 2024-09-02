package com.qa.mwp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.mwp.base.BaseTest;
import com.qa.mwp.constants.AppConstants;

public class ProductPageTest extends BaseTest {
	@Test(priority = 1)
	public void AddSingleProductTest() {
		userPage = labelerPage.navigateToUserPage();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		userPage.addUser();
		String actUserPageTitle = userPage.addUser();
		System.out.println("page act title: " + actUserPageTitle);
		Assert.assertEquals(actUserPageTitle, AppConstants.LOGIN_PAGE_TITLE);
	}

}
