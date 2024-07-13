import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFrameAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/");
		driver.findElement(By.linkText("Nested Frames")).click();
//		WebElement parentFrame = driver.findElement(By.name("frame-top"));
//		driver.switchTo().frame(parentFrame);
//		WebElement ChildFrame = driver.findElement(By.name("frame-middle"));
//		driver.switchTo().frame(ChildFrame);
		driver.switchTo().frame("frame-top"); // frames can be switched with string names also
		driver.switchTo().frame("frame-middle");
		System.out.println(driver.findElement(By.xpath("//*[text()='MIDDLE']")).getText());

	}

}
