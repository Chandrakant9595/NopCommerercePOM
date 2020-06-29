package com.nc.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nc.qa.base.TestBase;
import com.nc.qa.util.TestUtil;

import io.qameta.allure.Step;

public class CreateCustomerRolesPage extends TestBase{

	@FindBy(xpath = "//input[@Name='Name']")
	WebElement nameTxt;
	
	@FindBy(xpath = "//input[@name='FreeShipping' and @id='FreeShipping']")
	WebElement freeShippingChk;
	
	@FindBy(xpath = "//input[@name='TaxExempt' and @id='TaxExempt']")
	WebElement taxExemptChk;
	
	@FindBy(xpath = "//button[@type='submit' and @class='btn btn-primary']")
	WebElement chooseProductButton;
	
	@FindBy(xpath = "//td[text()='Apple iCam']/parent::tr/td[@class=' button-column']/button[text()='Select']")
	WebElement selectAppleICamButton;
	
	@FindBy(xpath = "//input[@id='SystemName']")
	WebElement systemNameTxt;
	
	@FindBy(xpath = "//button[@name='save']")
	WebElement saveButton;
	
	public CreateCustomerRolesPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@Step("Test step for get the URL of create custome roles page")
	public String verifyCreateCustomerRolesPageURL() {
		return driver.getCurrentUrl();
	}
	
	@Step("Test step for get the Title of create custome roles page")
	public String verifyCreateCustomerRolesPageTitle() {
		return driver.getTitle();
	}
	
	@Step("Test for Add the Customer role")
	public CustomerRolesListPage verifyCreateCustomerRole() throws IOException, InterruptedException {
		nameTxt.sendKeys("Product-1");
		freeShippingChk.click();
		taxExemptChk.click();
		
		chooseProductButton.click();
		TestUtil.switchToChildWindow();
		selectAppleICamButton.click();
		
		TestUtil.switchToParentWindow();
		
		TestUtil.waitForWebElementPresent(systemNameTxt);
		
		systemNameTxt.sendKeys("System-1");
		saveButton.click();
		
		return new CustomerRolesListPage();
	}
}
