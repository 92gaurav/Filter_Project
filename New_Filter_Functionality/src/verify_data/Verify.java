package verify_data;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Filter.Browser;
import Filter.Credentials;
import Filter_Panel.Check_Filter;

public class Verify {
	
	static WebDriver driver;
	
	@AfterClass
	public void alldata() {
	
		WebDriver driver = Browser.brow("http://112.196.94.132:1702/");
		Credentials cre = PageFactory.initElements(driver, Credentials.class);
		cre.login("IdeasIncAdmin", "AdminIncIdeas");
		cre.title();
	
	}
	
	@Test
	public void afterlogin() throws NullPointerException {
		
		Check_Filter fil = PageFactory.initElements(driver, Check_Filter.class);
		
		try {
			fil.menu();
			fil.po_tab();
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[]arg) throws NullPointerException {
		
		Verify obj = new Verify();
		obj.alldata();
		obj.afterlogin();
	}

}
