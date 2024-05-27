package CMMS.Testcase;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import CMMS.PageObject.LoginPage;


public class TestCase extends Configuration{

	
		
	
	LoginPage page;

	@BeforeTest
	public void openCMMS() {
		
		driver.get("https://sacmms.ripplesiot.net");
	}
	
	
	
	@Test
	public void testcmms() throws InterruptedException {
	
		// classname.methodname()
		
				page = PageFactory.initElements(driver, LoginPage.class);
				//1st it is giving value for Constructor
				//its init the webelements
				//its returning a page object
				
				//Note:If u maximize the window in android chrome u will get error, So don't
				//driver.manage().window().maximize();
		
				page.Logincmms().Masters().AddingAsset().AssetTransfer().corrective().Prevnetive().NewAssetinMDMS().Completed();
	}
	

	
	
 
	}


