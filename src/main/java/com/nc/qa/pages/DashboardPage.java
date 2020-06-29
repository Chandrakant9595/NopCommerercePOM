package com.nc.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nc.qa.base.TestBase;

import io.qameta.allure.Step;

public class DashboardPage extends TestBase{

	@FindBy(xpath = "//ul[@class='sidebar-menu tree']/li[4]/a/span[text()='Customers']")
	WebElement customersLink;
	
	@FindBy(xpath = "//a[@class='menu-item-link']/span[text()='Customers']")
	WebElement subCustomersLink;
	
	@FindBy(xpath = "//span[text()='Customer roles']")
	WebElement customerRolesLink;
	
	public DashboardPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@Step("Test step for click on Sub-customers link")
	public CustomersListPage clickOnSubCustomersLink() throws IOException {
		customersLink.click();
		subCustomersLink.click();
		return new CustomersListPage();
	}
	
	@Step("Test step for click on Customer Roles link")
	public CustomerRolesListPage clickOnCustomerRolesLink() throws IOException {
		customersLink.click();
		customerRolesLink.click();
		return new CustomerRolesListPage();
	}
}


