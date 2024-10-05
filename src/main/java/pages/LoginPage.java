package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		// constructor
		this.driver = driver;
	}
	
	public void enterUsername (String username) {
		
		driver.findElement(By.id("username")).sendKeys(username);
				
		
	}
	 public void enterPassword (String password) {
		 
		 driver.findElement(By.name("password")).sendKeys(password);
	 }
	
	 
	  public void clickSubmit () {
		  
		  driver.findElement(By.xpath("//button[@id='submit']")).click();
	  }
	  
	  public By getSuccessMessageLocator () {
		  
		  return By.className("post-title");
	  }
 
	  public String getSuccessMessage () {
		  
		 return driver.findElement(By.className("post-title")).getText();
	  }
	  
	 
	  

}
