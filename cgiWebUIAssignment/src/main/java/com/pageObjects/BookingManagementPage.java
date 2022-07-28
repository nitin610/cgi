package com.pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tests.BaseTest;

public class BookingManagementPage extends BaseTest{

	
	
	private By roomtxt=By.xpath("//*[@id='roomName']");
	private By pricetxt=By.xpath("//*[@id='roomPrice']");
	private By createRoomBtn=By.xpath("//*[@class='btn btn-outline-primary']");
	private By noOfRooms=By.xpath("//*[@data-type='room']");
	

	
	
	public void enterRoomDetails(String roomNumber,String price,String roomDetails) throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement roomNametxt = driver.findElement(roomtxt);
		roomNametxt.sendKeys(roomNumber);
		
		WebElement priceNametxt = driver.findElement(pricetxt) ;
		priceNametxt.sendKeys(price);
		
		WebElement roomDetailscb = driver.findElement(By.xpath("//*[@value='"+roomDetails+"']")) ;
		roomDetailscb.click();
		
		System.out.println("Room Created Succesfully ....");
	
	}
	
	
	public void clickCreateRoom()
	{
		
		WebElement createRomBtn = driver.findElement(createRoomBtn) ;
		createRomBtn.click();
	
	}

	
	public void verifyNoOfRoomsCreation(int numberOfRooms,int noOfRoomsAlreadypresent) throws InterruptedException
	{
		Thread.sleep(3000);
		List<WebElement>  noOfRoomsCreated =  driver.findElements(noOfRooms) ;
		assertTrue(noOfRoomsCreated.size()-noOfRoomsAlreadypresent == numberOfRooms);
		System.out.println(noOfRoomsCreated.size()-noOfRoomsAlreadypresent + "  new number of Rooms created Succesfully");
		
	}
	
	public int noOfRoomsAlreadypresent() throws InterruptedException
	{
		Thread.sleep(3000);
		List<WebElement>  noOfRoomspresent =  driver.findElements(noOfRooms) ;
	
		System.out.println(noOfRoomspresent.size()  + "  number of Rooms present before creation of new rooms");
		return noOfRoomspresent.size();
	}
	
	
	
	
	
  
	
	
	
}
