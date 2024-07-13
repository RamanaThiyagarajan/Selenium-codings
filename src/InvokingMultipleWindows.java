import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvokingMultipleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/angularpractice/");		
		driver.switchTo().newWindow(WindowType.TAB); //Invoke new Tab
		//driver.switchTo().newWindow(WindowType.WINDOW); --> Will open the new window
		Set<String> handles= driver.getWindowHandles();
		Iterator<String> it= handles.iterator();
		String ParentWindow= it.next();
		String ChildWindow= it.next();
		driver.switchTo().window(ChildWindow);
		driver.get("https://courses.rahulshettyacademy.com/");
		String CourseTitle= driver.findElement(By.xpath("//*[@title='Learn Postman for API Automation Testing with Javascript']")).getText();
		driver.switchTo().window(ParentWindow);
		driver.findElement(By.cssSelector("[name='name']")).sendKeys(CourseTitle);			

	}

}
