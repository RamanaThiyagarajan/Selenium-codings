import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.xpath("//a[@class='blinkingText']")).click();
		Set<String> windows =driver.getWindowHandles();
		Iterator<String> It=windows.iterator();
		String ParentID= It.next();
		String ChildID= It.next();
		driver.switchTo().window(ChildID);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		String emailID= driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(ParentID);
		driver.findElement(By.id("username")).sendKeys(emailID);
		
		

	}

}
