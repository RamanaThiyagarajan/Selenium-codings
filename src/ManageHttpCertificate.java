import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ManageHttpCertificate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeOptions options = new ChromeOptions(); //Same can be done with Different browsers like Edge, Firefox & Safari
		options.setAcceptInsecureCerts(true);
		
		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize(); //will maximize the window
		driver.manage().deleteAllCookies(); // Will delete all the cookies in the browser
		//driver.manage().deleteCookieNamed("session key");
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
	}

}
