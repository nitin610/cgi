	package com.tests;

import java.io.IOException;
import java.util.Map;
import java.util.Random;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import com.pageObjects.BookingManagementPage;
import com.pageObjects.LoginPage;

import junit.framework.Assert;

public class AutomationTest extends BaseTest {

	private WebDriver driver;
	

	BaseTest basePage=new BaseTest();
	
	@BeforeMethod
	public void tearUp() throws IOException  {
		  driver=  getdriver("chrome");
		   basePage.navigateToURL();
        }
	

	@Test
	public void verifyFlightDetails() throws ParserConfigurationException, SAXException, IOException, InterruptedException{
	    Random rand = new Random();
	    int rand_int1 = rand.nextInt(1000);
	    int rand_int2 = rand.nextInt(1000);
		
		basePage.waitForPageLoad();
	    LoginPage loginPage=new LoginPage();
		basePage.waitForPageLoad();
		loginPage.signIn();
		BookingManagementPage bookPage = new BookingManagementPage();
		basePage.waitForPageLoad();
		int noOfRoomsAlreadypresent =  bookPage.noOfRoomsAlreadypresent();
		bookPage.enterRoomDetails(String.valueOf(rand_int1),"100", "WiFi");
		bookPage.clickCreateRoom();
		bookPage.enterRoomDetails(String.valueOf(rand_int2),"10", "Safe");
		bookPage.clickCreateRoom();
		bookPage.verifyNoOfRoomsCreation(2,noOfRoomsAlreadypresent);
		
	}
	 
	@AfterMethod
	public void tearDown() {
	   driver.quit();
		driver=null;
	}
	
	 
}
