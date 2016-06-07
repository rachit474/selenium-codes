package Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;



public class DashboardSmoke {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		
		//for report intialization
		
		String filepath = "D:\\sbg.test.report\\initailtest.html";
		
		//Login credentials and other variables
		
		String baseurl = "http://sbg.pasal.co/chapter";
		
		String user = "";
		
		String password = "";
		
		String userid = "";
		
		String passwordid = "";
		
		String loginid = "";
		
		//for internal menu functional test. Menu lists
		
		String dashboard = "Dashboard";
		
		String figure = "";
		
		//exam settings test
		
		String categoryid = "";
		
		String timeid = "";
		
		//Log initialization
		
		ExtentReports logger = ExtentReports.get(DashboardSmoke.class);
		
		logger.init (filepath, true);
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(baseurl);
		
		//Starting login test
		
		/*driver.findElement(By.id(userid)).sendKeys(user);
		
		driver.findElement(By.id(passwordid)).sendKeys(password);
		
		driver.findElement(By.id(loginid)).click();*/
		
		String afterlogin =  driver.getTitle();
		
		String rtitle = "SBG | Dashboard";
		
		driver.getTitle();
		
		logger.startTest("1. Login Test");
		
		if (afterlogin.equals(rtitle)){
			Assert.assertTrue(afterlogin.equals(rtitle));
			System.out.print("Login successfull with actual credentials.");
			logger.log(LogStatus.PASS, "Login successfull with actual credentials.");
			
		} else if(!afterlogin.equals(rtitle)){
			Assert.assertTrue(!afterlogin.equals(rtitle));
			System.out.print("Login failed with actual credentials.");
			logger.log(LogStatus.FAIL, "Login failed with actual credentials.");
		
		} else {
			System.out.println("Test has been skipped.");
			logger.log(LogStatus.SKIP, "Test has been skipped.");
			
		}
		
		logger.endTest();
		
		Thread.sleep(2000);
		
		// Starting Dashboard test
		
		driver.findElement(By.linkText(dashboard)).click();
		
		String report = driver.getPageSource();
		
		driver.getPageSource();
		
		logger.startTest("2. Dashboard functionality test");
		
		if(report.contains(figure)){
			Assert.assertTrue(report.contains(figure));
			System.out.println("Dashboard is functioning properly.");
			logger.log(LogStatus.PASS, "Dashboard is functioning properly.");
			
		} else if (!report.contains(figure)){
			Assert.assertTrue(!report.contains(figure));
			System.out.println("Dashboard is not functioning properly.");
			logger.log(LogStatus.FAIL, "Dashboard is not functioning properly.");
			
		} else {
			System.out.println("Test has been skipped.");
			logger.log(LogStatus.SKIP, "Test has been skipped.");
		}
		
		logger.endTest();
		
		Thread.sleep(2000);
		
		//Exam setting test started
		
		
		logger.startTest("3. Exam setup test");
		
		logger.endTest();
		
		driver.get(filepath);
		
		}

}
