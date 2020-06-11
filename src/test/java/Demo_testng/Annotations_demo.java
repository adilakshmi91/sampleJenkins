package Demo_testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations_demo {
	@BeforeSuite
	public void m1() {
		System.out.println("m1 @beforesuite");
	}
	@BeforeClass
   public void m2() {
	   System.out.println("m1 @beforeclass");
   }
	@BeforeTest
	public void m3() {
		System.out.println("m3 @beforetest");
	}
	@BeforeMethod
	public void  m4() {
		System.out.println("m4 @beforemethod");
		}
	@Test
	public void m5() {
		System.out.println("m5 @test");
	}
	@AfterSuite
	public void m6() {
		System.out.println("m6 @aftersuite");
	}
	@AfterClass
	public void m7() {
		System.out.println("m7 @afterclass");
	}
	@AfterTest
	public void m8() {
		System.out.println("m8 @aftertest");
		
	}
	@AfterMethod
	public void m9() {
		System.out.println("m9 @aftermethod");
	}
	
	
	
	

}
