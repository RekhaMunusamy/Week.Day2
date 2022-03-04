package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ass1FaceBook {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Test");
		driver.findElement(By.name("lastname")).sendKeys("Last");
		driver.findElement(By.name("reg_email__")).sendKeys("1234567890");
		driver.findElement(By.id("password_step_input")).sendKeys("Password123");

		WebElement elementDay = driver.findElement(By.id("day"));
		Select dayDropdown = new Select(elementDay);
		dayDropdown.selectByValue("5");
		
		WebElement elementMonth = driver.findElement(By.id("month"));
		Select monthDropdown = new Select(elementMonth);
		monthDropdown.selectByVisibleText("Sep");

		WebElement elementYear = driver.findElement(By.id("year"));
		Select yearDropdown = new Select(elementYear);
		yearDropdown.selectByIndex(21);

		driver.findElement(By.xpath("//label[text()='Female']")).click();

	}

}
