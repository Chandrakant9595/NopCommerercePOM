package com.nc.qa.testCases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nc.qa.base.TestBase;
import com.nc.qa.pages.CustomersListPage;
import com.nc.qa.pages.DashboardPage;
import com.nc.qa.pages.EditCustomerPage;
import com.nc.qa.pages.LoginPage;
import com.nc.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class EditCustomerPageTest extends TestBase{

	LoginPage loginPage;
	DashboardPage dashboardPage;
	CustomersListPage customersListPage;
	EditCustomerPage editCustomerPage;
	
	String sheetName = "EditCustomerData";
	
	public EditCustomerPageTest() throws IOException {
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
		editCustomerPage = customersListPage.clickOnEditButton();
	}
	
	@AfterMethod
	@Severity(SeverityLevel.BLOCKER)
	@Description("Post-conditions")
	public void tearDown() {
		driver.quit();
	}
	
	@Test(priority = 1, description = "Verify the Edit customer page Title")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test for Validate the Edit customer Page Title")
	public void verifyEditCustomerPageTitleTest() {
		String title = editCustomerPage.verifyEditCustomerPageTitle();
		Assert.assertEquals(title, "Edit customer details / nopCommerce administration", "Title of edit page is wrong");
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() throws InvalidFormatException {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 2, description = "Verify the Edit Customer Test", dataProvider="getDataFromExcel")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test for Validate the Edit customer details Test")
	public void editCustomerDetailsTest(String company) throws IOException {
		customersListPage = editCustomerPage.verifyEditCustomerDetails(company);
		TestUtil.scrollPage();
		String companyName = customersListPage.getCompanyName();
		Assert.assertEquals(companyName, company);
	}
}