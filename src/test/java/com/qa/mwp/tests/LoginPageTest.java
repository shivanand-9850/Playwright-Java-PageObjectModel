package com.qa.mwp.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.mwp.base.BaseTest;
import com.qa.mwp.constants.AppConstants;

public class LoginPageTest extends BaseTest {

	@Test  (priority = 1)
	public void loginPageNavigationTest() {
		loginPage = labelerPage.navigateToLoginPage();
		String actLoginPageTitle = loginPage.getLoginPageTitle();
		System.out.println("page act title: " + actLoginPageTitle);
		Assert.assertEquals(actLoginPageTitle, AppConstants.LOGIN_PAGE_TITLE);
	}

	@Test    (priority = 2)
	public void appLoginTest() {
		Assert.assertTrue(loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim()));
	}

}
