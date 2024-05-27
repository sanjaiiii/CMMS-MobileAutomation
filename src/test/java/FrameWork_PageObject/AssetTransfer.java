package FrameWork_PageObject;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AssetTransfer{
	
	
WebDriver driver;



	
	public AssetTransfer(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	@FindBy(linkText="Asset Transfer")
	WebElement AT;
	@FindBy(css="#select2-id_employeelist-container")
	WebElement dp;
	@FindBy(xpath="/html/body/span/span/span[1]/input")
	WebElement Sb;
	@FindBy(xpath="/html/body/span/span/span[2]")
	WebElement AO;
	@FindBy(id="id_preventive_search")
	WebElement AI;
	@FindBy(xpath="//*[@id=\"id_btn_search_asset\"]/i")
	WebElement search;
	
	@FindBy(xpath="//*[@id=\"id_assetcategory\"]")
	WebElement C;
	
	@FindBy(xpath="//*[@id=\"id_assetcategory\"]//preceding::input[1]")
	WebElement ast;
	
	@FindBy(css="#id_available_asset_list > tbody > tr > td:nth-child(4) > a")
	WebElement A;
	@FindBy(css="div.toast-error")
	WebElement toast;
	@FindBy(css="#id_modal_available_asset > div > div > div.modal-header > button")
	WebElement CB;
	@FindBy(name="expreturndate")
	WebElement exd;
	@FindBy(id="btn_save_transfer")
	WebElement save;
	@FindBy(id="id_div_savedassets")
	WebElement pd;
	@FindBy(xpath="//*[@id=\"btn_save_receive\"]")
	WebElement R;
	
	
	public Maintenance_Repairs AssetTransfer() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
;		
		AT.click();
		System.out.println("Clicked on Asset Transfer");
		dp.click();// clickon the dropdown
		System.out.println("Clicked on dropdown");
		Sb.sendKeys("SANJAY");
		List<WebElement> optionstoselect = AO.findElements(By.tagName("li"));// finding the list of the options
		// from the option box
        for (WebElement opt : optionstoselect)// iterate and get the option
        {
        if (opt.getText().equals("SANJAY THANGAVEL")) {
        opt.click();
        System.out.println("Selected Employee as Sanjay Thangavel");
        break;
        }}
        
        String assetId=AddAsset.getAssetId();
        System.out.println("Sending the asset id which we created " + assetId);
		AI.sendKeys(assetId);// sending the id on assetid box again
		System.out.println("The Assetid sent into the Assetid box successfully");
		
		search.click();
		
		ast.sendKeys(assetId);
		System.out.println("Sent the asset id in the new window");
		
		Select se = new Select(C);// Category
		Thread.sleep(4000);
		se.selectByIndex(2);
		System.out.println("The category was selected in the new window");
		
		A.click();// Selecting the asset
		System.out.println("Asset was selected in the new window");
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CB);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", CB);
		System.out.println("Closed the new window");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		exd.sendKeys("01042025");// returndate
		System.out.println("Sending the Exp.Ret.Date");
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", save);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", save);
		System.out.println("Saved the Selected Assets Inorder to see the assets in Allocated Assets");
		
		List<WebElement> checkmark = pd.findElements(By.xpath(".//span[@class='checkmark']")); // Locate the
																										// checkboxes
																										// within the
																										// parent div

		for (WebElement cm : checkmark) {
			try {
				// Wait for the checkbox to be clickable
				wait.until(ExpectedConditions.elementToBeClickable(cm));

				// Click on the checkbox
				cm.click();

				System.out.println("Checkbox clicked successfully");
			} catch (Exception e) {
				System.out.println("Failed to click checkbox: " + e.getMessage());
			}
		}
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", R);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", R);
		System.out.println("Asset Transfered & Recieved successfully");
		
		return PageFactory.initElements(driver, Maintenance_Repairs.class);
	}
	

}
