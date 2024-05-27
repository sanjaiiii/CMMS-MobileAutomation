package CMMS.Testcase;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Configuration {

	AndroidDriver driver;
	AppiumDriverLocalService service;
	WebDriverWait wait;
	@BeforeSuite
	
    public void servicestart() throws MalformedURLException, URISyntaxException {

         service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C://Users//wwwsa//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(500)) 
                .build();

        service.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setChromedriverExecutable("C://Users//wwwsa//Downloads//chromedriver_83version//chromedriver.exe");
        options.setCapability("browserName", "Chrome");
        options.setDeviceName("Android11");

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Adjusted to 10 seconds for simplicity

    }

    
    @AfterSuite
    public void quit() throws InterruptedException {

    	Thread.sleep(1000);
        driver.quit();
        service.stop();
    }

}
