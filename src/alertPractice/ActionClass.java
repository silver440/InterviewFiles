package alertPractice;

import java.util.concurrent.TimeUnit;

import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.graphbuilder.curve.Point;


public class ActionClass {
 static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		init();
  //     findG();
     // useAction();
 useDoubleClick();
	//	useRightClick();
	}
	//move curser to "gmail" location
	public static void init() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","c:\\selenium\\chromedriver.exe");
    	driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(1000);
  //      String url="https://www.google.com";
//		driver.get(url);
	//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	String url = "https://selenium08.blogspot.com/2019/11/double-click.html"; 
//		   driver.get(url); 
//		 String url = "https://selenium08.blogspot.com/2019/12/right-click.html"; 
	     driver.get(url); 	
	}
	  public static void findG() {
		 
WebElement element=		  driver.findElement(By.xpath("//a[text()='Gmail']"));
	//1. find coordinates of element 
		   org.openqa.selenium.Point p= element.getLocation();
		  int x= p.getX();
		  int y=p.getY();
           System.out.println("position of x point is :"+p.getX());
		   System.out.println("position of y point is : "+p.getY());
		
			  Actions actions=new Actions(driver);   
	//2. Move the mousse cursor from initial position to given offset
			  actions.moveByOffset(x+1, y+1).click();
			  actions.build().perform();
			  System.out.println("clicked successfully on Gmail");
	//		  driver.quit();
			  
	  }
	  public static void useAction() {
		
		  WebElement gmail=driver.findElement(By.xpath("//a[text()='Gmail']"));
		  Actions actions=new Actions(driver);
		  actions.click(gmail);
		  actions.build().perform();
		  driver.close();
	  }
	  public static void useDoubleClick() {
		  
		 
		   WebElement dblclick = driver.findElement(By.xpath("//button[text() = 'Double-Click me to see Alert message']"));  
		   Actions actions=new Actions(driver);
		   actions.moveToElement(dblclick).doubleClick().perform();
		   System.out.println("Double click action performed successfully ");
		  //switching to Alert from web page and get text of type 
		   Alert alert=driver.switchTo().alert();
		   String st=alert.getText();
		   System.out.println(st);
		   alert.accept();
		   }
	  public static void useRightClick() {
		  WebElement contextElement=
		  driver.findElement(By.xpath("//div[@id = 'div-context']"));
		  
		  Actions actions=new Actions(driver);
		  actions.contextClick(contextElement);
		  WebElement python = driver.findElement(By.xpath("//a[text() = 'Python']")); 
		 actions.click(python);
		 actions.perform();
		 System.out.println("Right-clicked Successfully on Context menu");
		 Alert alert=driver.switchTo().alert();
		 String st1=alert.getText();
		 System.out.println(st1);
		 alert.accept();
		 driver.close();
		  
		  
	  }

}
