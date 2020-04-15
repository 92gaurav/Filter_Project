package Filter_Panel;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Filter.Element_Locator;

public class Check_Filter extends Element_Locator {
	
	static WebDriverWait wait = new WebDriverWait(driver, 30);
	static JavascriptExecutor js = (JavascriptExecutor) driver;

	
	@Test
	public void menu() throws NullPointerException, InterruptedException {
		
		System.out.println("Menu method is working");
		System.out.println("driver=" + driver); 

		wait.until(ExpectedConditions.elementToBeClickable(By.id("vis_appMenu"))).click();
		
		WebElement ele = driver.findElement(By.id("vis_menuSearch"));
		ele.sendKeys("Purchase Order");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ul/li[1]/div"))).click();
		System.out.println("Check");
		
		click_button("xpath", "//div[@class='vis-ad-w-p-nav']//li[3]//div[1]");
		click_button("xpath", "//span[contains(text(),'New Record')]");

		click_button("xpath", "//div[@class='vis-ad-w-p-nav']//li[3]//div[1]");
		
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
		String text_payment = "Payment Method";
		WebElement payment_text = driver.findElement(By.xpath("//label[contains(text(),'Payment Method')]"));
		String get_text = payment_text.getText();
		System.out.println("Text of Payment method :"+get_text);
		
		if(get_text.equalsIgnoreCase(text_payment)){
		
			click_button("xpath", "//div[37]//div[1]//div[1]//select[1]");
			click_button("xpath", "//div[37]//div[1]//div[1]//select[1]//option[1]");
			System.out.println("Run 37 xpath ");
		}
		
		else {
			click_button("xpath", "//div[38]//div[1]//div[1]//select[1]");
			click_button("xpath", "//div[38]//div[1]//div[1]//select[1]//option[1]");
			System.out.println("Run 38 xpath");
		}
		click_button("xpath", "//div[41]//div[1]//span[2]");
		click_button("xpath", "//div[46]//div[1]//span[2]");
		
		//click save button
		click_button("xpath", "//i[@class='vis vis-save']");
		
		//close purchase window 
		
//		click_button("xpath", "//div[@class='vis-ad-w-p-nav']//li[3]");	
//		click_button("xpath", "//i[@class='vis vis-cross']");
//		System.out.println("Check03");
//		//menu search
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("vis_appMenu"))).click();
//		
//		//Declare cache reset method
//		cache_reset();
//		
//		//menu search
//		wait.until(ExpectedConditions.elementToBeClickable(By.id("vis_appMenu"))).click();
//		
//		//purchase order
//		WebElement ele2 = driver.findElement(By.id("vis_menuSearch"));
//		ele2.sendKeys("Purchase Order");
//		
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/ul/li[1]/div"))).click();
//		
//		click_button("xpath", "//div[@class='vis-ad-w-p-nav']//li[3]//div[1]");
//		System.out.println("Check04");
			
	}
	
	public void po_tab() throws InterruptedException {
		
		//creating PO Line
		click_button("xpath", "//span[contains(text(),'PO Line')]");
		
		System.out.println("trying to read");
		
		WebElement web_ele = driver.findElement(By.xpath("//i[@class='glyphicon glyphicon-remove']"));
		System.out.println("its reading");
		if(web_ele.isDisplayed()) {
			
			web_ele.click();
			System.out.println("Element found and clicked");
		}
		
		else {
			System.out.println("Element not visible");	
		}
					
		//here we need to add for loop with data driven framework in this code
		
		Xls_Reader reader = new Xls_Reader("E:\\Testing\\Excel\\Po_Line_Data.xlsx");
		String pass = "Pass";
		String fail = "Fail";
		String s = "on";
		 int i = 2;
		//for(int i=2;i<=6;i++) 
			while(i <= 6 || i!= 1){
			
			String check = reader.getCellData("po_data", "case", i);
			System.out.println("Printing Case :"+check);
			System.out.println("Value of i : "+i);
			
			if (check.equalsIgnoreCase(s)) {
				
				String mypro = reader.getCellData("po_data", "product", i);
				System.out.println("List of Product : "+mypro);
				click_button("xpath", "//i[@class='vis vis-product']");
				Thread.sleep(2000);
				data("xpath", "//input[@name='Name']", mypro);
				click_button("xpath", "//button[@class='VIS_Pref_btn-2']//i[@class='vis vis-refresh']");
				click_button("xpath", "/html/body/div[9]/div[2]/div[1]/div[2]/div/div[3]/div[1]/table/tbody/tr[3]/td[2]/div/input");
				click_button("xpath", "//button[contains(text(),'OK')]");
				
				data("xpath", "//div[@class='input-group vis-input-wrap vis-ev-full-h']//textarea[contains(@placeholder,'')]", "Automation Test PO Line");
				
				
				if(i==2){	

				//click quantity show more
				click_button("xpath", "//div[18]//div[1]//span[2]");
			
				}
				
				String quan = reader.getCellData("po_data", "quantity", i);
				System.out.println("List of Quantity : "+quan);
				Thread.sleep(2000);
				//driver.findElement(By.name("QtyEntered")).clear();
				//Thread.sleep(5000);
				data("name", "QtyEntered", quan);
				
				
				boolean print1 = reader.setCellData("po_data", "result", i, pass);
				System.out.println("Printing testcase : "+print1);
			}
				else {
					boolean print2 = reader.setCellData("po_data", "result", i, fail);
				System.out.println("Printing test case : "+print2);
				}
				
			if (i==2) {
			//click tax show more		
				click_button("xpath", "//div[27]//div[1]//span[2]");	
			}
			
			if(i==2 || i==4) {
				click_button("xpath", "//div[32]//div[1]//div[1]//select[1]");
			click_button("xpath", "//option[contains(text(),'GST @ 5%')]");
			}
			
			if(i==3 || i==5) {
				click_button("xpath", "//div[32]//div[1]//div[1]//select[1]");
			click_button("xpath", "//option[contains(text(),'VAT @ 4%')]");	
			}
			
			if(i==6 || i==7) {
				click_button("xpath", "//div[32]//div[1]//div[1]//select[1]");	
			click_button("xpath", "//option[contains(text(),'Standard')]");
			}
			
	/*	//For single PO Line (select a product in PO Line)
		click_button("xpath", "//i[@class='vis vis-product']");
		Thread.sleep(2000);
		data("xpath", "//input[@name='Name']", "SFP Connector");
		click_button("xpath", "//button[@class='VIS_Pref_btn-2']//i[@class='vis vis-refresh']");
		click_button("xpath", "/html/body/div[9]/div[2]/div[1]/div[2]/div/div[3]/div[1]/table/tbody/tr[3]/td[2]/div/input");
		click_button("xpath", "//button[contains(text(),'OK')]");
		
		data("xpath", "//div[@class='input-group vis-input-wrap vis-ev-full-h']//textarea[contains(@placeholder,'')]", "Automation Test PO Line");
		
		click_button("xpath", "//div[18]//div[1]//span[2]");
		
		driver.findElement(By.name("QtyEntered")).clear();
		data("name", "QtyEntered", "20");
		click_button("xpath", "//div[27]//div[1]//span[2]");
		
		//select tax
		click_button("xpath", "//div[32]//div[1]//div[1]//select[1]");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[contains(text(),'GST @ 5%')]"))).click();
		*/
			
		if (i==2) {	
		//click on refrence show more
		click_button("xpath", "//div[34]//div[1]//span[2]");
		}
		
		if(i==2) {
		//clickon status show more
		click_button("xpath", "//span[contains(text(),'Show More')]");
		}
		
		//click save button
		click_button("xpath", "//i[@class='vis vis-save']");
		
		
		//create next po line
		click_button("xpath", "//span[contains(text(),'New Record')]");
		System.out.println("");
		i++;
		}
		
		click_button("xpath", "//div[@class='vis-ad-w-p-nav']//li[3]//div[1]");
		
		//click refresh search button
		click_button("xpath", "//i[@class='fa fa-search']");
		
	}
	
	

}
