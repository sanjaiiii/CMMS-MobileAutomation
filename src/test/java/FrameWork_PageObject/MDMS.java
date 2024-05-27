package FrameWork_PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MDMS {

	WebDriver driver;
	WebDriverWait wait;
	public static String assetid;
	
	public MDMS(WebDriver driver) {
		
		this.driver = driver;
	}
	
	
	@FindBy(css="#sidebar > ul > li:nth-child(4) > a")
	WebElement MDMS;
	@FindBy(linkText="Add Asset")
	WebElement A;
	@FindBy(name="assetname")
	WebElement AN;
	@FindBy(name="assetcategory")
	WebElement AC;
	@FindBy(name="status")
	WebElement AS;
	@FindBy(css="#div_id_brand > div > span > span.selection > span")
	WebElement Ab;
	@FindBy(xpath="/html/body/span/span/span[1]/input")
	WebElement Abb;
	@FindBy(css="#select2-id_brand-results")
	WebElement mdmsbrand;
	@FindBy(xpath="//*[@id=\"id_purchasedate\"]")
	WebElement dp;
	@FindBy(id="id_purchaseamount")
	WebElement pa;
	@FindBy(name="building")
	WebElement MDMSBuilding;
	@FindBy(name="floor")
	WebElement mdmsfloor;
	@FindBy(name="zone")
	WebElement mdmszone;
	@FindBy(id="id_warrantytill")
	WebElement wid;
	@FindBy(name="vendor")
	WebElement MDMSsupplier;
	@FindBy(id="id_file_assetupload")
	WebElement assettpic;
	@FindBy(name="mdms")
	WebElement checkbox;
	@FindBy(id="id_btn_assetdetails")
	WebElement save;
	
	@FindBy(name="assetid")
	WebElement astid;
	
	
	
	public Dummy NewAssetinMDMS() throws InterruptedException 
	{
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		MDMS.click();//Clicking on MDMS
		System.out.println("Clicked on MDMS");
		
		A.click();//clicking on add asset


		AN.sendKeys("AC-1");//Asset Name
		System.out.println("Asset Name is Fixed");
		
		Select sc= new Select(AC);//category of asset
		sc.selectByVisibleText("CPU");//Selecting from the list 
		System.out.println("Asset Category is Fixed");
		
		Select sat= new Select(AS);//Status
		sat.selectByVisibleText("IN USE");//Selecting from the list 
		System.out.println("Asset Status is Fixed");
		
		Ab.click();//clicking on dropdownbox
		Abb.sendKeys("Hy");//sending the 2letters
		
		wait.until(ExpectedConditions.visibilityOf(mdmsbrand));
		List<WebElement> mdmsourbrand = mdmsbrand.findElements(By.tagName("li"));//finding all the options an dputting it in a list
		for(WebElement mob: mdmsourbrand)
		{
			if(mob.getText().equals("Hytech"))
			{   
				Thread.sleep(2000);
				mob.click();
				break;
			}
		}
		
		dp.sendKeys("01-04-2024");//Date purchased
		System.out.println("Purchased Date Fixed");
		
		pa.sendKeys("50,000");// Purchase Amount
		System.out.println("Purchased Amount Fixed");
		
		Select mdmsB = new Select(MDMSBuilding); //Building
		mdmsB.selectByVisibleText("SAIT");
		System.out.println("Building Fixed");
		
		Select mdmsf = new Select(mdmsfloor);//floor
		mdmsf.selectByVisibleText("First floor");
		System.out.println("Floor Fixed");
		
		Select mdmsz = new Select(mdmszone);//zone
		mdmsz.selectByVisibleText("DEVS");
		System.out.println("Zone Fixed");
		
		wid.sendKeys("01-04-2026");//warranty
		System.out.println("Warranty Date is set");
		
		Select mdmss = new Select(MDMSsupplier);//Supplier
		mdmss.selectByVisibleText("Hiesenberg");
		System.out.println("Supplier is set");
		
		String fp = "C:\\Users\\wwwsa\\Downloads\\cpu.jpg";
		assettpic.sendKeys(fp);
		System.out.println("Asset Picture Fixed");
		
		
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", save);
		System.out.println("Clicked on save");
		
		//Should wait for the Assetid to be generated
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(astid, "value", "NEW")));
		
		assetid = astid.getAttribute("value");
		System.out.println("New Asset id for the Asset created under MDMS:"+ assetid);
		
		
		return PageFactory.initElements(driver, Dummy.class);
		
	}
	
}
