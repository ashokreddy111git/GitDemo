package StepDefinations;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import PageObject.Login;
import PageObject.landingPage;
import PageObject.portalpge;
import Resources.base;

@RunWith(Cucumber.class)
public class stepDefination extends base  {
	
	public WebDriver driver;

    @Given("^Initialize the browser with chrome$")
    public void initialize_the_browser_with_chrome() throws Throwable {
    	driver = intilizatondriver();
    }
    @When("^User enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
    	Login l = new Login(driver);
		
		l.email().sendKeys(username);
		l.password().sendKeys(password);
		l.login().click();
    }
   
     
    @Then("^Verify that user is succesfully logged in$")
    public void verify_that_user_is_succesfully_logged_in() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	portalpge p = new portalpge(driver);
        Assert.assertTrue(p.getsearchbox().isDisplayed());
    }

    @And("^Navigate to \"([^\"]*)\" Site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
    	driver.get(strArg1);
    }

    @And("^Click on Login link in home page to land on Secure sign in Page$")
    public void click_on_login_link_in_home_page_to_land_on_secure_sign_in_page() throws Throwable {
    	landingPage lp = new landingPage(driver);
		lp.sign().click();
    }
    @And("^close all browsers$")
    public void close_all_browsers() throws Throwable {
        driver.quit();
    }

}