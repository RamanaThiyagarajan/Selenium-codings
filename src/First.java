import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class First {
	private WebDriver driver;

	@BeforeTest
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "D:\\Automation path\\VirtualMaze\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(priority = 1)
	public void testForgotPasswordIsDisplayed() throws InterruptedException {
		// Navigate to the login page

		driver.get("https://accounts.vmmaps.com/");
		Thread.sleep(5000);
		driver.manage().window().maximize();

		WebElement forgotPassword = driver.findElement(By.id("Forgot-Password"));

		// Check if the button is displayed
		if (forgotPassword.isDisplayed()) {
			System.out.println("Forgot Password is displayed.");

		} else {
			System.out.println("Forgot Password is not displayed.");

		}
	}

	@Test(priority = 2)
	public void testForgotPasswordWithoutEmailID() throws InterruptedException {
		// Navigate to the login page

		driver.get("https://accounts.vmmaps.com/");
		Thread.sleep(5000);
		driver.manage().window().maximize();

		WebElement forgotPassword = driver.findElement(By.id("Forgot-Password"));
		forgotPassword.click();
		Thread.sleep(3000);
		WebElement ErrorMessage = driver.findElement(By.xpath("//div[@class='email error']"));

		String actualErrorMessage = ErrorMessage.getText();

		String expectedErrorMessage = "Enter EmailId";

		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Enter EmailId");
	}

	@Test(priority = 3)
	public void testForgotPasswordWithInvalidEmailID() throws InterruptedException {
		// Navigate to the login page

		driver.get("https://accounts.vmmaps.com/");
		Thread.sleep(5000);
		driver.manage().window().maximize();

		WebElement usernameInput = driver.findElement(By.id("login-email"));
		usernameInput.sendKeys("vramana791@mail.com");

		WebElement forgotPassword = driver.findElement(By.id("Forgot-Password"));
		forgotPassword.click();
		Thread.sleep(3000);
		WebElement ErrorMessage = driver.findElement(By.xpath("//div[@class='email error']"));

		String actualErrorMessage = ErrorMessage.getText();

		String expectedErrorMessage = "User doesn't exist";

		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "User doesn't exist");

		// Validate Snackbar is Displayed or not
		try {
			WebElement snackbar = driver.findElement(By.id("snackbars"));

			if (snackbar.isDisplayed()) {

				String snackbarText = snackbar.getText();

				String expectedMessage = "Verification Code sent fail";
				if (snackbarText.contains(expectedMessage)) {
					System.out.println("The snackbar is displayed with the expected message: " + expectedMessage);

				} else {
					System.out.println("The snackbar is displayed, but with a different message.");

				}
			} else {
				System.out.println("The snackbar is not displayed.");

			}
		} catch (Exception e) {
			System.out.println("The snackbar did not appear within the expected time.");

		}
	}

	@Test(priority = 4)
	public void testForgotPasswordWithValidEmailID() throws InterruptedException {
		// Navigate to the login page

		driver.get("https://accounts.vmmaps.com/");
		Thread.sleep(5000);
		driver.manage().window().maximize();

		WebElement usernameInput = driver.findElement(By.id("login-email"));
		usernameInput.sendKeys("vramana791@gmail.com");

		WebElement forgotPassword = driver.findElement(By.id("Forgot-Password"));
		forgotPassword.click();
		Thread.sleep(3000);
		WebElement popup = driver.findElement(By.id("ResetPopup"));
		Assert.assertTrue(popup.isDisplayed(), "Popup is not displayed");

		try {
			WebElement snackbar = driver.findElement(By.id("snackbars"));

			if (snackbar.isDisplayed()) {

				String snackbarText = snackbar.getText();

				String expectedMessage = "Verification Code sent Successfully";
				if (snackbarText.contains(expectedMessage)) {
					System.out.println("The snackbar is displayed with the expected message: " + expectedMessage);

				} else {
					System.out.println("The snackbar is displayed, but with a different message.");

				}
			} else {
				System.out.println("The snackbar is not displayed.");

			}
		} catch (Exception e) {
			System.out.println("The snackbar did not appear within the expected time.");

		}

	}

	@Test(priority = 5)
	public void testForgotPasswordWithooutOtp() throws InterruptedException {
		// Navigate to the login page

		WebElement resetPassword = driver.findElement(By.id("Resetpassword"));
		resetPassword.sendKeys("Ramana");
		Thread.sleep(3000);
		WebElement changeButton = driver.findElement(By.xpath("//span[@id='reset-login-otp-text']"));
		changeButton.click();
		Thread.sleep(5000);
		WebElement ErrorMessage = driver.findElement(By.id("ResetError"));

		String actualErrorMessage = ErrorMessage.getText();

		String expectedErrorMessage = "Try again after Sometime";

		Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Try again after Sometime");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}