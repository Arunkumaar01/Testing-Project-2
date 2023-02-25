package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static Actions act;
	public static Robot ro;
	public static JavascriptExecutor js;
	
	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public static void edgeBrowserLaunch() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void fireFoxBrowserLaunch() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void urlLaunch(String url) {
		driver.get(url);
	}
	
	public static WebElement locators(String locator, String value) {
		if(locator.equalsIgnoreCase("id")) {
			WebElement findElement = driver.findElement(By.id(value));
			return findElement;
		}
		else if (locator.equalsIgnoreCase("name")) {
			WebElement findElement = driver.findElement(By.name(value));
			return findElement;
		}
		else if (locator.equalsIgnoreCase("xpath")) {
			WebElement findElement = driver.findElement(By.xpath(value));
			return findElement;
		}
		else {
			System.out.println("None");
			return null;
		}	
	}
	
	public static void clickElement(WebElement element) {
		element.click();
	}
	
	public static void exitBrowser() {
		driver.quit();
	}
	
	public static void sendText(WebElement element, String keysToSend) {
		element.sendKeys(keysToSend);
	}
	
	public static String getExcelData(int rownum, int cellnum) throws IOException {
		
		try {
			File file = new File("C:\\Users\\DELL\\OneDrive\\Documents\\CLASS\\ADVANCED FRAMEWORK\\EXCEL.xlsx");
			FileInputStream in = new FileInputStream(file);
			Workbook book = new XSSFWorkbook(in);
			Sheet sheet = book.getSheet("Sheet1");
			Row row = sheet.getRow(rownum);
			Cell cell = row.getCell(cellnum);
			CellType cellType = cell.getCellType();
			String value = "";
			switch (cellType) {
			case STRING:
				value = cell.getStringCellValue();
				break;

			default:
				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
					value = simple.format(dateCellValue);
				} else {
	                 double numericCellValue = cell.getNumericCellValue();
	                 long lo = (long)numericCellValue;
	                 BigDecimal valueOf = BigDecimal.valueOf(lo);
	                 value = valueOf.toString();
				}
				break;
			}
			return value;
		}
		 catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public static void mouseClick(WebElement element) {
		act = new Actions(driver);
		act.click(element).perform();
	}
	
	public static void rightClick(WebElement element) {
		act.contextClick(element).perform();
	}
	
	public static void doubleClick(WebElement element) {
		act.doubleClick(element).perform();
	}
	
	public static void moveToElement(WebElement element) {
		act.moveToElement(element).perform();
	}
	
	public static void keyboardDown() throws AWTException {
		ro =  new Robot();
		ro.keyPress(KeyEvent.VK_DOWN);
	}
	
	public static void keyboardEnter() throws AWTException {
		ro =  new Robot();
		ro.keyPress(KeyEvent.VK_ENTER);
	}
	
	public static void scrollDownUsingPixel() {
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	
	public static void scrollUpUsingPixel() {
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-1000)");
	}
	
	public static void scrollDownUsingElement(WebElement element) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public static void scrollUpUsingElement(WebElement element) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(down", element);
	}
	
	public static void clear(WebElement element) {
		element.clear();
	}
	
	public static void sleep() throws InterruptedException {
		Thread.sleep(2000);
	}
	
	public static void title() {
		String title = driver.getTitle();
		System.out.println(title);
	}

}
