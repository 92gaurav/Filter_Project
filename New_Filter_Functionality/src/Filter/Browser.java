package Filter;

import org.openqa.selenium.WebDriver;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;


public class Browser {
	
	protected static WebDriver driver;
	
	@BeforeClass
	public static WebDriver brow(String url) {
	
	System.setProperty("webdriver.chrome.driver", "E:\\Testing\\browserdriver\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to(url);
	
	return driver;
	
	}
	
}
