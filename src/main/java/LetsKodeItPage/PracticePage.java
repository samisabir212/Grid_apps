package LetsKodeItPage;

import static org.junit.Assert.assertArrayEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import generic.Common_API;

public class PracticePage extends Common_API {

	@FindBy(id = "carselect")
	public WebElement dropDownList;

	@FindBy(id = "openwindow")
	public WebElement openWindow;
	
	@FindBy(id= "search-courses")
	WebElement iframe_searchCourseField;
	
	
	String iframe_ID = "filepicker_comm_iframe";

	public void verifyDropDownList() {

		click(By.id("carselect"));
		System.out.println("clicked on element");
		int i = 0;
		Select make = new Select(driver.findElement(By.id("carselect")));

		List<String> expected_options = Arrays.asList(new String[] { "BMW", "Benz", "Honda" });
		List<String> actual_options = new ArrayList<String>();
		for (WebElement o : make.getOptions()) {
			System.out.println("element index +" + i + "is " + o.getText());
			actual_options.add(o.getText());
			i++;
		}

		// use assertion to assert actual array list and expected array list
		assertArrayEquals(expected_options.toArray(), actual_options.toArray());

	}
	

	public void veridyOpenWindowbtn() throws InterruptedException {
		// Get the handle
		String parentHandle = driver.getWindowHandle();
		System.out.println("Parent Handle: " + parentHandle);

		// Find Open Window button
		WebElement openWindow = driver.findElement(By.id("openwindow"));
		openWindow.click();

		// Get all handles
		Set<String> handles = driver.getWindowHandles();

		// Switching between handles
		for (String handle : handles) {
			System.out.println(handle);
			if (!handle.equals(parentHandle)) {
				driver.switchTo().window(handle);
				Thread.sleep(2000);
				WebElement searchBox = driver.findElement(By.id("search-courses"));
				searchBox.sendKeys("python");
				Thread.sleep(2000);
				driver.close();
				break;
			}
		}
		// Switch back to the parent window
		driver.switchTo().window(parentHandle);
		driver.findElement(By.id("name")).sendKeys("Test Successful");

	}

	public void countAllLinks() {

		List<WebElement> a = driver.findElements(By.xpath(".//a"));

		for (WebElement link : a) {
			System.out.println(link.getText());
		}

	}

	public void switch_To_Iframe() throws InterruptedException {


		Thread.sleep(3000);
		// Switch to frame by Id
		driver.switchTo().frame("courses-iframe");
		// Switch to frame by name
		//driver.switchTo().frame("iframe-name");
		// Switch to frame by numbers
		//driver.switchTo().frame(0);
		
		WebElement searchBox = driver.findElement(By.id("search-courses"));
		searchBox.sendKeys("python");
		
		driver.switchTo().defaultContent();
		Thread.sleep(6000);
		driver.findElement(By.id("name")).sendKeys("Test Successful");
		
	}


	public void countRadioButtons() {
		List<WebElement> radioButtons = driver.findElements(By.name("cars"));

		for(WebElement radioButton : radioButtons ) {
		
			if(radioButton.getAttribute("value").equals("BMW") || 
					radioButton.getAttribute("value").equals("Benz") ||
					radioButton.getAttribute("value").equals("Honda")
					){
				radioButton.click();
				assertTrue(radioButton.isSelected());
			}
		}

		
	}

}
