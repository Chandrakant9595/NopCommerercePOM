package com.nc.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nc.qa.base.TestBase;

import io.qameta.allure.Step;

public class EditCustomerPage extends TestBase{

	@FindBy(xpath = "//input[@id='Company']")
	WebElement companyTxt;
	
	@FindBy(xpath = "//button[@name='save']")
	WebElement saveButton;
	
	@FindBy(xpath = "//span[@id='customer-delete']")
	WebElement deleteButton;
	
	@FindBy(xpath = "//button[@type='submit' and @class='btn bg-red pull-right']")
	WebElement deleteButtonFromPopup;
	
	public EditCustomerPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@Step("Step for verify the Edit Customer Page Title")
	public String verifyEditCustomerPageTitle() {
		return driver.getTitle();
	}	
	
	@Step("Step for verify the Edit Customer company name")
	public CustomersListPage verifyEditCustomerDetails(String cName) throws IOException {
		companyTxt.clear();
		companyTxt.sendKeys(cName);
		saveButton.click();
		return new CustomersListPage();
	}
	
	@Step("Step for verify the Delete Customer")
	public CustomersListPage verifyDeleteCustomerDetails() throws IOException {
		deleteButton.click();
		deleteButtonFromPopup.click();
		return new CustomersListPage();
	}
}
