package com.nc.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nc.qa.base.TestBase;

import io.qameta.allure.Step;

public class CustomerRolesListPage extends TestBase{


	@FindBy(xpath = "//a[@class='btn bg-blue']")
	WebElement addNewButton;

	@FindBy(xpath = "//td[text()='Product-1']")
	WebElement roleName1;
	
	@FindBy(xpath = "//td[text()='Product-2']")
	WebElement roleName2;
	
	@FindBy(xpath = "//td[text()='Product-1']/parent::tr/td[@class=' button-column']/a[text()='Edit']")
	WebElement editProduct1Button;
	
	@FindBy(xpath = "//td[text()='Product-2']/parent::tr/td[@class=' button-column']/a[text()='Edit']")
	WebElement editProduct2Button;
	
	public CustomerRolesListPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@Step("Test step for click on Add new button on Customers list page")
	public CreateCustomerRolesPage clickOnAddNewButton() throws IOException {
		addNewButton.click();
		return new CreateCustomerRolesPage();
	}
	
	@Step("Test step for get the role name-1")
	public String verifyRoleName1() {
		return roleName1.getText();
	}
	
	@Step("Test step for get the role name-2")
	public String verifyRoleName2() {
		return roleName2.getText();
	}
	
	@Step("Test step for click on edit button of Product-1")
	public EditCustomerRolesPage clickOnEditProduct1Button() throws IOException {
		editProduct1Button.click();
		return new EditCustomerRolesPage();
	}
	
	@Step("Test step for click on edit button of Product-2")
	public EditCustomerRolesPage clickOnEditProduct2Button() throws IOException {
		editProduct2Button.click();
		return new EditCustomerRolesPage();
	}
}

