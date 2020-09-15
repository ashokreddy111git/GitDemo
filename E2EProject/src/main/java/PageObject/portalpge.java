package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalpge {
	
	public WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public portalpge(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By se = By.name("Querry");
	
	public WebElement getsearchbox() {
		
		return driver.findElement(se);
	}

}
