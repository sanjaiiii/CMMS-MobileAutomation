package FrameWork_PageObject;

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
	
	
	
	public MDMS Prevnetive() 
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		prmt.click();//clicked on Preventive Maintenance
		System.out.println("Clicked on Preventive Miantenance");
		
		String assetId=AddAsset.getAssetId();
		id.sendKeys(assetId); //Id
		System.out.println("Using the Same Assetid Here as well");
		
		someelement.click();// Doing this to trigger the another element.
		
		y.click();//Clicking on yes in the alert
		sd.sendKeys("18-04-2024");//Start date
		System.out.println("StartDate Sent");
		
		ed.sendKeys("01-05-2024");//End Date
		System.out.println("EndDate Sent");
		
		d.sendKeys("Testing");//description
		System.out.println("Description Sent");
		
		Select sdpmnt = new Select(dpmnt);//Department
		sdpmnt.selectByVisibleText("SUPPORT");
		System.out.println("Department Selected");
		
		cd.sendKeys("10");//Customdays
		System.out.println("Custom-Days Sent");
		
		/*
		// To Click on the employee
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		
		wait.until(ExpectedConditions.visibilityOf(Atos));
		List<WebElement> optionstochoose = Atos.findElements(By.tagName("li"));// finding the list of the options
		// from the option box
        for (WebElement optn : optionstochoose)// iterate and get the option
        {
          if (optn.getText().equals("SANJAY THANGAVEL")) {
                 optn.click();
                 System.out.println("Employee Selected");
                    break;
                           }
                       }
        */
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", save);//save the WO
		System.out.println("Saved");
        
		return PageFactory.initElements(driver, MDMS.class);
	}
	
}
