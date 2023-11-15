import java.awt.Desktop.Action;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.apache.commons.math3.stat.descriptive.StatisticalSummaryValues;
import org.checkerframework.checker.signature.qual.BinaryNameWithoutPackage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.netty.handler.codec.AsciiHeadersEncoder.NewlineType;


public class SelectDropdown {
static WebDriver driver;
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","c:\\selenium\\chromedriver.exe");
    	driver=new ChromeDriver();
    	
    //	 getDropdownlist();
    	//switchtoAlert();
    	//clickCurrentLocation();
   // 	getActionandAlert();
//    	useJavascript();
//    	scrolWindwo();
    	switFrame();
	}
	
    public static void getDropdownlist() {
    	driver.manage().window().maximize();
    	String URL = "https://selenium08.blogspot.com/2019/11/dropdown.html"; 
    	 driver.get(URL); 
    	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	int count=0;
    	WebElement dropElement=driver.findElement(By.xpath("//select[@name=\"country\"]"));
    	Select dropdown=new Select(dropElement);
    
       List<WebElement >list=dropdown.getOptions();
     int a= list.size();
     System.out.println("number of coountry are listed :"+a);
         List<String > list2=new ArrayList<String>();
         for(WebElement element:list) {
        	list2.add(element.getText());
    	       
    	       
    		   }
    	    System.out.println(list2);
    }
    public static void switchtoAlert() {
    	driver.get("https://selenium08.blogspot.com/2019/07/alert-test.html");
    	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	 WebElement element = driver.findElement(By.xpath("//input[@id='simple']")); 
    	element.click();
    	Alert alert=driver.switchTo().alert();
    	String getText=driver.switchTo().alert().getText();
    	if(getText.equalsIgnoreCase("Hello! I am a simple alert box!")) {
    		System.out.println("its work");
    	}else {
    		System.out.println("it not showing ");
    	}
    	
    	alert.accept();
    	
    }
    public static void clickCurrentLocation() {
    	driver.get("https://www.google.com");
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	WebElement Gmail=driver.findElement(By.xpath("//a[text()=\"Gmail\"]"));
    
    	Actions actions=new Actions(driver);
    	int getX=Gmail.getLocation().getX();
    	System.out.println("X coordinate:"+getX);
    	int getY=Gmail.getLocation().getY();
    	System.out.println("Y coordinate:"+getY);
    	actions.moveByOffset(getX+1, getY+1).click();
    	actions.build().perform();
    	System.out.println("clicked succesfully on gmail");
   	driver.close();
    	
    }
    public static void getActionandAlert() {
    	 driver.get("https://selenium08.blogspot.com/2019/11/double-click.html");
    	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	 WebElement element=driver.findElement(By.xpath("//button[text() = 'Double-Click me to see Alert message']"));
    Actions actions=new Actions(driver);
    actions.doubleClick(element);
    actions.perform();
    Alert alert=driver.switchTo().alert();
    String getText=alert.getText();
    System.out.println("alert text:"+getText);
    alert.accept();
    
    }
    public static void useJavascript() {
    	driver.get("https://www.google.com");
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	WebElement search=driver.findElement(By.xpath("//*[@name=\"q\"]"));
    	WebElement submit=driver.findElement(By.xpath("//input[@name = 'btnK']"));
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeScript("arguments[0].value='Selenium'",search);
    	js.executeScript("arguments[0].click()", submit);
//    	js.executeScript("argument[0].value='Selenium',argument[1].click()",search,submit);
    	System.out.println("Test successful");
    	driver.navigate().back();
    	
    	
    }
    public static void scrolWindwo() {
    	String Url="https://selenium08.blogspot.com/2020/02/vertical-scroll.html";
    	driver.get(Url);
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	WebElement menu=driver.findElement(By.xpath("//a[text()=\"Cricket\"]"));
    	JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", menu);
    }
    public static void switFrame() {
    	driver.get("https://selenium08.blogspot.com/2019/11/selenium-iframe.html");
    	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    	driver.manage().window().maximize();
    	int iframe=driver.findElements(By.tagName("iframe")).size();
    	System.out.println("Total frames:"+iframe);
    	driver.switchTo().frame(0);
    	WebElement search=driver.findElement(By.xpath("//input[@itemprop=\"query-input\"]"));
    	search.sendKeys("Selenium Jobs");
    	  driver.findElement(By.xpath("//button[@class = 'wpb_button wpb_btn-inverse btn']")).click(); 
    	  driver.switchTo().defaultContent();
    	  System.out.println("title is: "+driver.getTitle());
    	  driver.switchTo().frame(1);
    	
    	  
    	
    }
       }
    
    	
    

