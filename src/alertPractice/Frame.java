package alertPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial;

public class Frame {
	static WebDriver driver;

	public static void main(String[] args) {
	 init();

	}
   public static  void init() {
		System.setProperty("webdriver.chrome.driver","c:\\selenium\\chromedriver.exe");
	   driver=new ChromeDriver();
	   driver.manage().window().maximize();
	   String urlString="https://selenium08.blogspot.com/2019/11/selenium-iframe.html";
	   driver.get(urlString);
 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 //Locate the first iframe and switch driver to first iframeby index value 0
	    List<WebElement> totalIframe=driver.findElements(By.tagName("iframe"));
	   System.out.println("total frames are\n"+totalIframe);
	   System.out.println("totallrame size"+totalIframe.size());
	   driver.switchTo().frame(0);
	   driver.findElement(By.xpath("//input[@itemprop = 'query-input']")).sendKeys("Selenium Jobs"); 
	   driver.findElement(By.xpath("//button[@class = 'wpb_button wpb_btn-inverse btn']")).click();
	  //switch to main 
	   driver.switchTo().defaultContent();
	   //closing first frame.
	 String getTitleOfMainP=driver.getTitle();
	 System.out.println(getTitleOfMainP);
	 String mainPageURL = driver.getCurrentUrl(); 
     System.out.println("URL of main web page: " +mainPageURL); 

// Switch to second iframe by its index value 1. 
     driver.switchTo().frame(1); 
    
     

   
  //    driver.quit(); 
	 
	
	   
	   }
     
}
