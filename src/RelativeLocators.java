import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//RL- Above
		WebElement nameEditbox= driver.findElement(By.xpath("//*[@name='name']"));
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditbox)).getText());
		//RL- Below
		WebElement dob= driver.findElement(By.xpath("//*[@for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dob)).click();
		//RL- toleft
		WebElement checkboxlabel = driver.findElement(By.xpath("//*[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(checkboxlabel)).click();
        //RL- toright
        WebElement rdb = driver.findElement(By.id("inlineRadio1"));
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
        
	}

}
