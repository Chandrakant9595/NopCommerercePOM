package com.nc.qa.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nc.qa.base.TestBase;
import com.nc.qa.pages.DashboardPage;
import com.nc.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	public LoginPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	@Severity(SeverityLevel.BLOCKER)
	@Description("Pre-conditions")
	public void setUp() throws IOException {
		initalization();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	@Severity(SeverityLevel.BLOCKER)
	@Description("Post-conditions")
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1, description = "Validate the Login page URL")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test for Validate the Login Page URL")
	public void validateTheLoginPageURL() {
		String url = loginPage.verifyLoginPageURL();
		Assert.assertEquals(url, "https://admin-demo.nopcommerce.com/login", "Login page URL is incorrect");
	}
	
	@Test(priority = 2, description = "Validate the Login page Title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test for Validate the Login Page Title")
	public void validateTheLoginPageTitle() {
		String title = loginPage.verifyLoginPageTitle();
		Assert.assertEquals(title, "Your store. Login", "Login page Title is incorrect");
	}
	
	@Test(priority = 3, description = "Validate the Login functionality")
	@Severity(SeverityLevel.BLOCKER)
	@Description("Test for Validate the Login functionality")
	public void validateTheLoginFunctionality() throws IOException {
		dashboardPage = loginPage.verifyLoginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
	}
}
