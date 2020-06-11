package Demo_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BrowserUtility.LaunchBrowser;

public class Data_provider {
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

	@Test(dataProvider="Data_UsernameAndPassword")
	public void validloginsucessornot(String username ,String password) throws Exception{
	
		LaunchBrowser.loginToBrowser(username,password);
		
	}
	@DataProvider(name="Data_UsernameAndPassword")
	public Object[][] usernamePassword_dp(){
    return new Object[][] {{"admin123@gmail.com","admin123"},{"admin111@gmail.com.com","admin"},{"a@gmail.com","a"}};
	}
	@AfterSuite
	public void downdependency() {
		LaunchBrowser.quitBrowser();
	}


}



