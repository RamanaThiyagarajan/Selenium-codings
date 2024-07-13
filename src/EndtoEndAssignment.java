import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EndtoEndAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//*[@id='checkBoxOption2']")).click();
		// System.out.println(driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText());
		String CheckboxText = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[2]")).getText();

		WebElement element = driver.findElement(By.id("dropdown-class-example"));

		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(CheckboxText);

		driver.findElement(By.xpath("//*[@id='name']")).sendKeys(CheckboxText);
		driver.findElement(By.id("alertbtn")).click();
		// System.out.println(driver.switchTo().alert().getText().split(",")[0].split("
		// ")[1]);
		String AlertText = driver.switchTo().alert().getText();

		driver.switchTo().alert().accept();

		if (AlertText.contains(CheckboxText)) {
			System.out.println("Alert Message Success");
		} else {
			System.out.println("Alert Message Not matching");
		}

	}
}
