package Filter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Element_Locator extends Browser {
	
	static WebDriverWait wait = new WebDriverWait(driver, 30);
	
	@Test
	public static By locatorvalue(String locator, String values ) {
		
		By all_locators;
		switch(locator) {
		
		case"id":
			all_locators = By.id(values);
			break;
		case"name":
			all_locators = By.name(values);
			break;	
		case"linktext":
			all_locators = By.linkText(values);
			break;
		case"partialLinktext":
			all_locators = By.partialLinkText(values);
			break;
		case"xpath":
			all_locators = By.xpath(values);
			break;
		case"cssselector":
			all_locators=By.cssSelector(values);
			break;
		case"tagname":
			all_locators = By.tagName(values);
			break;
		case"classname":
			all_locators = By.className(values);
			break;
			
			default: all_locators = null;
		
		}
		return all_locators;
	
	}
	
	@Test
	public void data(String locatortype, String value, String data) {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		By inputvalue;
		inputvalue = locatorvalue(locatortype, value);
		wait.until(ExpectedConditions.elementToBeClickable(inputvalue));

		driver.findElement(inputvalue).sendKeys(data);
		
	}
	
	@Test
	public void click_button(String locatortype, String value) {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		By locators;
		locators = locatorvalue(locatortype, value);
		wait.until(ExpectedConditions.elementToBeClickable(locators));
		
		WebElement elem = driver.findElement(locators);
		elem.click();
		
	}
	
	@Test
	public void cache_reset() throws InterruptedException {
		
		
		//cache reset
				WebElement ele1 = driver.findElement(By.id("vis_menuSearch"));
				ele1.sendKeys("Cache Reset");
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ul/li/div"))).click();
				
				click_button("xpath", "//button[@class='vis-button-ok vis-process-ok-btn VIS_Pref_btn-2']");
				Thread.sleep(4000);
				click_button("xpath", "//i[@class='vis vis-cross']");
				
		
		
	}

}
