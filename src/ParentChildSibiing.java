import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ParentChildSibiing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(30));
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());		
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div/button[1]/parent::div/button[2]")));
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
        driver.navigate().to("https://rahulshettyacademy.com/locatorspractice/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.close();
        
		
		

	}

}
