package Demo_testng;

import org.testng.annotations.Test;

public class TC_groups1 {
	
		@Test
		public void TC_login() {
			System.out.println("TC_login");
		}
		@Test(groups="sanity")
		public void TC_login1() {
			System.out.println(" TC_login1");
		}


	}


