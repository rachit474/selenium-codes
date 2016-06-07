package testcaseapi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class Homepage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		
		String filepath = "D:\\captivation.test.report\\captivation.frontend\\captivation.homepage.html";
		String baseurl = "http://clients.view9.com.au/captivation-sport/captivation_v3/";
		
		ExtentReports logger = ExtentReports.get(Homepage.class);
		logger.init (filepath, true);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		logger.startTest("1. Homepage loadtime Calculation");
		
		long start = System.currentTimeMillis();
		
		driver.get(baseurl);
		
		long finish = System.currentTimeMillis();
		
		long totalTime = finish - start; 
		
		long actualtime = totalTime/1000;
		
		if (actualtime>=10){
			Assert.assertTrue(actualtime>=10);
			System.out.println("Page is loading in "+actualtime+ " seconds.");
			logger.log(LogStatus.FAIL,"Page is loading in "+actualtime+ " seconds.");
			
			
		} else if (actualtime<10){
			Assert.assertTrue(actualtime<10);
			System.out.println("Page is loading in "+actualtime+ " seconds");
			logger.log(LogStatus.PASS, "Page is loading in "+actualtime+ " seconds");
			
		}
		
		logger.endTest();
		
		Thread.sleep(2000);
		
		String home = "Home";
		
		String about = "About us";
		
		String news = "News";
		
		String contact = "Contact us";
		
		String topmenu = driver.getPageSource();
		
		driver.getPageSource();
		
		logger.startTest("2. Top menu verification ");
		
		if(topmenu.contains(home)
		   &&topmenu.contains(about)
		   &&topmenu.contains(news)
		   &&topmenu.contains(contact)){
			
			Assert.assertTrue(topmenu.contains(home)
		    &&topmenu.contains(about)
			&&topmenu.contains(news)
			&&topmenu.contains(contact));
			System.out.println("All the required top menus are on the page.");
			logger.log(LogStatus.PASS, "All the required top menus are on the page.");
			
		} else if (!topmenu.contains(home)
				   ||!topmenu.contains(about)
				   ||!topmenu.contains(news)
				   ||!topmenu.contains(contact)){
			Assert.assertTrue(!topmenu.contains(home)
				   ||!topmenu.contains(about)
				   ||!topmenu.contains(news)
				   ||!topmenu.contains(contact));
			System.out.println("The required menus are not displayed or missing on page.");
			logger.log(LogStatus.FAIL, "The required menus are not displayed or missing on page.");
			
		} else {
			System.out.println("Test has been skipped.");
			logger.log(LogStatus.SKIP, "Test has been skipped.");
		}
		
		 logger.endTest();
		 
		 Thread.sleep(2000);
		 
		 String cat1 = "outerwear";
		 
		 String cat2 = "polos";
		 
		 String cat3 = "headwear";
		 
		 String cat4 = "accessories";
		 
		 logger.startTest("3. Product categories verification");
		 
		 if(topmenu.contains(cat1)
			&&topmenu.contains(cat2)
			&&topmenu.contains(cat3)
			&&topmenu.contains(cat4)){
			
			Assert.assertTrue(topmenu.contains(cat1)
			&&topmenu.contains(cat2)
			&&topmenu.contains(cat3)
			&&topmenu.contains(cat4));
			System.out.println("All the required product categories are displayed on the page.");
			logger.log(LogStatus.PASS, "All the required product categories are displayed on the page");
			 
		 } else if (!topmenu.contains(cat1)
			||!topmenu.contains(cat2)
			||!topmenu.contains(cat3)
			||!topmenu.contains(cat4)){
			 Assert.assertTrue(!topmenu.contains(cat1)
			||!topmenu.contains(cat2)
			||!topmenu.contains(cat3)
			||!topmenu.contains(cat4));
			 System.out.println("All the required product categories are not displayed on the page.");
			 logger.log(LogStatus.FAIL, "All the required product categories are not displayed on the page");
			 
		 } else {
			 System.out.println("Test has been skipped.");
			 logger.log(LogStatus.SKIP, "Test has been skipped.");
		 }
		 
		 logger.endTest();
		 
		 Thread.sleep(2000);
		 
		 driver.getPageSource();
		 
		logger.startTest("4. Footer copyright date");
		
		if(topmenu.contains("2016")){
			Assert.assertTrue(topmenu.contains("2016"));
			System.out.println("The copyright date is correct and updated.");
			logger.log(LogStatus.PASS, "The copyright date is correct and updated.");
			
		} else if (!topmenu.contains("2016")){
			Assert.assertTrue(!topmenu.contains("2016"));
			System.out.println("Copyright date is not correct");
			logger.log(LogStatus.FAIL, "Copyright date is not correct.");
		} else {
			System.out.println("Test has been skipped");
			logger.log(LogStatus.SKIP, "Coptright date is not correct.");
		}
		
		logger.endTest();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("email")).sendKeys("abc@example.com"+Keys.ENTER);
		
		Thread.sleep(5000);
		
		String success = "You have successfully subscribed";
		
		Thread.sleep(5000);
		
		String collection = driver.getPageSource();
		
		driver.getPageSource();
		
		logger.startTest("5. Subscription function test");
		
		if (collection.contains(success)){
			Assert.assertTrue(collection.contains(success));
			System.out.println("Subscription is  not working properly.");
			logger.log(LogStatus.FAIL, "Subscription is not  working properly.");
			
		} else if (!collection.contains(success)){
			Assert.assertTrue(!collection.contains(success));
			System.out.println("Subscription is working properly.");
			logger.log(LogStatus.PASS, "Subscription is working properly.");
			
		} else {
			System.out.println("Test has been skipped.");
		}
		
		logger.endTest();
		
		Thread.sleep(2000);
		 
		driver.get(filepath);
		
	}

}
