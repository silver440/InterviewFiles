package alertPractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ClickandHold {
 static WebDriver driver;
	public static void main(String[] args) {
		init();
	//	action1();
	action2();
	}
	public static void init() {
		
	System.setProperty("webdriver.chrome.driver","c:\\selenium\\chromedriver.exe");
    	driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	 String url = "https://selenium08.blogspot.com/2020/01/click-and-hold.html"; 
    	   driver.get(url);
    	  
	}
	public static void action1() {
		 WebElement titleC = driver.findElement(By.xpath("//li[text()= 'C']")); 
    	   Actions actions=new Actions(driver);
    	   actions.clickAndHold(titleC).perform();
	}
	public static void action2() {
		  WebElement titleA = driver.findElement(By.xpath("//li[text()= 'A']")); 
		  WebElement titleC = driver.findElement(By.xpath("//li[text()= 'C']")); 
		  Actions actions = new Actions(driver); 
           actions.moveToElement(titleA); 
          actions.clickAndHold(); 
   
   actions.moveToElement(titleC); 
   actions.release().perform(); 
	}

}
