package org.base;

import org.openqa.selenium.WebElement;

public class BaseClassTest extends BaseClass{
	
	public static void main(String[] args) {
		
		browserLaunch();
		urlLaunch("https://www.facebook.com/login/");
		PomClass pom = new PomClass();
		WebElement username = pom.getUsername();
		sendText(username, "arunr232@gmail.com");
		WebElement password = pom.getPassword();
		sendText(password, "Arunr@0111");
		WebElement login = pom.getLogin();
		clickElement(login);
		
	}

}
