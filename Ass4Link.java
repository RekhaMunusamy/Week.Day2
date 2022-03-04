package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ass4Link {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();

		WebElement elementHomepage = driver.findElement(By.linkText("Go to Home Page"));
		elementHomepage.click();
		driver.navigate().back();

		//Find where am supposed to go without clicking me?
		WebElement withoutClickingElement = driver.findElement(By.partialLinkText("without clicking me?"));
		String attribute = withoutClickingElement.getAttribute("href");
		System.out.println("The link is going to " + attribute);

		//Verify am I broken?
		WebElement elementBroken = driver.findElement(By.linkText("Verify am I broken?"));
		elementBroken.click();

		String title = driver.getTitle();
		System.out.println(title);

		if (title.contains("404"))

		{
			System.out.println("The link is going to 404 page " + title);
		}else {
			System.out.println("The link is not going to 404 page ");
		}

		driver.navigate().back();	

		driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).click();
		driver.findElement(By.xpath("(//img[@class='wp-categories-icon svg-image'])[3]")).click();	

		//To find the Number of links on the page
		List<WebElement> linkCounts = driver.findElements(By.tagName("a"));
		int size = linkCounts.size();
		System.out.println("The Total Number os links "+ size);

	}

}
