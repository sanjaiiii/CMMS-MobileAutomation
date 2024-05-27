package FrameWork_TestCase;

import java.io.File;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import FrameWork_PageObject.LoginPage;
import FrameWrok_EnvSetUp.EnvironmentSetup;


public class MsEdgeTestCase extends EnvironmentSetup {
// test=> Environmental setup=> path utility
	
	
LoginPage page;
	

	@BeforeClass
	public void setup() {


		setDriver("msedge", "https://sacmms.ripplesiot.net");
		driver = getDriver();//To get the control of the driver instance in here
		
		// classname.methodname()
		
		page = PageFactory.initElements(driver, LoginPage.class);
		//1st it is giving value for Constructor
		//its init the webelements
		//its returning a page object
		
		driver.manage().window().maximize();
		

	}
	
	

	@Test
	public void testcmms() throws InterruptedException {
	
		
		page.Logincmms().Masters().AddingAsset().AssetTransfer().corrective().Prevnetive().NewAssetinMDMS().Completed();
	
		
	}
	

	@AfterClass
	public void close() {

		quitBrowser();
		
	}
	
	

}
