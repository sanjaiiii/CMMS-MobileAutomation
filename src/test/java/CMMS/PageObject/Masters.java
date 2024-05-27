package CMMS.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;


public class Masters {

	WebDriver driver;
	
		
		public Masters(WebDriver driver) {
			
			this.driver= driver;
		}
		
		
		@FindBy(xpath="//*[@id=\"sidebar\"]/ul/li[5]/a")
		WebElement Masters;//masters
		
		@FindBy(id="id_new_span")
		WebElement newid;//+ symbol or new id button
		
		@FindBy(id="btn_save_master")
		WebElement save;// Save
		
		@FindBy(linkText="Vendor")
		WebElement Vendor;
		@FindBy(css="#id_address")
		WebElement address;
		@FindBy(css="#id_email")
		WebElement email;
		@FindBy(id="id_company_category1")
		WebElement supplier;
		
		@FindBy(linkText="Asset Identity")//Asset identity
		WebElement Ai;
		@FindBy(css="#id_description")
		WebElement description;
		
		@FindBy(linkText="Brand")//Brand
		WebElement b;
		
		@FindBy(linkText="Document Type")//Document Type
		WebElement dt;
		
		
		
		public AddAsset Masters() throws InterruptedException 
		{
			Masters.click();
			System.out.println("Clicked on Masters");
			
			
			//Vendor
			Vendor.click();
			//To close the dashboard totally
			driver.findElement(By.cssSelector("body > div.wrapper.d-flex.flex-column.min-vh-100.bg-light.dark\\:bg-transparent > header > div:nth-child(1) > button:nth-child(1) > svg")).click();
			System.out.println("DashBoard Closed");
			newid.click();
			description.sendKeys("Coffee House");
			address.sendKeys("Unknown");
			email.sendKeys("coffeehouse@gmail.com");
			supplier.click();
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", save);
			save.click();
			
			
			//AssetIdentity
			//To close the dashboard totally
			driver.findElement(By.cssSelector("body > div.wrapper.d-flex.flex-column.min-vh-100.bg-light.dark\\:bg-transparent > header > div:nth-child(1) > button:nth-child(1) > svg")).click();
			System.out.println("DashBoard Opened");
			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", Ai);
			Ai.click();
			
			//To close the dashboard totally
			driver.findElement(By.cssSelector("body > div.wrapper.d-flex.flex-column.min-vh-100.bg-light.dark\\:bg-transparent > header > div:nth-child(1) > button:nth-child(1) > svg")).click();
			System.out.println("DashBoard Closed");
			newid.click();
			description.sendKeys("Height & Weight");
			save.click();
			System.out.println("Created AssetIdentity on Masters");
			
			return PageFactory.initElements(driver, AddAsset.class);	
		}
	
		
		
}
