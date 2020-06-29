package com.nc.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nc.qa.base.TestBase;

import io.qameta.allure.Step;

public class EditCustomerRolesPage extends TestBase{

	@FindBy(xpath = "//input[@name='Name']")
	WebElement nameTxt;
	
	@FindBy(xpath = "//input[@name='SystemName']")
	WebElement systemTxt;
	
	@FindBy(xpath = "//input[@id='OverrideTaxDisplayType']")
	WebElement overrrideChk;
	
	@FindBy(xpath = "//input[@id='EnablePasswordLifetime']")
	WebElement passwordLifetimeChk;
	
	@FindBy(xpath = "//button[@name='save']")
	WebElement saveButton;
	
	@FindBy(xpath = "//span[@id='customerrole-delete']")
	WebElement deleteButton;
	
	@FindBy(xpath = "//button[@class='btn bg-red pull-right']")
	WebElement deleteButtonInPopup;
	
	public EditCustomerRolesPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@Step("Test step for get the Title of Edit customer roles page")
	public String verifyEditCustomerRolesPageTitle() {
		return driver.getTitle();
	}
	
	@Step("Test step for Edit customer roles")
	public CustomerRolesListPage verifyEditTheCustomerRoles() throws IOException {
		nameTxt.clear();
		nameTxt.sendKeys("Product-2");
		systemTxt.clear();
		systemTxt.sendKeys("System-2");
		overrrideChk.click();
		passwordLifetimeChk.click();
		saveButton.click();
		return new CustomerRolesListPage();
	}
	
	@Step("Test step for Delete customer roles")
	public CustomerRolesListPage verifyDeleteTheCustomerRoles() throws IOException {
		deleteButton.click();
		deleteButtonInPopup.click();
		return new CustomerRolesListPage();
	}
}