package org.junit;

import java.awt.AWTException;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;

public class JunitPrograms3 extends BaseClass{
	
	@Test
	public void tc_01() throws AWTException{
		fireFoxBrowserLaunch();
		urlLaunch("https://www.jiomart.com/?gclid=CjwKCAiA0JKfBhBIEiwAPhZ"
				+ "XD3RCGWMH8FMlnBaFPVoTG4cj7iJ0akE_wHZ4XHzXqa3m2_fOw2XwmBoC1TMQAvD_BwE");
		WebElement searchBox = locators("id", "autocomplete-0-input");
		sendText(searchBox, "iphone 13");
		keyboardEnter();
	}
	
	@Test
	public void tc_02() {
		WebElement iphone = locators("xpath", "//span[text()='Apple iPhone 13 256 GB, Pink']");
		clickElement(iphone);
		WebElement addToCompare = locators("xpath", "//span[text()='Add To Compare']");
		mouseClick(addToCompare);
	}
	
	@Test
	public void tc_03() {
		exitBrowser();
	}
	
	

}
