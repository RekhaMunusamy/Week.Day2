package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ass2DuplicateLeadXPathLearning {

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

		//Finding the First Resulting lead using an email
		driver.findElement(By.xpath("//span[text()='Email']")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("mrekha.20@gmail.com");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);	

		String firstResultingLeadName = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]")).getText();
		System.out.println("Name of the First Resulting lead is "+firstResultingLeadName);

		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']/a)[1]")).click();
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();

		String title = driver.getTitle();

		if(title.equals("Duplicate Lead | opentaps CRM"))
		{
			System.out.println("The title is "+title );
		}else
			System.out.println("Wrong title is displayed");

		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();

		//To check the "firstResultingLeadName" is same as "duplicateLeadName"		
		String duplicateLeadName = driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']")).getText();
		if(duplicateLeadName.equals(firstResultingLeadName)) {
			System.out.println("The 'dupliacte lead name' is same as the 'fist resulting lead name' : " +duplicateLeadName);
		}
		driver.close();
	}

}
