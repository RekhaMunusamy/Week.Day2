package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ass2EditLeadXPathLearning {

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
		Thread.sleep(2000);

		//To search for the lead using "Firstname"
		driver.findElement(By.xpath("(//div[@class='x-form-element'])[19]/input")).sendKeys("Rekha");
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		System.out.println("The title of the resulting page is : " + driver.getTitle());

		driver.findElement(By.linkText("Edit")).click();

		WebElement changeCompanyName = driver.findElement(By.id("updateLeadForm_companyName"));
		//changeCompanyName.clear();
		changeCompanyName.sendKeys("CompanyNameUpdated");

		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();

		WebElement UpdatedCompanyName = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']"));
		System.out.println("Company Name is updated in the View Lead page : "
				+UpdatedCompanyName.getText());

		//driver.close();
	}
}
