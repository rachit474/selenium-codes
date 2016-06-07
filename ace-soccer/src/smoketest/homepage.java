package smoketest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class homepage {

	public static void main(String[] args) {
		
	// TODO Auto-generated method stub
		
		// List of tests and pass/fail messages
		
		//Skip message
		
		String skipmessage = "Test has been skipped.";
		
			//Test 1
		
		String test1 = "1. Loadtime verification";
		
		int parameter = 3;
				
		String test1pass = "Page is loading in" ;
				
		String test1fail = "Page is loading in";
		
			//Test 2
		
		String test2 = "2. Page title verification";
		
		String pagetitle = "Ace soccer";
				
		String test2pass = "Page title has been verified.";
				
		String test2fail = "Page title has not been verified.";
		
			//Test 3
		
		String test3 = "3. Login and Logout link verification";
				
		String login = "LOGIN";
		
		String logout = "LOGOUT";
						
		String test3pass = "There is a logout option as well.";
						
		String test3fail = "There is no logout option.";
		
			//intializing webdriver
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		
			//Test report filepath intialization
		
		String filepath = "D:\\ace-soccer\\test-reports\\homepage.html";
		
		String homepage = "http://development.view9.com.au/acesoccer";
		
			//Initializing logger
		
		ExtentReports logger = ExtentReports.get(homepage.class);
		
		logger.init (filepath, true);
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		long start = System.currentTimeMillis();
		
		driver.get(homepage);
		
		//all required function
		
		String actualtitle = driver.getTitle();
		
		long finish = System.currentTimeMillis();
		
		long totalTime = finish - start; 
		
		long actualloadtime = totalTime/1000;
		
		logger.startTest(test1);
		
		if (actualloadtime<=parameter){
			Assert.assertTrue(actualloadtime<=parameter);
			System.out.println(test1pass+" "+actualloadtime+" seconds.");
			logger.log(LogStatus.PASS, test1pass+" "+actualloadtime+" seconds.");
		} else if (actualloadtime>parameter){
			Assert.assertTrue(actualloadtime>parameter);
			System.out.println(test1fail+" "+actualloadtime+" seconds.");
			logger.log(LogStatus.FAIL, test1fail+" "+actualloadtime+" seconds.");
		} else {
			System.out.println(skipmessage);
			logger.log(LogStatus.SKIP, skipmessage);
		}
		
		logger.endTest();
		
		driver.getTitle();
		
		logger.startTest(test2);
		
		if (actualtitle.equals(pagetitle)){
			Assert.assertTrue(actualtitle.equals(pagetitle));
			System.out.println(test2pass);
			logger.log(LogStatus.PASS, test2pass);
			
		} else if (!actualtitle.equals(pagetitle)){
			Assert.assertTrue(!actualtitle.equals(pagetitle));
			System.out.println(test2fail);
			logger.log(LogStatus.FAIL, test2fail); 
		
		} else {
			System.out.println(skipmessage);
			logger.log(LogStatus.SKIP, skipmessage);
		}
		
		logger.endTest();
		
		String options = driver.getPageSource();
		
		driver.getPageSource();
		
		logger.startTest(test3);
		
		if (options.contains(login)&&!options.contains(logout)){
			Assert.assertTrue(options.contains(login)&&!options.contains(logout));
			System.out.println(test3fail);
			logger.log(LogStatus.FAIL, test3fail);
			
		} else if (options.contains(login)&&options.contains(logout)){
			Assert.assertTrue(options.contains(login)&&options.contains(logout));
			System.out.println(test3pass);
			logger.log(LogStatus.PASS, test3pass);
			
		} else {
			System.out.println(skipmessage);
			logger.log(LogStatus.SKIP, skipmessage);
		}
		
		logger.endTest();
		
		//Tests ended
		
		//Final report opening
		
		WebDriver report = new ChromeDriver ();
		
		report.manage().window().maximize();
		
		report.get(filepath);
		
		

	}

}