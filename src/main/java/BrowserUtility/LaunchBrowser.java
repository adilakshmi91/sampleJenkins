package BrowserUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static WebDriver driver;
	
	public static void ChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.get("https://qa-tekarch.firebaseapp.com/"); 

	}
	public static void quitBrowser(){
		driver.quit();
  }
	public static  void loginToBrowser(String sUserName, String sPassword) throws Exception{
		driver.get("https://qa-tekarch.firebaseapp.com/"); 
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("email_field"))));
		//driver.findElement(By.id("email_field")).sendKeys("admin123@gmail.com");
		driver.findElement(By.id("email_field")).clear();
		driver.findElement(By.id("email_field")).sendKeys(sUserName);
		//driver.findElement(By.xpath("//input[@placeholder='Password...']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@placeholder='Password...']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Password...']")).sendKeys(sPassword);
	
		driver.findElement(By.xpath("//button[contains(text(),'Login to Account')]")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Switch To')]"))));
   }
	static void waitForPageElementToVisible(WebElement eleToWait) {
		WebDriverWait wait = new WebDriverWait(LaunchBrowser.driver, 30);
		wait.until(ExpectedConditions.visibilityOf(eleToWait));
		
	}
}


