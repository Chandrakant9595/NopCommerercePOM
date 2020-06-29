package com.nc.qa.testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nc.qa.base.TestBase;
import com.nc.qa.pages.CustomersListPage;
import com.nc.qa.pages.DashboardPage;
import com.nc.qa.pages.EditCustomerPage;
import com.nc.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class DeleteCustomerPageTest extends TestBase{

	LoginPage loginPage;
	DashboardPage dashboardPage;
	CustomersListPage customersListPage;
	EditCustomerPage editCustomerPage;
	
	public DeleteCustomerPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	@Severity(SeverityLevel.BLOCKER)
	@Description("Pre-conditions")
	public void setUp() throws IOException {
		initalization();
		loginPage = new LoginPage();
		dashboardPage = loginPage.verifyLoginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		customersListPage = dashboardPage.clickOnSubCustomersLink();
		editCustomerPage = customersListPage.clickOnEditButtonForUpdatedCustomer();
	}
	
	@AfterMethod
	@Severity(SeverityLevel.BLOCKER)
	@Description("Post-conditions")
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1, description = "Delete the Customer details")
	@Severity(SeverityLevel.NORMAL)
	@Description("Post-conditions")
	public void deleteCustomerDetails() throws IOException {
		customersListPage = editCustomerPage.verifyDeleteCustomerDetails();
		String successMessge = customersListPage.getSuccessMessage();
		System.out.println("Original: " +successMessge);
	}
}
