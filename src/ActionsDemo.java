import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://amazon.com/home");
		Actions actions = new Actions(driver);
	    
		// Entering Capital letters in search bar using Action class
		WebElement searchElement = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
		actions.moveToElement(searchElement).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick()
		.build().perform();
		//Double click- to select the tex
		
		
		//Mouse hover using Action class
		WebElement element = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
		actions.moveToElement(element).contextClick().build().perform();
		// Context click - to Do the right mouse click option
		
		
		
		

	}

}
