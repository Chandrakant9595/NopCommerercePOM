package com.nc.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nc.qa.base.TestBase;

import io.qameta.allure.Step;

public class LoginPage extends TestBase{

	@FindBy(css = "input[id='Email']")
	WebElement emailTxt;
	
	@FindBy(css = "input[id='Password']")
	WebElement passwordlTxt;
	
	@FindBy(css = "input[type='submit']")
	WebElement loginButton;
	
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}

	@Step("Test step for validate Login Page URL")
	public String verifyLoginPageURL() {
		return driver.getCurrentUrl();
	}

	@Step("Test step for validate Login Page Title")
	public String verifyLoginPageTitle() {
		return driver.getTitle();
	}
	
	@Step("Test step for validate Login functionality")
	public DashboardPage verifyLoginFunctionality(String un, String pas) throws IOException {
		emailTxt.clear();
		emailTxt.sendKeys(un);
		passwordlTxt.clear();
		passwordlTxt.sendKeys(pas);
		loginButton.click();
		return new DashboardPage();
	}
}