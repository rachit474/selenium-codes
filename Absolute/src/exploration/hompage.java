package exploration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;


public class hompage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://development.view9.com.au/clients/absolute");
		
		driver.findElement(By.tagName("img")).getAttribute("alt");
		
		
		
		

	}
	
	@SuppressWarnings("unused")
	private boolean isAttribtuePresent(WebElement element, String alt) {
	    Boolean result = false;
	    try {
	        String value = element.getAttribute(alt);
	        if (value != null){
	            result = true;
	            System.out.println("alt tag not found");
	        }
	    } catch (Exception e) {}

	    return result;
	    
	   
	}

}
