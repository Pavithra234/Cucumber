package com.adactin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public static WebDriver driver;
	@FindBy(id="username")
	private WebElement username;
		public static WebDriver getDriver() {
		return driver;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}

		@FindBy(id="password")
	private WebElement password;
	
		@FindBy(id="login")
		private WebElement login;
		
		
		public HomePage(WebDriver idriver) {
			this.driver=idriver;
			PageFactory.initElements(driver, this);
	
		
	
	

}


	

}
