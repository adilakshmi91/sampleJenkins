package Demo_testng;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aspose.cells.Workbook;
import com.aspose.cells.Worksheet;

import BrowserUtility.LaunchBrowser;

public class ReadExcel_dataProvider {
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
   @Test(dataProvider="asposetrainerInfo")
	public void validatingTrainerInfo(String emailid, String password) throws Exception {
	  LaunchBrowser.loginToBrowser(emailid, password);
		//System.out.println(emailid+"\t"+password);
	}
	
	@DataProvider(name="asposetrainerInfo")
	Object[][] trainerInfoFromExcel_aspose()throws Exception{
		String sFile = "C:\\Users\\adila\\OneDrive\\Desktop\\@testexcel.xlsx";
		 return readDataFromExcelSheet_aspose(sFile);
	}
	//open source free tools can be used anywhere. 
	private Object[][] readDataFromExcelSheet_aspose(String sFile) throws Exception {
		//Creating a file stream containing the Excel file to be opened
				FileInputStream fstream = new FileInputStream(sFile);
				
				//Instantiating a Workbook object
				Workbook workbook = new Workbook(fstream);
				
				//Accessing the first worksheet in the Excel file
				Worksheet worksheet = workbook.getWorksheets().get(0);
				
				//Exporting the contents of 7 rows and 2 columns starting from 1st cell to Array.
				 Object[][] dataTable = worksheet.getCells().exportArray(0,0,4,2);
				/*for (int i = 0 ; i < dataTable.length ; i++)
				{
					System.out.println("["+ i +"]: "+ Arrays.toString(dataTable[i]));
				}*/
				//Closing the file stream to free all resources
				 System.out.println("No. Of Rows Exported: " + dataTable.length);
				fstream.close();
		return dataTable;
	}
	@AfterSuite
	public void downdependency() {
		LaunchBrowser.quitBrowser();
	}
	

}





