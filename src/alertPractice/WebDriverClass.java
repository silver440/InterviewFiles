package alertPractice;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebDriverClass {
   static WebDriver driver;
	public static void main(String[] args) {
		
  System.setProperty("webdriver.chrome.driver","c:\\selenium\\chromedriver.exe");
  driver=new ChromeDriver() ;
	 String url="https://selenium08.blogspot.com/2019/11/dropdown.html";
	 driver.manage().window().maximize();
	 driver.get(url);
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	   WebElement seElement=driver.findElement(By.xpath("//*[@name='country']"));
	   if(seElement.isEnabled()&&seElement.isDisplayed()) {
		   System.out.println("Dropdown is enabled:");
	   }else {
		   System.out.println("Dropdown is disabled");
	   }
			 Select select=new Select(seElement);
			 if(select.isMultiple()) {
				 System.out.println("Selection contains multiple items");
			 } else {
				 System.out.println("Selection contains single item");
			 }
             int size=select.getOptions().size();
             System.out.println("tatal multiple size :"+size);
             select.selectByVisibleText("China");
             String chosenC=select.getFirstSelectedOption().getText();
             System.out.println(chosenC);
}
}
