package Demo_testng;

import org.testng.annotations.Test;

public class TC_groups {
		@Test(groups="sanity")
		public void TC_home_login() {
			System.out.println("TC_home_login");
		}
		@Test
		public void TC_home_login1() {
			System.out.println(" TC_home_login1");
		}
	}




