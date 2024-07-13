import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		String[] loginData = getLoginData(driver);
		String Username = loginData[0];
		String Password = loginData[1];
		driver.findElement(By.id("username")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(Password);
		int j = 0;

		driver.findElement(By.xpath("//div[@class='form-check-inline']/label[2]/span[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='okayBtn']")).click();

		WebElement dropdownElement = driver.findElement(By.xpath("//select[@class='form-control']"));
		Select dropdown = new Select(dropdownElement);

		dropdown.selectByVisibleText("Consultant");

		driver.findElement(By.xpath("//*[@id='terms']")).click();
		driver.findElement(By.xpath("//*[@id='signInBtn']")).click();

		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(15));

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h4.card-title")));

		String[] Itemsneeded = { "iphone X", "Samsung Note 8", "Nokia Edge", "Blackberry" };
		List<WebElement> products = driver.findElements(By.cssSelector("h4.card-title"));

		for (int i = 0; i < products.size(); i++)

		{
			String name = products.get(i).getText();

			List<String> ItemsneededList = Arrays.asList(Itemsneeded);

			if (ItemsneededList.contains(name)) {
				j++;
				driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();

				if (j == Itemsneeded.length) {
					break;
				}
			}
		}
		driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();

	}

	public static String[] getLoginData(WebDriver driver) {

		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		WebElement loginDataElement = driver.findElement(By.xpath("//div[@class='form-group']/p"));
		String loginDataText = loginDataElement.getText();
		String[] loginData = loginDataText.split(" and ");
		String UserName = loginData[0].split("is")[1].trim();
		String Password = loginData[1].split("is")[1].trim();
		String Passwordfomatted = Password.trim().replace(")", "");
		return new String[] { UserName, Passwordfomatted };

	}
}
