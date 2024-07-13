import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksCountTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//find the number of links present in the page
		
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//find the number of links present in the footer page
		
		WebElement footdriver= driver.findElement(By.id("gf-BIG"));
		System.out.println(footdriver.findElements(By.tagName("a")).size());
		
		WebElement columndriver= footdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columndriver.findElements(By.tagName("a")).size());
		
		for(int i=1; i<columndriver.findElements(By.tagName("a")).size();i++)	
		{
			String Clicklink = Keys.chord(Keys.CONTROL,Keys.ENTER);
			columndriver.findElements(By.tagName("a")).get(i).sendKeys(Clicklink);
			Thread.sleep(5000L);
		}
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> It = windows.iterator();
		 while(It.hasNext())
		 {
			driver.switchTo().window(It.next());
			System.out.println(driver.getTitle());
		 }
	}

}
