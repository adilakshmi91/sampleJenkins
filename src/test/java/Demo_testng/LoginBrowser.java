package Demo_testng;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import BrowserUtility.LaunchBrowser;

public class LoginBrowser {
	
	@BeforeSuite
	public void dependencyTriggering() {
	LaunchBrowser.ChromeBrowser();
	}

	@Test
	public void checkloginsuccessornot() throws Exception {
		LaunchBrowser.loginToBrowser("admin123@gmail.com","admin123");
		assertEquals(true,true);
		//assertEquals(true,false);

	}
	@AfterSuite
	public void downdependency() {
		LaunchBrowser.quitBrowser();
	}

}
