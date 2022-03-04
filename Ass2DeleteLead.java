package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ass2DeleteLead {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();

		driver.findElement(By.xpath("//span[text()='Phone']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("357");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(5000);

		//To find the First Resulting lead
		WebElement firstResultingLeadID = driver.findElement(By.
				xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		String textLeadID = firstResultingLeadID.getText();
		System.out.println("The lead ID of First Resulting lead : " +textLeadID);
		firstResultingLeadID.click();

		//To delete the First Resulting lead
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']")).click();

		//verifying the lead does not exits after deletion
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(
				"357");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);

		//Error message to be displayed if lead is deleted successfully 
		WebElement leadlistMessage =
				driver.findElement(By.xpath("//div[text()='No records to display']"));
		String text = leadlistMessage.getText();

		if(text.equals("No records to display")) { 
			System.out.println("No records to display message confirms the successful deletion");
		}else System.out.println("The lead is not deleted");

	}
}
