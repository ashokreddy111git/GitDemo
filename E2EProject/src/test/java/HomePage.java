import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import PageObject.Login;
import PageObject.landingPage;
import Resources.base;


public class HomePage extends base {
	
	public static void main(String[] args) {
		
	}
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	
	  public void Intilize() throws IOException {
		driver = intilizatondriver();
		
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password, String text) throws IOException {
		
		
		
		driver.get(p.getProperty("url"));
		
		landingPage lp = new landingPage(driver);
		lp.sign().click();
		log.info("logged in sucessfully");
		
		Login l = new Login(driver);
		
		l.email().sendKeys(Username);
		l.password().sendKeys("Password");
		log.info(text);
		l.login().click();
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] obj = new Object[2][3];
		
		obj[0][0] = "ashok@gmail.com";
		obj[0][1] = "12345";
		obj[0][2] = "restricteduser";
		
		obj[1][0] = "anil@gmail.com";
		obj[1][1] = "9876";
		obj[1][2] = "non restricted user";
		return obj;
	}
	
	@AfterTest
	
	public void teardown() {
		
		driver.close();
	}

}
