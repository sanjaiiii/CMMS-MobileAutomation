package FrameWork_PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class Masters {

	WebDriver driver;
	
		
		public Masters(WebDriver driver) {
			
			this.driver= driver;
		}
		
		
		@FindBy(xpath="//*[@id=\"sidebar\"]/ul/li[5]/a")
		WebElement Masters;//masters
		
		
		@FindBy(linkText="Ticket Closure Answers")//TCA
		WebElement TCQ;
		@FindBy(id="id_new_span")
		WebElement newid;//+ symbol or new id button
		@FindBy(css="#id_category")
		WebElement tc;
		@FindBy(css="#id_question")
		WebElement q;
		@FindBy(css="#id_displayorder")
		WebElement qd;
		@FindBy(name="answer")
		WebElement qa;
		@FindBy(id="btn_save_master")
		WebElement save;// Save
		
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
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", TCQ);
			TCQ.click();//TCQ
			newid.click();
			Select ccc = new Select(tc);
			ccc.selectByVisibleText("AC");
			Select qc = new Select(q);////Question
			qc.selectByIndex(0);
			qd.sendKeys("-1");
			qa.sendKeys("yes");
			save.click();// Save
			System.out.println("Created TCQ on Masters");
			
			//AssetIdentity
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", Ai);
			Ai.click();
			newid.click();
			description.sendKeys("Weight");
			save.click();
			System.out.println("Created AssetIdentity on Masters");
			
			//Brand
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", b);
			b.click();
			newid.click();
			description.sendKeys("NewGen");
			save.click();
			System.out.println("Created Brand on Masters");
			
			//Document Type
			//dt.click();
			//description.sendKeys("Declaration");
			//save.click();
			//System.out.println("Created Document Type on Masters");
			
			return PageFactory.initElements(driver, AddAsset.class);	
		}
	
		
		
}
