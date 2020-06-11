package Demo_testng;

import org.testng.annotations.Test;

public class Login_DOM {
	@Test
	public void alogin() throws Exception {
		System.out.println("Login sucessfully");
		//throw new Exception("intentionally");
	}
	@Test(dependsOnMethods="alogin")
	public void bhome() {
		System.out.println("home screen is displayed");
	}
	@Test
    public void cactions() {
    	System.out.println("actions are performing");
    }
    @Test
    public void dlogout() {
    	System.out.println("logout scuccessfully");
    }
}
