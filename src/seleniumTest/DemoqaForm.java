package seleniumTest;


import java.awt.Desktop.Action;
import java.awt.RenderingHints.Key;
import java.io.UnsupportedEncodingException;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.databind.deser.impl.PropertyBasedObjectIdGenerator;

import io.opentelemetry.semconv.trace.attributes.SemanticAttributes.FaasTriggerValues;
import net.bytebuddy.asm.Advice.AllArguments;
import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;

public class DemoqaForm {
 static  WebDriver driver;
 static String name="Shamshinur"	;
 static String lname="Idris";
 static String hobbiesString="Music";
 static String email="tuman@gmail.com";
 static String gender="Female";
 static String phone="2131234356";
 static String subjectString="Computer Science";
 static String addr="3303 West Hollywood ,\r\nCA, LA\r 65456";
	public static void main(String[] args) throws InterruptedException {
		DemoqaForm d=new DemoqaForm();
		d. init();
		d. fillfirstName(name);
       d.filllastsName(lname);
       d.fillEmail(email);
        d.getGender(gender);
        d.fillPhone(phone);
        d.fillDate();
     d.fillHobbies();   
        //     
  //     
       d.fillAdress();
       d.fillStateCity();
        d.fillMajor();
     //  d.clickButton();
	}
	
	public void init() {
		System.setProperty("webdriver.chrome.driver","c:\\selenium\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
//		options.addArguments("ignore-ssl-errors=yes", "ignore-certificate-errors");		
		options.setAcceptInsecureCerts(true);
		driver= new ChromeDriver(options);
		
		driver.manage().window().maximize();
		String urlString="https://demoqa.com/automation-practice-form";
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(urlString);
		
	}
   public    void fillfirstName(String name) {
//	  driver.findElement(By.id("firstName")).sendKeys("Patima");
	  WebElement fieldName=driver.findElement(By.id("firstName"));
	  ((JavascriptExecutor ) driver).executeScript("arguments[0].scrollIntoView(true);",fieldName);
	  fieldName.sendKeys(name);
  }
    public void filllastsName(String lname) {
	   //	  driver.findElement(By.id("lastName")).sendKeys("Idris");
	   WebElement fieldName=driver.findElement(By.id("lastName"));
		  ((JavascriptExecutor ) driver).executeScript("arguments[0].scrollIntoView(true);",fieldName);
		  fieldName.sendKeys(lname);
   }
    public void fillEmail(String email) {
		//	  driver.findElement(By.id("userEmail")).sendKeys("tester@gmail.com");
    	WebElement fieldName=driver.findElement(By.id("userEmail"));
  	  ((JavascriptExecutor ) driver).executeScript("arguments[0].scrollIntoView(true);",fieldName);
  	  fieldName.sendKeys(email);
	}
    public void getGender(String g) {
    	 List<WebElement> genderElement=driver.findElements(By.name("gender"));
   	  int elementSize=  genderElement.size(); 
   	  System.out.println(elementSize);
   	  for(int i=0; i<elementSize;i++) {
   		  if(genderElement.get(i).getAttribute("value").equalsIgnoreCase(gender)) {
   		  JavascriptExecutor executor=(JavascriptExecutor)driver;
   		   executor.executeScript("arguments[0].click()", genderElement.get(i));
    }
    }
    }  	
	public void fillPhone(String s) {
	//	 driver.findElement(By.cssSelector("userNumber"));
		 WebElement  fieldPhone=driver.findElement(By.id("userNumber"));
		 fieldPhone.sendKeys(phone);
	}
	public void fillDate() {
		WebElement fieldDate = driver.findElement(By.id("dateOfBirthInput"));
		fieldDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		fieldDate.sendKeys("12/22/2010");
		fieldDate.sendKeys(Keys.chord(Keys.ENTER));
	}
		public void fillMajor() throws InterruptedException {
	WebElement subjects=driver.findElement(By.id("subjectsInput"));
//	((JavascriptExecutor ) driver).executeScript("arguments[0].scrollIntoView(true);",subjects);
	
	   subjects.sendKeys("computer"+Keys.ENTER);
	 
	 //   Thread.sleep(2000);
	//   subjects.sendKeys(subjectString);
	  
//	   Actions actionProvider =new Actions(driver);
//	   org.openqa.selenium.interactions.Action keydown = actionProvider.keyDown(Keys.CONTROL).build();
//    keydown.perform();
//	    subjects.sendKeys((subjectString)+Keys.ENTER);
		}
		public void fillHobbies( ) throws InterruptedException{
			
	List<WebElement> hbsList=driver.findElements(By.xpath("//*[@id='hobbiesWrapper']/div[2]/div"));
       for(int i=0; i<hbsList.size();i++) {
    	System.out.println(hbsList.get(i).getText());  
    	   if(hbsList.get(i).getText().contains(hobbiesString)) {
    		  // Thread.sleep(2000);
//    		   JavascriptExecutor executor=(JavascriptExecutor)driver;
//    		   executor.executeScript("arguments[0].click()",hbsList.get(i));
    		   hbsList.get(i).click();
    	   }
       }
     }
    	   public void fillAdress() throws InterruptedException {
    		  driver.findElement(By.id("uploadPicture")).sendKeys("c://roz//test.txt");
        	   driver.findElement(By.xpath("//*[@id='currentAddress']")).sendKeys(addr);
             
       }
	public void fillStateCity() throws InterruptedException {
		
		driver.findElement(By.xpath(" //*[@id='react-select-3-input']")).sendKeys("NCR"+Keys.ENTER);
	
		driver.findElement(By.xpath("//*[@id='react-select-4-input']")).sendKeys("Dehli"+Keys.ENTER);
	  
	}
	public void clickButton() throws InterruptedException {
		Thread.sleep(1000);
	WebElement dElement=	driver.findElement(By.id("//*[@id='submit']"));
		JavascriptExecutor executor=(JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click()", dElement);
	 
	}
	 
		
	
}
    
         

			
       
		
		
		
	
		
				
   
    
			
   
			
		
     
     
    
   	     
    
 
    
