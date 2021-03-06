package emergencies;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;




public class Emergencies {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		
		String filepath = "D:\\rough\\heifer\\emergenciestestreport.html";
		
		String baseurl = "http://heifernepal.org/emergencies/nepal-earthquake-2015";
		
		ExtentReports logger = ExtentReports.get(Emergencies.class);
		
		logger.init (filepath, true);
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(baseurl);
		
		String requiredcaption = "Our work in numbers";
		
		String lead = driver.getPageSource();
		
		driver.getPageSource();
		
		logger.startTest("1. Infographic caption verfication");
		
		if (lead.contains(requiredcaption)){
			Assert.assertTrue(lead.contains(requiredcaption));
			System.out.println("There is required caption for infographics.");
			logger.log(LogStatus.PASS, "There is required caption for infographics.");
			
		}  else {
			
			System.out.println("Test has been skipped.");
			logger.log(LogStatus.SKIP, "Test has been skipped.");
			
		}
		
		logger.endTest();
		
		
		//hamburger menu test/
		
		driver.get("http://heifernepal.org");
		
		Dimension n = new Dimension(360,700);  
		driver.manage().window().setSize(n);
		
		Thread.sleep(5000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1200)", "");
		
		Thread.sleep(5000);
		
		driver.findElement(By.className("menu-icon")).click();
		
		Thread.sleep(5000);
		
		String resmenu1 = "ENDING HUNGER & POVERTY";
		
		String responsivelinks = driver.getPageSource();
		
		driver.getPageSource();
		
		logger.startTest("2. Hamburger menu verification");
		
		if (responsivelinks.contains(resmenu1)){
			Assert.assertTrue(responsivelinks.contains(resmenu1));
			System.out.println("Hamburger menu is not working properly while scrolling down.");
			logger.log(LogStatus.FAIL, "Hamburger menu is not working properly while scrolling down.");
			
		} else if (!responsivelinks.contains(resmenu1)){
			Assert.assertTrue(!responsivelinks.contains(resmenu1));
			System.out.println("Hamburger menu is consistant and working properly.");
			logger.log(LogStatus.PASS, "Hamburger menu is consistant and working properly.");
			
		} else {
			System.out.println("Test has been skipped.");
			logger.log(LogStatus.SKIP, "Test has been skipped.");
		}
		
		logger.endTest();
		
		//implementing partners section
		
		driver.manage().window().maximize();
		
		driver.get("http://heifernepal.org/partners");
		
		
		
		String actualcontent = driver.findElement(By.id("implementing-partners")).getText();
		
		System.out.println(actualcontent);
		
		driver.findElement(By.id("implementing-partners")).getText();
		
		
		driver.getPageSource();
		
		logger.startTest("3. Implementing partners block verification");
		
		if (actualcontent.equals(null)){
			Assert.assertTrue(actualcontent.equals(null));
			System.out.println("Implementing partner block is not ready.");
			logger.log(LogStatus.FAIL, "Implementing partner block is not ready.");
			
		} else if (!actualcontent.equals(null)) {
			Assert.assertTrue(!actualcontent.equals(null));
			System.out.println("Implementing partner block is now ready.");
			logger.log(LogStatus.PASS, "Implementing partner block is now ready.");
			
		} else {
			System.out.println("Test has been skipped.");
			logger.log(LogStatus.SKIP, "Test has been skipped.");
		}

		logger.endTest();
		
		
		/*logger.startTest("4. Inner pages banner height verification");
		
		String requiredheight = "340px";
		
		driver.get("http://heifernepal.org/partners");
		
		driver.findElement(By.className("teaser-header")).getCssValue("height");
		
		String banner = driver.findElement(By.className("teaser-header")).getCssValue("height");
		
		if (banner.equals(requiredheight)){
			Assert.assertTrue(banner.equals(requiredheight));
			System.out.println("The height "+banner+ " of banner image is accurate as per requirement.");
			logger.log(LogStatus.PASS, "The height "+banner+ " of banner image is accurate as per requirement.");
			
		} else if (!banner.equals(requiredheight)){
			Assert.assertTrue(!banner.equals(requiredheight));
			System.out.println("The height "+banner+ " of banner image is not accurate as per requirement.");
			logger.log(LogStatus.FAIL, "The height "+banner+ " of banner image is not accurate as per requirement.");
		} else {
			System.out.println("The test has been skipped");
		}
		
		logger.endTest();
		
		
		driver.findElement(By.linkText("IMPLEMENTING PARTNERS")).click();
		
		String partners = driver.getPageSource();
		
		String duplicate = "";
		
		driver.getPageSource();
		
		logger.startTest("5. Duplicate content verification");
		
		if (partners.contains(duplicate)){
			Assert.assertTrue(partners.contains(duplicate));
			System.out.println("duplicate data has been found.");
			logger.log(LogStatus.FAIL, "duplicate data has been found.");
			} else if (!partners.contains(duplicate)){
				Assert.assertTrue(!partners.contains(duplicate));
				System.out.println("No duplicate data has been found.");
				logger.log(LogStatus.PASS, "No duplicate data has been found.");
				
			} else {
				System.out.println("Test has been skipped.");
				logger.log(LogStatus.SKIP, "Test has been skipped.");
			}
		
		logger.endTest();
		*/
		
		
		
		
		
		
		WebDriver report = new ChromeDriver ();
		
		report.manage().window().maximize();
		
		report.get(filepath);
		
		
	}

}
