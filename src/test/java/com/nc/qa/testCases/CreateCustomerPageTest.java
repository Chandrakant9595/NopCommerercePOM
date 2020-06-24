package com.nc.qa.testCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nc.qa.base.TestBase;
import com.nc.qa.pages.CreateCustomerPage;
import com.nc.qa.pages.CustomersListPage;
import com.nc.qa.pages.DashboardPage;
import com.nc.qa.pages.LoginPage;
import com.nc.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class CreateCustomerPageTest extends TestBase{

	LoginPage loginPage;
	DashboardPage dashboardPage;
	CustomersListPage customersListPage;
	CreateCustomerPage createCustomerPage;
	
	String sheetName = "CustomerData";
	
	public CreateCustomerPageTest() throws IOException {
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
		createCustomerPage = customersListPage.clickOnAddNewButton();
	}
	
	@AfterMethod
	@Severity(SeverityLevel.BLOCKER)
	@Description("Post-conditions")
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1, description = "Verify the Add new customer URL")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test for Validate the Add new customer Page URL")
	public void verifyAddNewCustomerPageURL() {
		String url = createCustomerPage.verifyAddNewCustomerPageURL();
		Assert.assertEquals(url, "https://admin-demo.nopcommerce.com/Admin/Customer/Create", "Add new Customer page URL is not correct");
	}
	
	@Test(priority = 2, description = "Verify the Add new customer Title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test for Validate the Add new customer Page Title")
	public void verifyAddNewCustomerPageTitle() {
		String title = createCustomerPage.verifyAddNewCustomerPageTitle();
		Assert.assertEquals(title, "Add a new customer / nopCommerce administration", "Add new Customer page Title is not correct");
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() throws InvalidFormatException {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 3, description = "Verify the Add New Customer Test", dataProvider="getDataFromExcel")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test for Validate the Add new customer Page Title")
	public void verifyAddNewCustomer(String pas, String fn, String ln, String da, String co) throws IOException {
		customersListPage = createCustomerPage.addNewCustomer(pas, fn, ln, da, co);
		TestUtil.scrollPage();
		String companyName = customersListPage.getCompanyName();
		Assert.assertEquals(companyName, co);
	}
}