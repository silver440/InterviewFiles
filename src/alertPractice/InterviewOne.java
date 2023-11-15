package alertPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class InterviewOne {
 static WebDriver driver;
 
	public static void main(String[] args) {
		initializeBrowser();

	}public static void  initializeBrowser() {
      System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
      driver=new ChromeDriver();
      driver.manage().window().maximize();
      String urlString="https://www.xe.com";
      driver.get(urlString);
       WebElement element=driver.findElement(By.xpath("//*[@id=\"midmarketToCurrency\"]"));
       
       Select select=new Select(element);
          select.deselectAll();
       
        
     
        
      
	}

}
