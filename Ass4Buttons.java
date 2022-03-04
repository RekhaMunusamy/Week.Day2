package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ass4Buttons {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='Go to Home Page']")).click();
		
		driver.get("http://leafground.com/pages/Button.html");
		Point location = driver.findElement(By.xpath("//button[@id='position']")).getLocation();
		System.out.println("The position of button x,y : "+location);
		
		String buttonColor = driver.findElement(By.id("color")).getCssValue("background-color");
		System.out.println("Button color is "+buttonColor);
		
		Dimension size = driver.findElement(By.id("size")).getSize();
		System.out.println("The height and width : "+size);
	}

}
