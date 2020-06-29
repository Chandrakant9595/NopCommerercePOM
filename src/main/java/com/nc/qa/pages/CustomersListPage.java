package com.nc.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nc.qa.base.TestBase;

import io.qameta.allure.Step;

public class CustomersListPage extends TestBase{
	
	@FindBy(xpath = "//a[@class='btn bg-blue']")
	WebElement addNewButton;

	@FindBy(xpath = "//td[text()='Registered']/following-sibling::td[1]")
	WebElement companyName;
	
	@FindBy(xpath = "//td[text()='IBM']/following-sibling::td[4]/a")
	WebElement editButton;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
	WebElement successMessage;
	
	@FindBy(xpath = "//td[text()='HP']/following-sibling::td[4]/a")
	WebElement editButtonForDeleteUpdateCustomer;
	
	public CustomersListPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@Step("Test step for click on Add new button")
	public CreateCustomerPage clickOnAddNewButton() throws IOException {
		addNewButton.click();
		return new CreateCustomerPage();
	}
	
	@Step("Test step for get company name")
	public String getCompanyName() {
		return companyName.getText();
	}
	
	@Step("Test step for Edit button")
	public EditCustomerPage clickOnEditButton() throws IOException {
		editButton.click();
		return new EditCustomerPage();
	}
	
	@Step("Test step for get success message")
	public String getSuccessMessage() {
		return successMessage.getText();
	}
	
	@Step("Test step for Edit button")
	public EditCustomerPage clickOnEditButtonForUpdatedCustomer() throws IOException {
		editButtonForDeleteUpdateCustomer.click();
		return new EditCustomerPage();
	}
}