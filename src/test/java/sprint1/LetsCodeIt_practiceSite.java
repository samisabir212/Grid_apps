package sprint1;

import org.testng.annotations.Test;

import LetsKodeItPage.PracticePage;
import generic.Common_API;

public class LetsCodeIt_practiceSite extends Common_API {
	
	protected PracticePage practicePage = new PracticePage();

	
	@Test(groups="DontRun")
	public void dropdownlist() {
				
		practicePage.verifyDropDownList();

	}
	
	@Test(groups="DontRun")
	public void multipleWindowTest() throws InterruptedException {
		practicePage.veridyOpenWindowbtn();
		
	}
	
	
	@Test(groups="Dont Run")
	public void getAllLinks() {
		
		practicePage.countAllLinks();
		
		
	}
	
	
	@Test(groups="Dont Run")
	public void switchToIframe() throws InterruptedException {
		practicePage.switch_To_Iframe();
	}
	
	@Test(groups="P1")
	public void countRadiosButtons() {
		
		practicePage.countRadioButtons();
	}

}
