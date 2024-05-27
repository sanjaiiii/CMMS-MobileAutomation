package FrameWork_PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage {
	

	 WebDriver driver;
		
		public LoginPage(WebDriver driver) 
		{
			this.driver = driver;//If the variable and parameter has the same name, have to use the "this" keyword.
		}
		
		/*Here in page_object Model to find the webelements 
		 *Syntax:
		 *       @FindBy(loactors="Value")
		 *       datatype a_name;
		 *        	 
		 */
		
		@FindBy(id="signin-username")
		WebElement username;
		@FindBy(id="signin-password")
		WebElement password;
		@FindBy(id="id_login")
		WebElement signin;
		
		public WebElement username() {return username;}
		public WebElement password() {return password;}
		public WebElement signin() {return signin;}
		
		public Masters Logincmms() {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			username.sendKeys("SANJAY");
			password.sendKeys("qwerty@123");
			signin.click();
			System.out.println("Logged-In Successfully");
			
			
			return PageFactory.initElements(driver, Masters.class);
			
		}
		
		
	

	
}
