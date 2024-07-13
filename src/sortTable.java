import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class sortTable
{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D://Automation Testing//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click the column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//Capture the webelements in the list
		List<WebElement> elementsList= driver.findElements(By.xpath("//tr/td[1]"));
		
		//Capture the Text of webelements in the list
		List<String> originalList= elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//Capture the sorted elements in the seperate list
		List<String> sortedList= originalList.stream().sorted().collect(Collectors.toList());
		
		//validate by Comparing the original list and Sorted list by Assertion.
		Assert.assertTrue(originalList.equals(sortedList));
		 
		//scan the column with the get Text-> Beans-> Print the price of the rice
		
//		List<String> price = elementsList.stream().filter(s->s.getText().contains("Beans")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
//		price.forEach(a->System.out.println(a));
		
		//Pagination Concept to get the Item and its price
		List<String> price;
		do {
			List<WebElement> rows= driver.findElements(By.xpath("//tr/td[1]"));
			price =rows.stream().filter(s->s.getText().contains("Rice")).map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		
		if(price.size()<1) {
			driver.findElement(By.xpath("//*[@aria-label='Next']")).click();
		}
	}while(price.size()<1);
		

	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String pricevalue= s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}

}
