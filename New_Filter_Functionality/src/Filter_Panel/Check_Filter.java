package Filter_Panel;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Filter.Element_Locator;

public class Check_Filter extends Element_Locator {
	
	@Test
	public void menu() throws NullPointerException, InterruptedException {
		
		System.out.println("Menu method is working");
		System.out.println("driver=" + driver); 
	
		WebDriverWait wait = new WebDriverWait(driver, 30);

		wait.until(ExpectedConditions.elementToBeClickable(By.id("vis_appMenu"))).click();
		
		WebElement ele = driver.findElement(By.id("vis_menuSearch"));
		ele.sendKeys("Purchase Order");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ul/li[1]/div"))).click();
		System.out.println("Check");
		click_button("xpath", "//div[@class='vis-ad-w-p-nav']//li[3]//div[1]");
		click_button("xpath", "//span[contains(text(),'New Record')]");

		click_button("xpath", "//div[@class='vis-ad-w-p-nav']//li[3]//div[1]");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, 250);");
		System.out.println("Check01");
		data("xpath", "//*[@id=\"AS_1_294\"]/div/div[6]/div/div/textarea", "This is test Automation Record");
		
		click_button("xpath", "//div[11]//div[1]//div[2]//button[1]");
		
		data("name", "Name", "Acme Corp");
		click_button("xpath", "//div[@class='vis-info-btnleft']//button[@class='VIS_Pref_btn-2']");
		click_button("xpath", "/html/body/div[9]/div[2]/div[1]/div[2]/div/div[3]/div[1]/table/tbody/tr[3]/td[2]/div/input");
		click_button("xpath", "//button[contains(text(),'OK')]");
		
		click_button("xpath", "//div[17]//div[1]//span[2]");
		click_button("name", "M_Warehouse_ID");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='vis-control-wrap']//option[contains(text(),'HQ Warehouse Dis (True)')]"))).click();

		click_button("name", "M_Warehouse_ID");
		Thread.sleep(2000);
		System.out.println("Check02");
		click_button("xpath", "//div[28]//div[1]//div[1]//select[1]");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[contains(text(),'Purchase Price List')]"))).click();

		click_button("xpath", "//div[36]//div[1]//span[2]");
		//payment method
		click_button("xpath", "//div[37]//div[1]//div[1]//select[1]");
		click_button("xpath", "//div[37]//div[1]//div[1]//select[1]//option[1]");
		click_button("xpath", "//div[41]//div[1]//span[2]");
		click_button("xpath", "//div[46]//div[1]//span[2]");
		
		//click save button
		click_button("xpath", "//i[@class='vis vis-save']");
		
		click_button("xpath", "//div[@class='vis-ad-w-p-nav']//li[3]");	
		click_button("xpath", "//i[@class='vis vis-cross']");
		System.out.println("Check03");
		//menu search
		wait.until(ExpectedConditions.elementToBeClickable(By.id("vis_appMenu"))).click();
		
		//Declare cache reset method
		
		cache_reset();
		
		//menu search
		wait.until(ExpectedConditions.elementToBeClickable(By.id("vis_appMenu"))).click();
		
		//purchase order
		WebElement ele2 = driver.findElement(By.id("vis_menuSearch"));
		ele2.sendKeys("Purchase Order");
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ul/li[1]/div"))).click();
		
		click_button("xpath", "//div[@class='vis-ad-w-p-nav']//li[3]//div[1]");
		System.out.println("Check04");
		
		
		
	}
	
	public void po_tab() {
		
		click_button("xpath", "//span[contains(text(),'PO Line')]");
		
		
		
		
		
	}


}
