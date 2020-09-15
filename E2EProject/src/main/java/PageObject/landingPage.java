package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
	
	public WebDriver driver;
	
	public landingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
	}

   	
	By sig = By.cssSelector("a[href*='sign_in']");
	
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By nav = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	public WebElement sign() {
		
		return driver.findElement(sig);
		
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getnavigation() {
		return driver.findElement(nav);
	}

}
