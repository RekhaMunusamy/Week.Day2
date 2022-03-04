package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ass4EditFields {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();

		driver.findElement(By.id("email")).sendKeys("123test@gmail.com");
		driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']/input)[2]")).sendKeys("Text",Keys.TAB);
		
		Thread.sleep(2000);
		String attribute = driver.findElement(By.name("username")).getAttribute("value");
		System.out.println("Get default text entered : "+attribute);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']/input)[4]")).clear();
		
		boolean enabled = driver.findElement(By.
				xpath("(//div[@class='large-6 small-12 columns']/input)[5]")).isEnabled();
		System.out.println(enabled);

	}

}
