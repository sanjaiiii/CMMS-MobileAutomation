package FrameWork_PageObject;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Maintenance_Repairs {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public Maintenance_Repairs(WebDriver driver) {
		
		this.driver= driver;
	}
		
	@FindBy(xpath="//*[@id=\"sidebar\"]/ul/li[3]/a")
	WebElement MR;
	@FindBy(partialLinkText="Corrective")
	WebElement crmt;
	@FindBy(xpath="//*[@id=\"id_from_maintenancefilter\"]/div/div[8]/a")
	WebElement nw;
	@FindBy(id="id_duedate")
	WebElement id;
	@FindBy(name="duetime")
	WebElement dt;
	@FindBy(name="title")
	WebElement t;
	@FindBy(xpath="//*[@id=\"id_title\"]//following::input[1]")
	WebElement d;
	@FindBy(xpath="//*[@id=\"id_form_workorder\"]/div/div[2]/div/div[4]/div")//selecting priority
	WebElement priority;
	@FindBy(xpath="//*[@id='id_duedate']//preceding::input[1]")
	WebElement Aid;
	@FindBy(xpath="/html/body/div[5]/div/div[6]/button[1]")
	WebElement SB;
	@FindBy(id="btn_save_workorder")
	WebElement Wk;
	
	public Maintenance_Repairs2 corrective() 
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		MR.click();// clicked on Maintenance & Repairs
		System.out.println("Clicked on Maintenance & Repairs");
		
		crmt.click();//clicked on corrective Miantenance
		System.out.println("Clicked on Corrective Miantenance");
		
		nw.click();//new workorder
		System.out.println("Clicked on new workorder");
		
		id.sendKeys("04-20");//duedate
		System.out.println("Fixed duedate");
		
		dt.sendKeys("10:00");//duetime
		System.out.println("Fixed duetime");
		
		t.sendKeys("Testing");//Title
		System.out.println("Sent the Title");
		
		d.sendKeys("Static Testing");//Description
		System.out.println("Sent the Description");
		
		List<WebElement> pty = priority.findElements(By.tagName("label")); //selecting priority
		for (WebElement py : pty) {
		    if (py.getText().equals("Medium")) {
		        py.click();
		        break; 
		    }
		}
		System.out.println("Priority declared");
		
		String assetId=AddAsset.getAssetId();
		Aid.sendKeys(assetId);//Assetid
		System.out.println("Using the Same Assetid");
		
		d.click();
		System.out.println("Clicked on the Description again to trigger");
		wait.until(ExpectedConditions.elementToBeClickable(SB));
		SB.click();

		Wk.click();//Submit workorder 
		System.out.println("Submitted..!");		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		
		return PageFactory.initElements(driver, Maintenance_Repairs2.class);
	}
	
		

}
