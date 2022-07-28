package com.pageObjects;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tests.BaseTest;





public class LoginPage extends BaseTest {


 By username = By.xpath("//*[@id='username']");
 By password  =  By.xpath("//*[@id='password']");
 By submitlogin =  By.xpath("//*[@id='doLogin']");


 public WebElement username()
	 {
	 return driver.findElement(username);	
	 }
	
 public WebElement password()
   	 {
	 return driver.findElement(password);	
	 }
 
 public WebElement submitlogin()
	 {
	 return driver.findElement(submitlogin);	
	 }


 public void signIn() 
      {
      this.username().sendKeys("admin");
      this.password().sendKeys("password");
      this.submitlogin().click();
      } 
}
