package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
	
	public WebDriver driver;
	
	

	By email = By.cssSelector("input[type='email']");
	By pwd = By.id("user_password");
	By sign = By.cssSelector("input[name='commit']");
	
	public Login(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement email() {
		
		return driver.findElement(email);
	}
	
	public WebElement password() {
		
		return driver.findElement(pwd);
	}
	
    public WebElement login() {
		
		return driver.findElement(sign);
	}
}
