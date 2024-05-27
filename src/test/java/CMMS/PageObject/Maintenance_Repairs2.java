package CMMS.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Maintenance_Repairs2 {

	WebDriver driver;
	WebDriverWait wait;
	
	public Maintenance_Repairs2(WebDriver driver) {
		
		this.driver= driver;
	}

	@FindBy(partialLinkText="Preventive")
	WebElement prmt;	
	@FindBy(id="id_assetid")
	WebElement id;
	// Click on another element to trigger the appearance of the alert
	@FindBy(name="startdate")
	WebElement someelement;
	@FindBy(xpath="/html/body/div[4]/div/div[6]/button[1]")
	WebElement y;
	@FindBy(css="#id_startdate")
	WebElement sd;
	@FindBy(name="enddate")
	WebElement ed;
	@FindBy(xpath="//*[@id=\"div_id_enddate\"]//following::input[2]")
	WebElement d;
	@FindBy(xpath="//*[@id=\"id_customdays\"]//following::select[1]")
	WebElement dpmnt;
	@FindBy(name="customdays")
	WebElement cd;
	
	@FindBy(xpath="//*[@id=\"id_customdays\"]//following::span[4]")
	WebElement element;
	@FindBy(xpath="/html/body/span/span/span[2]")// finding the options box
	WebElement Atos;
	@FindBy(id="id_save_preventive")
	WebElement save;
	
	@FindBy(xpath="/html/body/div[4]/div")
	WebElement Alert;
	
	public MDMS Prevnetive() 
	{
		/*
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		
		prmt.click();//clicked on Preventive Maintenance
		System.out.println("Clicked on Preventive Miantenance");
		
		String assetId=AddAsset.getAssetId();
		id.sendKeys(assetId); //Id
		System.out.println("Using the Same Assetid Here as well");
		
		someelement.click();// Doing this to trigger the another element.
		
		wait.until(ExpectedConditions.visibilityOf(Alert));
		y.click();//Clicking on yes in the alert
		sd.sendKeys("01-06-2024");//Start date
		System.out.println("StartDate Sent");
		
		ed.sendKeys("05-06-2024");//End Date
		System.out.println("EndDate Sent");
		
		d.sendKeys("Monthly-Check");//description
		System.out.println("Description Sent");
		
		Select sdpmnt = new Select(dpmnt);//Department
		sdpmnt.selectByVisibleText("SUPPORT");
		System.out.println("Department Selected");
		
		cd.sendKeys("5");//Customdays
		System.out.println("Custom-Days Sent");
		
		
		
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", save);//save the WO
		System.out.println("Saved");
        
		
		
		*/
		System.out.println("There is an Issue cannot automate now");
		
		return PageFactory.initElements(driver, MDMS.class);
		
		
	}
	
}
