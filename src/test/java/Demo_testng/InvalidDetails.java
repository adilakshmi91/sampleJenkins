package Demo_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import BrowserUtility.LaunchBrowser;

public class InvalidDetails {

	
	@BeforeSuite
	public void dependencyTriggering() {
	LaunchBrowser.ChromeBrowser();
	}
	@AfterMethod
	public void Logout() {
		if(LaunchBrowser.driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).isDisplayed())
		{
			LaunchBrowser.driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			WebDriverWait wait = new WebDriverWait(LaunchBrowser.driver, 30);
			wait.until(ExpectedConditions.visibilityOf(LaunchBrowser.driver.findElement(By.id("email_field"))));	
		}
	
	}
	@Test
	public void Invalidloginsuccessornot() throws Exception {
		LaunchBrowser.loginToBrowser("admin123@gmail.com","admin3");
		System.out.println("11111");
	}
	@Test
	public void validloginsucessornot() throws Exception{
	
		LaunchBrowser.loginToBrowser("admin123@gmail.com","admin123");
		System.out.println("22222");
	}
	@AfterSuite
	public void downdependency() {
		LaunchBrowser.quitBrowser();
	}


}
