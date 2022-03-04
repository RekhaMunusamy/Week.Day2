package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ass3GetTitleOfThePage {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://acme-test.uipath.com/login");
		
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//driver.findElement(By.linkText("Login")).click();
		System.out.println("The Title page is : "+driver.getTitle());
		
		driver.findElement(By.xpath("//a[(text()='Log Out')]")).click();
		driver.close();


	}

}
