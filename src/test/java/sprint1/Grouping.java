package sprint1;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.Common_API;

public class Grouping extends Common_API {
	
	
	
	//USER STORY :
	/*
	 * user should be able to login in with valid credintials
	 * 
	 */
	

	
	//TC001
	@Test(groups= {"P1"}, dataProvider="pages")
	public void TC001(String goToURL, String title) {
		driver.navigate().to(goToURL);
		Assert.assertEquals(driver.getTitle(), title);

	}
	
	//TC002
	@Test(groups= {"P2"})
	public void TC002() {
		System.out.println(" p2::tc002");

		
	}
	
	
	//TC003
	@Test(groups= {"Smoke"})
	public void TC003() {
		System.out.println(" Smoke::tc003");

		
	}
	
	
	//TC004
	@Test(dependsOnMethods=("TC002") ,groups= {"p3"})
	public void TC004() {
		System.out.println(" p3::Depends on tc0014");

		
	}
	
	
	
	//args:: URL title of page
	@DataProvider(name = "pages")
	public Object[][] pages(){
	
		return new Object[][] {
			{"http://www.facebook.com","Faceboo"},
			{"http://www.google.com","Google"},
			{"http://www.freecrm.com","FreeCrm"},
			
		};
		
		
	}
	
	
	

}
