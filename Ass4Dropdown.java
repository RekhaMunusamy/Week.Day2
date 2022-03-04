package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ass4Dropdown {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();

		WebElement usingIndex= driver.findElement(By.id("dropdown1"));
		Select DD1 = new Select(usingIndex);
		DD1.selectByIndex(1);

		WebElement usingText = driver.findElement(By.name("dropdown2"));
		Select DD2 = new Select(usingText);
		DD2.selectByVisibleText("Appium");

		WebElement usingValue= driver.findElement(By.id("dropdown3"));
		Select DD3 = new Select(usingValue);
		DD3.selectByValue("3");

		WebElement numberOfOptions = driver.findElement(By.className("dropdown"));
		Select DD4 = new Select(numberOfOptions);
		List<WebElement> options = DD4.getOptions();
		int size = options.size();
		System.out.println("Total number of dropdown options : "+size);

		WebElement usingSendkeys = driver.findElement(By.xpath("(//div[@class='example']/select)[5]"));
		usingSendkeys.sendKeys("UFT/QTP");

		WebElement multipleSelection = driver.findElement(By.xpath("((//div[@class='example']/select))[6]"));
		Select DD5 = new Select(multipleSelection);
		DD5.selectByValue("1");
		DD5.selectByValue("2");
		DD5.selectByValue("3");
		DD5.selectByValue("4");

	}

}
