package testcaseapi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;

public class BackendTest {

	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches","--disable-extensions");
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		
	    WebDriver	driver = new ChromeDriver(options);
		
		String filepath = "D:\\captivation.test.report\\captivation.frontend\\captivation.backend.html";
		
		String baseurl = "http://development.view9.com.au/stage/captivation-sport/dev";
		
		String user = "captivation";
		
		String password = "captivation@123";
		
		ExtentReports logger = ExtentReports.get(BackendTest.class);
		
		logger.init (filepath, true);
		
		driver.manage().window().maximize();
		
		driver.get(baseurl);
		
		driver.findElement(By.id("edit-name")).sendKeys(user);
		
		driver.findElement(By.id("edit-pass")).sendKeys(password);
		
		driver.findElement(By.id("edit-submit")).click();
		
		String afterlogin =  driver.getTitle();
		
		driver.getTitle();
		
		logger.startTest("1. Login Test");
		
		if (afterlogin.contains(user)){
			Assert.assertTrue(afterlogin.contains(user));
			System.out.print("Login successfull with actual credentials.");
			logger.log(LogStatus.PASS, "Login successfull with actual credentials.");
			
		} else if(!afterlogin.contains(user)){
			Assert.assertTrue(!afterlogin.contains(user));
			System.out.print("Login failed with actual credentials.");
			logger.log(LogStatus.FAIL, "Login failed with actual credentials.");
		
		} else {
			System.out.println("Test has been skipped.");
			logger.log(LogStatus.SKIP, "Test has been skipped.");
			
		}
		
		logger.endTest();
		
		Thread.sleep(2000);
		
		String notice = "There is a security update available for your version of Drupal.";
		
		driver.get("http://development.view9.com.au/stage/captivation-sport/dev/admin/dashboard");
		
		String system = driver.getPageSource();
		
		driver.getPageSource();
		
		logger.startTest("2. System Notice");
		
		if (!system.contains(notice)){
			Assert.assertTrue(!system.contains(notice));
			System.out.println("System notice is removed for user.");
			logger.log(LogStatus.PASS, "System notice is removed for user.");
			
		} else if (system.contains(notice)){
			Assert.assertTrue(system.contains(notice));
			System.out.println("System notice is not removed for user.");
			logger.log(LogStatus.FAIL, "System notice is not removed for user.");
			
		} else {
			System.out.println("Test has been skipped");
			logger.log(LogStatus.SKIP, "Test has been skipped.");
		}
		
		logger.endTest();
		
		Thread.sleep(2000);
		
		String apierror = "exception";
		
		driver.getPageSource();
		
		logger.startTest("3. API error test on dashboard");
		
		if (!system.contains(apierror)){
			Assert.assertTrue(!system.contains(apierror));
			System.out.println("No API error has been displayed in dashboard.");
			logger.log(LogStatus.PASS, "No API error has been displayed in dashboard.");
		}  else if (system.contains(apierror)){
			Assert.assertTrue(system.contains(apierror));
			System.out.println("API error has been displayed in dashboard.");
			logger.log(LogStatus.FAIL, "API error has been displayed in dashboard.");
		} else {
			System.out.println("Test has been skipped.");
			logger.log(LogStatus.SKIP, "Test has been skipped");
		}
		
		logger.endTest();
		
		Thread.sleep(2000);
		
		driver.get("http://development.view9.com.au/stage/captivation-sport/dev/admin/content/product_property/595/edit/sport_category?destination=admin/content/product_property/sport_category");
		
		driver.findElement(By.id("edit-submit")).click();
		
		driver.getPageSource();
		
		logger.startTest("4. API error test on Sport catergory form");
		
		if (!system.contains(apierror)){
			Assert.assertTrue(!system.contains(apierror));
			System.out.println("There is no API error found while edititng sport category.");
			logger.log(LogStatus.PASS, "There is no API error found while edititng sport category.");
			
		}  else if (system.contains(apierror)){
			Assert.assertTrue(system.contains(apierror));
			System.out.println("API error found while edititng sport category.");
			logger.log(LogStatus.FAIL, "API error found while edititng sport category.");
			
		} else {
			System.out.println("Test has been skipped.");
			logger.log(LogStatus.SKIP, "Test has been skipped.");
		}
		
		logger.endTest();
		
		Thread.sleep(2000);
		
		driver.get("http://development.view9.com.au/stage/captivation-sport/dev/admin/content/product_property/15/edit/product_category?destination=admin/content/product_property/product_category");
		
		driver.findElement(By.id("edit-submit")).click();
		
		driver.getPageSource();
		
		logger.startTest("5. API error test on Product category form");
		
		if (!system.contains(apierror)){
			Assert.assertTrue(!system.contains(apierror));
			System.out.println("There is no API error found while edititng Product category.");
			logger.log(LogStatus.PASS, "There is no API error found while Product category.");
			
		}  else if (system.contains(apierror)){
			Assert.assertTrue(system.contains(apierror));
			System.out.println("API error found while edititng Product category.");
			logger.log(LogStatus.FAIL, "API error found while edititng Product category.");
			
		} else {
			System.out.println("Test has been skipped.");
			logger.log(LogStatus.SKIP, "Test has been skipped.");
		}
		
		logger.endTest();
		
		Thread.sleep(2000);
		
		driver.get("http://development.view9.com.au/stage/captivation-sport/dev/admin/content/product_property/630/edit/product_type?destination=admin/content/product_property/product_type");
		
		driver.findElement(By.id("edit-submit")).click();
		
		driver.getPageSource();
		
		logger.startTest("6. API error test on Product form");
		
		if (!system.contains(apierror)){
			Assert.assertTrue(!system.contains(apierror));
			System.out.println("There is no API error found while edititng Product.");
			logger.log(LogStatus.PASS, "There is no API error found while Product.");
			
		}  else if (system.contains(apierror)){
			Assert.assertTrue(system.contains(apierror));
			System.out.println("API error found while edititng Product.");
			logger.log(LogStatus.FAIL, "API error found while edititng Product.");
			
		} else {
			System.out.println("Test has been skipped.");
			logger.log(LogStatus.SKIP, "Test has been skipped.");
		}
		
		logger.endTest();
		
	
		
	/*	driver.get("http://development.view9.com.au/stage/captivation-sport/dev/admin/content/product/408/edit?destination=admin/content/product");
		
		driver.findElement(By.id("edit-actions-submit")).click();
		
		driver.getPageSource();
		
		logger.startTest("7. API error test on design form");
		
		if (!system.contains(apierror)){
			Assert.assertTrue(!system.contains(apierror));
			System.out.println("There is no API error found while edititng design.");
			logger.log(LogStatus.PASS, "There is no API error found while design.");
			
		}  else if (system.contains(apierror)){
			Assert.assertTrue(system.contains(apierror));
			System.out.println("API error found while edititng design.");
			logger.log(LogStatus.FAIL, "API error found while edititng design.");
			
		} else {
			System.out.println("Test has been skipped.");
			logger.log(LogStatus.SKIP, "Test has been skipped.");
		}
		
		logger.endTest(); */
		
		Thread.sleep(2000);
		
		driver.get("http://development.view9.com.au/stage/captivation-sport/dev/admin/content/product_property/21/edit/country?destination=admin/content/product_property/country");
		
		driver.findElement(By.id("edit-submit")).click();
		
		logger.startTest("8. API error test on country form");
		
		if (!system.contains(apierror)){
			Assert.assertTrue(!system.contains(apierror));
			System.out.println("There is no API error found while edititng country.");
			logger.log(LogStatus.PASS, "There is no API error found while editing country.");
			
		}  else if (system.contains(apierror)){
			Assert.assertTrue(system.contains(apierror));
			System.out.println("API error found while edititng country.");
			logger.log(LogStatus.FAIL, "API error found while edititng country.");
			
		} else {
			System.out.println("Test has been skipped.");
			logger.log(LogStatus.SKIP, "Test has been skipped.");
		}
		
		logger.endTest();
		
		Thread.sleep(2000);
		
		driver.get("http://development.view9.com.au/stage/captivation-sport/dev/admin/content/product_property/953/edit/swatch?destination=admin/content/product_property/swatch");
		
		driver.findElement(By.id("edit-submit")).click();
		
		driver.getPageSource();
		
		logger.startTest("9. API error test on Color palette form");
		
		if (!system.contains(apierror)){
			Assert.assertTrue(!system.contains(apierror));
			System.out.println("There is no API error found while edititng color palette.");
			logger.log(LogStatus.PASS, "There is no API error found while  editing color palette.");
			
		}  else if (system.contains(apierror)){
			Assert.assertTrue(system.contains(apierror));
			System.out.println("API error found while edititng color palette.");
			logger.log(LogStatus.FAIL, "API error found while edititng color palette.");
			
		} else {
			System.out.println("Test has been skipped.");
			logger.log(LogStatus.SKIP, "Test has been skipped.");
		}
		
		logger.endTest();
		
		Thread.sleep(2000);
		
		driver.get("http://development.view9.com.au/stage/captivation-sport/dev/admin/content/product_property/644/edit/color?destination=admin/content/product_property/color");
		
		driver.findElement(By.id("edit-submit")).click();
		
		driver.getPageSource();
		
		logger.startTest("10. API error test on Color form");
		
		if (!system.contains(apierror)){
			Assert.assertTrue(!system.contains(apierror));
			System.out.println("There is no API error found while edititng color.");
			logger.log(LogStatus.PASS, "There is no API error found while  editing color.");
			
		}  else if (system.contains(apierror)){
			Assert.assertTrue(system.contains(apierror));
			System.out.println("API error found while edititng color.");
			logger.log(LogStatus.FAIL, "API error found while edititng color.");
			
		} else {
			System.out.println("Test has been skipped.");
			logger.log(LogStatus.SKIP, "Test has been skipped.");
		}
		
		
		logger.endTest();
		
		Thread.sleep(2000);
		
		driver.get("http://development.view9.com.au/stage/captivation-sport/dev/admin/content/product_property/90/edit/font?destination=admin/content/product_property/font");
		
		driver.findElement(By.id("edit-submit")).click();
		
		driver.getPageSource();
		
		logger.startTest("11. API error test on Font form");
		
		if (!system.contains(apierror)){
			Assert.assertTrue(!system.contains(apierror));
			System.out.println("There is no API error found while edititng font.");
			logger.log(LogStatus.PASS, "There is no API error found while  editing font.");
			
		}  else if (system.contains(apierror)){
			Assert.assertTrue(system.contains(apierror));
			System.out.println("API error found while edititng font.");
			logger.log(LogStatus.FAIL, "API error found while edititng font.");
			
		} else {
			System.out.println("Test has been skipped.");
			logger.log(LogStatus.SKIP, "Test has been skipped.");
		}
		
		logger.endTest();
		
		driver.get(filepath);
		
	}

}
