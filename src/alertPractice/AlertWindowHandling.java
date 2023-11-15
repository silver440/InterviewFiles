package alertPractice;

import java.awt.Window;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertWindowHandling {
	
 static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		init();
//	popUp1();
	//	popup2();
	//confirmButton();
	promtButton();
}2515
    static void init() {
    	System.setProperty("webdriver.chrome.driver","c:\\selenium\\chromedriver.exe");
    	driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://demoqa.com/alerts");
   
    }
    static void popUp1() {
    	driver.findElement(By.id("alertButton")).click();
    	Alert myAlert=  driver.switchTo().alert();
 //   	driver.close();
    	
    	
    }
    static void popup2() {
    	driver.findElement(By.id("timerAlertButton")).click();
    	WebDriverWait wait=new WebDriverWait(driver, 10);
          Alert myAlert=wait.until(ExpectedConditions.alertIsPresent());

  
    driver.switchTo().alert();
  // String string=driver.switchTo().alert().getText();
  // System.out.println(string);
  myAlert.accept();
 // driver.close();
    }
    static void confirmButton() {
    WebElement element=	driver.findElement(By.id("confirmButton"));
    element.click();
 //    WebDriverWait wait =new WebDriverWait(driver, 10);
//  Alert myAlert1=wait.until(ExpectedConditions.alertIsPresent());
        //check if alert button to show alert box
      Alert alert=driver.switchTo().alert();
      String getText=driver.switchTo().alert().getText();
      System.out.println(getText);
      //check if correct message displayed to user AlertBox
      if(getText.equalsIgnoreCase("Do you confirm action?")) {
    	  alert.accept();
    	  System.out.println("you accepted alert");
    	}
      else {
		alert.dismiss();
	
	}

    	driver.close();
    }
    static void promtButton() {
    	WebElement element=driver.findElement(By.xpath("//*[@id='promtButton']"));
    	JavascriptExecutor jsExecutor=(JavascriptExecutor)driver;
    	jsExecutor.executeScript("arguments[0].click()", element);
  // 	element.click();
   WebDriverWait wait=new WebDriverWait(driver, 10);
   	   Alert  myAlert=   wait.until(ExpectedConditions.alertIsPresent());
    	Alert alert=driver.switchTo().alert();
    	alert.sendKeys("shams");
    	alert.accept();
    	//check webpage display message with text entered in prompt box.
    	WebElement displayMessage=driver.findElement(By.id("promptResult"));
    	String st=displayMessage.getText();
    	System.out.println(st);
    		if(st.equalsIgnoreCase("shams")) {
    			System.out.println("Exact matched");
    		}
    		else {
    			System.out.println("something went wrong");
				
			}
    	
    }
}
