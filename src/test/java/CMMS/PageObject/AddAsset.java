package CMMS.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AddAsset {	
	

	
WebDriver driver;

public static String assetid;

public static String getAssetId() {
    return assetid;
}


public AddAsset(WebDriver driver) {
	
	this.driver= driver;
}
	@FindBy(xpath="//*[@id=\"sidebar\"]/ul/li[2]/a")
	WebElement AM;
	@FindBy(linkText="Assets")
	WebElement A;
	@FindBy(css="#id_asset_dashboard > div > div.col-md-3.col-xs-6.text-end.ms-auto > a")
	WebElement New;
	@FindBy(id="id_assetname")
	WebElement AN;
	@FindBy(xpath="//*[@id=\"id_assetcategory\"]")
	WebElement AC;
	@FindBy(name="status")
	WebElement Status;
	@FindBy(xpath="//*[@id=\"id_purchasedate\"]")
	WebElement purchasedate;
	@FindBy(id="id_purchaseamount")
	WebElement purchaseamnt;
	@FindBy(id="id_warrantytill")
	WebElement warranty;
	@FindBy(xpath="//*[@id=\"id_vendor\"]")
	WebElement vendor;
	@FindBy(id="id_file_assetupload")
	WebElement astpic;
	@FindBy(css="#div_id_brand > div > span > span.selection > span") //Brand
	WebElement BB;
	@FindBy(xpath="/html/body/span/span/span[1]/input") //Brand
	WebElement BT;
	@FindBy(xpath="//*[@role='listbox']") //Brand
	WebElement BO;
	@FindBy(id="id_btn_assetdetails")
	WebElement submit;
	@FindBy(name="assetid")
	WebElement astid;
	
	public AssetTransfer AddingAsset() throws InterruptedException {

		//To open sidebar
		driver.findElement(By.cssSelector("body > div.wrapper.d-flex.flex-column.min-vh-100.bg-light.dark\\:bg-transparent > header > div:nth-child(1) > button:nth-child(1) > svg")).click();
		AM.click();
		System.out.println("Asset Management Clicked");
		A.click();
		System.out.println("Assets Clicked");
		//To close sidebar
		driver.findElement(By.cssSelector("body > div.wrapper.d-flex.flex-column.min-vh-100.bg-light.dark\\:bg-transparent > header > div:nth-child(1) > button:nth-child(1) > svg")).click();
		Thread.sleep(1000);		
		New.click();
		System.out.println("New Asset Clicked");
		

		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		AN.sendKeys("Espresso Machine");//Assetname
		
		
		Select s= new Select(AC);//category
		s.selectByIndex(2);//Selecting from the list 
		System.out.println("Coffee Maker");
		
		Select sa= new Select(Status);//Status
		sa.selectByVisibleText("DAMAGE");
		System.out.println("Selected status");
		
		purchasedate.sendKeys("01-04-2024");
		System.out.println("Purcahsed Date Fixed");
		
		purchaseamnt.sendKeys("10,000");//amnt
		System.out.println("Purcahsed Amount Fixed");
		
		warranty.sendKeys("01-06-2024");//warranty
		System.out.println("Warranty Date Fixed");
		
		Select sel = new Select(vendor);// Supplier
		sel.selectByVisibleText("Coffee House");
		System.out.println("Vendor or Supplier Fixed");
		
		//String fp = "C://Eclipse//CMMSmobiletesting//src//test//resources//Espressomachine.jpeg";//pic path
		//astpic.sendKeys(fp);
		//System.out.println("Asset Picture Fixed");
		
		/*
		 * Brand:
		BB.click();
		BT.sendKeys("Hy");
		List<WebElement> ourbrand = BO.findElements(By.tagName("li"));//Brand
		for(WebElement ob: ourbrand)
		{
			if(ob.getText().equals("Hytech"))
			{   
				Thread.sleep(1500);
				ob.click();
				System.out.println("Brand Selected");
				break;
			}
			
			
			
			
		}
		*/
	    
		//To click on submit
		//1.scrollinto the view & 2. click on the element
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submit);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", submit);
		System.out.println("Submitted");
		
		/*1.After submitting the form, it waits for the attribute value of the assetid input field to change from "NEW" to a different value using ExpectedConditions.not(ExpectedConditions.attributeToBe(astid, "value", "NEW")).
2.Once the attribute value is updated, it retrieves the updated value using getAttribute("value"). */
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", astid);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
	    wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(astid, "value", "NEW")));

		assetid = astid.getAttribute("value");
		System.out.println("New Asset id for the Asset created :"+ assetid);
		
    
		return PageFactory.initElements(driver, AssetTransfer.class);
	}
	

}
	
	


