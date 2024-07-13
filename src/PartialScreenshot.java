import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PartialScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/angularpractice/");		
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		//WebElement Screenshot- Partial screenshot
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("D://Automation path//Practise//Screenshots//name.png"));
		//Get height and width of the webelement
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
				
	}

}
