import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;



public class SignupTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		
		String filepath = "D:\\secretsshh.test.report\\signuptest.html";
		
		String baseurl = "https://www.secrets-shhh.com";
		
		String email = "LarryDWilliams@inbound.plus";
		
		String inputemailid = "edit-account-mail";
		
		String buttonid = "edit-submit";
		
		ExtentReports logger = ExtentReports.get(SignupTest.class);
		
		logger.init (filepath, true);
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get(baseurl);
		
		driver.findElement(By.id(inputemailid)).sendKeys(email);
		
		driver.findElement(By.id(buttonid)).click();
		
		
		
		
		
		//test end
		
		driver.get(filepath);
		
		
	}

}
