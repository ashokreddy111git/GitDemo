package Resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {
	
	public WebDriver driver;
	
	public Properties p;
	
	public WebDriver intilizatondriver() throws IOException {
		
		 p = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Anil\\eclipse-workspace\\E2EProject\\src\\main\\java\\Resources\\data.properties");
		p.load(fis);
		
		//String browsertype= System.getProperty("browser");
		String browsertype= p.getProperty("browser");
		
		
		if(browsertype.contains("Chrome")){
			
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
		if(browsertype.contains("headless")) {
			
			options.addArguments("headless");
		}
			
			 driver= new ChromeDriver(options);
			
		}
		
		else if(browsertype.equals("firefox")){
			
						
		}
		else if(browsertype.equals("ie")){
			
						
		}
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;


	}

}
