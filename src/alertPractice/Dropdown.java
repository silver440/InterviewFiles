package alertPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dropdown {
 static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		String string="https://selenium08.blogspot.com/2019/11/selenium-iframe.html";
		driver.get(string);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		 List<WebElement> IframeSize=driver.findElements(By.tagName("iframe"));
		 int a= IframeSize.size();
		 System.out.println(a);
		 driver.switchTo().frame(0);
	}

}
