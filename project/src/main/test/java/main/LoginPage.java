package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	

	WebDriver driver = null;
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(name="uid")
	WebElement username;

	@FindBy(name="password")
	WebElement password;

	@FindBy(name="btnLogin")
	WebElement login;



	public void enterrUsername(String uname)
	{
		username.sendKeys(uname);
	}

	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}

	public void clickLogin()
	{
		login.click();
	}
}