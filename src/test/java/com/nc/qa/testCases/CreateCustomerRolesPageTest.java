package com.nc.qa.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nc.qa.base.TestBase;
import com.nc.qa.pages.CreateCustomerRolesPage;
import com.nc.qa.pages.CustomerRolesListPage;
import com.nc.qa.pages.DashboardPage;
import com.nc.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class CreateCustomerRolesPageTest extends TestBase{

	LoginPage loginPage;
	DashboardPage dashboardPage;
	CustomerRolesListPage customerRolesListPage;
	CreateCustomerRolesPage createCustomerRolesPage;
	
	public CreateCustomerRolesPageTest() throws IOException {
		super();
	}
	
	@BeforeMethod
	@Severity(SeverityLevel.BLOCKER)
	@Description("Pre-conditions")
	public void setUp() throws IOException {
		initalization();
		loginPage = new LoginPage();
		dashboardPage = loginPage.verifyLoginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		customerRolesListPage = dashboardPage.clickOnCustomerRolesLink();
		createCustomerRolesPage = customerRolesListPage.clickOnAddNewButton();
	}
	
	@AfterMethod
	@Severity(SeverityLevel.BLOCKER)
	@Description("Post-conditions")
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1, description = "Verify URL of create customer roles page")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test for Validate the Add customer roles Page URL")
	public void verifyCreateCustomerRolespageURLTest() {
		String url = createCustomerRolesPage.verifyCreateCustomerRolesPageURL();
		Assert.assertEquals(url, "https://admin-demo.nopcommerce.com/Admin/CustomerRole/Create");
	}
	
	@Test(priority = 2, description = "Verify Title of create customer roles page")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test for Validate the Add customer roles Page Title")
	public void verifyTheAddCustomerRolesPageTitleTest() {
		String title =createCustomerRolesPage.verifyCreateCustomerRolesPageTitle();
		Assert.assertEquals(title, "Add a new customer role / nopCommerce administration");
	}

	@Test(priority = 3, description = "Verify the Add customer role function")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test for verify Add customer roles functionality")
	public void verifyTheAddCustomerRolesTest() throws IOException, InterruptedException {
		customerRolesListPage = createCustomerRolesPage.verifyCreateCustomerRole();
		String roleName = customerRolesListPage.verifyRoleName1();
		Assert.assertEquals(roleName, "Product-1");
	}
}
	
