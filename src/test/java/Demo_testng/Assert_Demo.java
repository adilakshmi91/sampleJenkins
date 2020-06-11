package Demo_testng;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class Assert_Demo {
	@Test
	public void alogin() {
		System.out.println("login sucessfully");
		assertEquals(true,true);
		//assertEquals(false,true);
		
	}
	@Test
	public void bhomescreen() {
		System.out.println("home screen is displayed sucessfully");
	}

}
