import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.Login;
import PageObject.landingPage;
import Resources.base;



public class validateAssertions extends base{
	public static Logger log =LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	@BeforeTest
	
	  public void Intilize() throws IOException {
		driver = intilizatondriver();
		
		driver.get(p.getProperty("url"));
		
	}
	
	@Test
	public void validate() throws IOException {
		
		
		
		landingPage lp = new landingPage(driver);
				
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES12");
		
		log.info("validated in sucessfully");
	}
	
    @AfterTest
	
	public void teardown() {
		
		driver.close();
	}
}
