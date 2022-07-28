package com.tests ;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;




public class BaseTest {

	public static   WebDriver driver ;
	 String browser;
	 
		
	public WebDriver getdriver(String browser) throws IOException
	{
		    
	
				if(browser.equals("chrome"))
				{
				System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
				driver  =  new ChromeDriver();
				}
		
		return driver;
	//	return (WebElement) driver;
	
	
	}
	
	private void setProperty(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	public void navigateToURL() {
		 driver.get("https://automationintesting.online/#/admin/");
		 driver.manage().window().maximize();
	}
	
	public void waitForPageLoad() {
		
		WebDriverWait wait = new WebDriverWait(driver, 100);
				
		
		ExpectedCondition<Boolean> pageLoad=new ExpectedCondition<Boolean>() {
			
			public Boolean apply(WebDriver arg0) {
				// TODO Auto-generated method stub
				return (((JavascriptExecutor)driver).executeScript("return document.readyState;").equals("complete"));
			}
		};
		wait.until(pageLoad);
	}
	
	
}
