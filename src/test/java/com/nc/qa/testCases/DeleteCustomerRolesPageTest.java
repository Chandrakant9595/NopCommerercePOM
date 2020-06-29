package com.nc.qa.testCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nc.qa.base.TestBase;
import com.nc.qa.pages.CustomerRolesListPage;
import com.nc.qa.pages.DashboardPage;
import com.nc.qa.pages.EditCustomerRolesPage;
import com.nc.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class DeleteCustomerRolesPageTest extends TestBase{

	LoginPage loginPage;
	DashboardPage dashboardPage;
	CustomerRolesListPage customerRolesListPage;
	EditCustomerRolesPage editCustomerRolesPage;

	
	public DeleteCustomerRolesPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initalization();
		loginPage = new LoginPage();
		dashboardPage = loginPage.verifyLoginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		customerRolesListPage = dashboardPage.clickOnCustomerRolesLink();
		editCustomerRolesPage = customerRolesListPage.clickOnEditProduct2Button();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1, description = "Delete the Customer role")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test for delete theCustomer role")
	public void deleteTheCustomerRoleTest() throws IOException {
		customerRolesListPage = editCustomerRolesPage.verifyDeleteTheCustomerRoles();
	}
}




