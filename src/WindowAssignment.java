import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Multiple Windows")).click();
		driver.findElement(By.linkText("Click Here")).click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> It = windows.iterator();
		String ParentID = It.next();
		String ChildID = It.next();
		driver.switchTo().window(ChildID);
		System.out.println(driver.findElement(By.cssSelector(".example")).getText());
		driver.switchTo().window(ParentID);
		System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());

	}

}
