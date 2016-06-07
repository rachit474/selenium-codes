package smoketest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.Assert;

public class Viewreport {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		
		String filepath = "D:\\accuweigh.test.report\\accuweigh.smoke.test\\smoke.test.html";
		
		String baseurl = "http://clients.view9.com.au/accuweigh/dev";
		
		ExtentReports logger = ExtentReports.get(Viewreport.class);
		
		logger.init (filepath, true);
		
		String issue13 = "13. on datatable - decimal places must match entered data.";
		
		String reporturl = "http://clients.view9.com.au/accuweigh/dev/reports/equip/4568/4478/d";
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(baseurl);
		
		String user = "admin";
		
		String password = "@ccuweigh";
		
		driver.findElement(By.id("edit-name")).sendKeys(user);
		
		driver.findElement(By.id("edit-pass")).sendKeys(password);
		
		driver.findElement(By.id("edit-submit")).click();
		
		driver.get(reporturl);
		
		String noreport = "Report for this equipment will be available soon.";
		
		String lead = driver.getPageSource();
		
		driver.getPageSource();
		
		logger.startTest(issue13);
		
		if (lead.contains(noreport)){
			
			Assert.assertTrue(lead.contains(noreport));
			
			System.out.println("Issue has not been solved yet.");
			
			logger.log(LogStatus.FAIL, "Issue has not been solved yet.");
			
		} else if(!lead.contains(noreport)) {
			
			Assert.assertTrue(!lead.contains(noreport));
			
			System.out.println("Issue has been solved.");
			
			logger.log(LogStatus.PASS, "Issue has been solved.");
			
		} else {
			
			System.out.println("Test has been skipped.");
			
			logger.log(LogStatus.SKIP, "Test has been skipped.");
		}
		
		logger.endTest();
		
		WebDriver testreport = new ChromeDriver();
		
		testreport.manage().window().maximize();
		
		testreport.get(filepath);
		
		}

}
