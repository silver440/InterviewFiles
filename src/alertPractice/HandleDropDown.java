package alertPractice;

import java.sql.DriverPropertyInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDropDown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","c:\\selenium\\chromedriver.exe");
    	 WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		 driver.get("https://yahoo.com");
		  driver.findElement(By.xpath("//*[@id=\"root_6\"]")).click();
		 WebElement mElement=  driver.findElement(By.xpath("//*[@id=\"ybar-sbq\"]"));
		  mElement. sendKeys("books");
		  mElement.sendKeys(Keys.ENTER);
	System.out.print("pass");
             driver.quit();

	}

}
