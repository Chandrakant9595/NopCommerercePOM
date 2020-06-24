package com.nc.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nc.qa.base.TestBase;
import com.nc.qa.util.TestUtil;

import io.qameta.allure.Step;

public class CreateCustomerPage extends TestBase{
		
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailTxt;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement passwordTxt;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement firstNameTxt;
	
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement lastNameTxt;
	
	@FindBy(xpath = "//input[@id='Gender_Male']")
	WebElement genderOptionButton;
	
	@FindBy(xpath = "//input[@id='DateOfBirth']")
	WebElement dateOfBirthTxt;
	
	@FindBy(xpath = "//input[@id='Company']")
	WebElement companyTxt;
	
	@FindBy(xpath = "//button[@name='save']")
	WebElement saveButton;
	
	public CreateCustomerPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@Step("Test step for Validate the Add new customer page URL")
	public String verifyAddNewCustomerPageURL() {
		return driver.getCurrentUrl();
	}
	
	@Step("Test step for Validate the Add new customer page Title")
	public String verifyAddNewCustomerPageTitle() {
		return driver.getTitle();
	}
	
	@Step("Test step for add new Customer data")
	public CustomersListPage addNewCustomer(String pass, String fname, String lName, String dob, String comp) throws IOException {
		String date = TestUtil.getCurrectDate();
		String email = date+"@gmail.com";
		emailTxt.sendKeys(email);
		passwordTxt.sendKeys(pass);
		firstNameTxt.sendKeys(fname);
		lastNameTxt.sendKeys(lName);
		genderOptionButton.click();
		dateOfBirthTxt.sendKeys(dob);
		companyTxt.sendKeys(comp);
		saveButton.click();
		return new CustomersListPage();
	}
}