import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String password= getPassword(driver);
		String name = "Ramana";
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(name);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		Thread.sleep(2000);
		String ActualText = driver.findElement(By.tagName("p")).getText();
		Assert.assertEquals(ActualText, "You are successfully logged in.");
		driver.findElement(By.xpath("//button[@class='logout-btn']")).click();	
		

	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException {
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();
		String passwordText= driver.findElement(By.className("infoMsg")).getText();
		String[] passwordarr= passwordText.split("'");
//		String[] passwordarr2= passwordarr[1].split("'");
//		passwordarr2[0]
		String password = passwordarr[1].split("'")[0];
		return password;
	}

}
