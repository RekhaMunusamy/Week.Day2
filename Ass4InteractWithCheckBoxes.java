package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ass4InteractWithCheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();

		WebElement selectLanguages = driver.findElement(By.xpath("(//input[@type='checkbox'])[3]"));
		selectLanguages.click();

		//confirm "selenium" is checked
		WebElement elementSelected = driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following::input"));
		if(elementSelected.isSelected()) {
			System.out.println("Selenium is checked");
		}
		else {System.out.println("Selenium is not checked");}

		Thread.sleep(3000);

		//Deselect only checked option
		WebElement firstElement = driver.findElement(By.xpath("(//input[@type='checkbox'])[7]"));
		if(firstElement.isSelected()) 
			firstElement.click();

		Thread.sleep(3000);

		WebElement secondElement = driver.findElement(By.xpath("(//input[@type='checkbox'])[8]"));
		if(secondElement.isSelected())
			secondElement.click();

		//Multiselection
		List<WebElement> selectMultipleCheckboxes = driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']/following::input"));

		for (WebElement webElement : selectMultipleCheckboxes) {
			webElement.click();

		}

	}
}
