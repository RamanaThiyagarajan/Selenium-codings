import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//*[@placeholder='Type to Select Countries']")).sendKeys("Uni");;
		List<WebElement> options= driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
		
		for(WebElement Option : options)
		{
			if(Option.getText().equalsIgnoreCase("United States (USA)"))
			{
				Option.click();
				break;
			}
		}
		
		//System.out.println(driver.findElement(By.cssSelector(".ui-autocomplete-input")).getAttribute("value"));
		String ActualText= driver.findElement(By.cssSelector(".ui-autocomplete-input")).getAttribute("value");
		Assert.assertEquals(ActualText, "United States (USA)");
		
	}

}
