package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ass4InteractWithImages {


	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//div[@class='large-6 small-12 columns']/img")).click();
		driver.navigate().back();

		Thread.sleep(2000);
		WebElement elementBrokenImage = driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']/img)[2]"));

		if(elementBrokenImage.getAttribute("naturalWidth").equals("0")){
			System.out.println("The image is broken");
		}else {
			System.out.println("The image is not broken");
		}

		WebElement elementKeyboradOrMouseClick = driver.findElement(By.xpath("(//div[@class='large-6 small-12 columns']/img)[3]"));
		elementKeyboradOrMouseClick.click();


		Actions actions = new Actions(driver);
		actions.moveToElement(elementKeyboradOrMouseClick).click().perform();

	}

}
