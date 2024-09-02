package com.qa.mwp.base;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.microsoft.playwright.Page;
import com.qa.mwp.constants.AppConstants;
import com.qa.mwp.factory.PlaywrightFactory;
import com.qa.mwp.pages.LabelerPage;
import com.qa.mwp.pages.LoginPage;
import com.qa.mwp.pages.ProductPage;
import com.qa.mwp.pages.UserPage;
import com.qa.mwp.tests.LoginPageTest;

public class BaseTest {

	PlaywrightFactory pf;
	Page page;
	protected Properties prop;
	protected LabelerPage labelerPage;
	protected LoginPageTest loginPageTest;
	protected LoginPage loginPage;
	protected ProductPage productPage;
	protected UserPage userPage;

	@Parameters({ "browser" })
	@BeforeTest
	public void setup(String browserName) {
		pf = new PlaywrightFactory();

		prop = pf.init_prop();

		if (browserName != null) {
			prop.setProperty("browser", browserName);
		}

		page = pf.initBrowser(prop);
		labelerPage = new LabelerPage(page);
		loginPage = labelerPage.navigateToLoginPage();
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());

	}

	@AfterTest
	public void tearDown() {
		page.context().browser().close();
	}

}
