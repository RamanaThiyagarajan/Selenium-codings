import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinksText {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");		
		List<WebElement> links =  driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert a = new SoftAssert();
		
		for (WebElement link: links)
			
		{
			String url = link.getAttribute("href");
		  HttpURLConnection conne = (HttpURLConnection)new URL(url).openConnection();
		  conne.setRequestMethod("HEAD");
		  conne.connect();
		 int respCode= conne.getResponseCode();		
		 System.out.println(respCode);
		 a.assertTrue(respCode<400, "The Link with Test "+link.getText()+" is broken with Code "+respCode);
			
		}
		a.assertAll();
	}

}
