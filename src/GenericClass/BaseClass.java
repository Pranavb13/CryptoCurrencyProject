package GenericClass;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {
	
	CommonWebFunctions commonWebFunctions ;
	public static WebDriver driver;
	
	public void initializeBrowser(String driverPath) {
		System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		options.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));    
		driver = new ChromeDriver(options);
		
	}
	
	public void navigateToURL(String baseUrl) {	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(baseUrl);
        driver.manage().window().maximize();
        
	}
	

	public String readProperty(String property,String fileName) throws IOException {
		Properties obj = new Properties(); 
		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\"+fileName);
		obj.load(objfile);
		String propertyValue = obj.getProperty(property);
		return propertyValue;
	}
	
	
	
	
}
