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
	
	public CustomersListPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@Step("Test step for click on Add new button")
	public CreateCustomerPage clickOnAddNewButton() throws IOException {
		addNewButton.click();
		return new CreateCustomerPage();
	}
	
	public String getCompanyName() {
		return companyName.getText();
	}
}