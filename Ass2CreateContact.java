
package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ass2CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("TestFN");
		driver.findElement(By.id("lastNameField")).sendKeys("TestLN");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("TestFNLocal");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("TestLNLocal");
		
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Testing Department field");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Testing Description field");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("Test123@test.com");
		
		WebElement elementState = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select DropDown = new Select(elementState);
		DropDown.selectByVisibleText("New York");
		
		driver.findElement(By.name("submitButton")).click();
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Testing Important Note field");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
}

}
