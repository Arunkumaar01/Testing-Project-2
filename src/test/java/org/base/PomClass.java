package org.base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomClass extends BaseClass{

	@FindBy(id="email")
	private WebElement username;
	
	@FindBy(id="pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement login;

	protected WebElement getLogin() {
		return login;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}
	
	public PomClass() {
		PageFactory.initElements(driver, this);
	}

}
