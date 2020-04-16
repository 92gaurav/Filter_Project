package Filter;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Credentials extends Browser {
	
	@FindBy (how=How.ID, using="loginName")
	private WebElement username;
	
	@FindBy (how = How.ID, using="txtPwd")
	private WebElement pass;
	
	@FindBy (how=How.ID, using="btnLogin1")
	WebElement loginbtn;
	
	@Test
	public void login(String name, String password) {
		
		username.sendKeys(name);
		pass.sendKeys(password);
		loginbtn.click();
		
	}
	@Test
	public void title() {
		
		String title = driver.getTitle();
		System.out.println("Web Page Title : "+title);
		
	}

}
