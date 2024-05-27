package FrameWrok_EnvSetUp;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;




public class EnvironmentSetup extends Pathutility {
	
	


	public WebDriver driver;

	protected void setDriver(String browserName, String URL) {
		switch (browserName) {
		case "chrome":
			System.out.println("Chrome Opened ");
			System.setProperty("webdriver.chrome.driver", Pathutility.DRIVER_PATH);
			System.out.println(" PAth Done ");
			driver = new ChromeDriver();
			System.out.println(" Launching the URL ");
			launchURL(URL);
			break;
		case "msedge":
			System.out.println("MSEdge Opened ");
			System.setProperty("webdriver.edge.driver", Pathutility.DRIVER_PATH);
			driver = new EdgeDriver();
			launchURL(URL);
			break;
		case "firefox":
			System.out.println("FireFox Opened ");
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\wwwsa\\Downloads\\geckodriver-v0.34.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			launchURL(URL);
			break;
		default:
			System.out.println("Invalid Browser Name");
		}
	}

	private void launchURL(String applicationURL) {
		driver.get(applicationURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	
	/*The getdriver() method used to return the driver;
	 *Since we are returning the webdriver's instance then the returntype must be an Webdriver.
	 *The Webdriver is an bult-in interface which is commonly used for all the drivers like chrome,firefox,edge.
	 */
	// accessmodifier returntype name 
	public WebDriver getDriver() {
		return driver;
	}
	
	public void quitBrowser(){
		driver.quit();
	}
	
	
	/*public String getMethodName(){
		
		 String threadNAme = Thread.currentThread().getStackTrace()[3].getMethodName();
		return threadNAme;
		
     */   
	
}
