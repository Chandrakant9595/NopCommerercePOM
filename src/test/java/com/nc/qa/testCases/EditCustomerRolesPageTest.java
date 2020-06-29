package com.nc.qa.testCases;

import java.io.IOException;

import org.testng.Assert;
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

public class EditCustomerRolesPageTest extends TestBase{

	LoginPage loginPage;
	DashboardPage dashboardPage;
	CustomerRolesListPage customerRolesListPage;
	EditCustomerRolesPage editCustomerRolesPage;
	
	public EditCustomerRolesPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		initalization();
		loginPage = new LoginPage();
		dashboardPage = loginPage.verifyLoginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
		customerRolesListPage = dashboardPage.clickOnCustomerRolesLink();
		editCustomerRolesPage =  customerRolesListPage.clickOnEditProduct1Button();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1, description = "Test for verify the URL of edit customer roles page")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test for verify the URL of edit customer roles page")
	public void verifyTheEditCustomerRolesPageTitleTest() {
		String title = editCustomerRolesPage.verifyEditCustomerRolesPageTitle();
		Assert.assertEquals(title, "Edit customer role details / nopCommerce administration");
	}
	
	@Test(priority = 2, description = "Test for verify the edit customer roles")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test for verify the edit customer roles")
	public void verifyEditCustomerRolesTest() throws IOException {
		customerRolesListPage = editCustomerRolesPage.verifyEditTheCustomerRoles();
		String roleName = customerRolesListPage.verifyRoleName2();
		Assert.assertEquals(roleName, "Product-2");
	}
}
