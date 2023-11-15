package prepareForInterview;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class InterviewOne {
 static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		initBrowser();
	//	convertMoney();
	//	getAmazonItem();
		convertCurrence();
	}
	public static void initBrowser() {
		 System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      
	}
	public static void convertMoney() {
		driver.get("https://www.xe.com");
		System.out.println(driver.getTitle());
		WebElement dropEl=driver.findElement(By.xpath("//*[@id=\"midmarketToCurrency\"]"));
	
	    dropEl.sendKeys("BritishPound"+Keys.ENTER);
	    
	}
	public static void getAmazonItem() throws InterruptedException {
		driver.get("https://www.amazon.com/");
		WebElement dropEl1=driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]"));
	 dropEl1.sendKeys("Selenium");

	List<WebElement> dropD=driver.findElements(By.xpath("//*[@id='nav-flyout-searchAjax']/div//div[@class='s-suggestion s-suggestion-ellipsis-direction']"));
	      System.out.println(dropD.size());
	for(WebElement item:dropD) {
		System.out.println(item.getText());
//	    	  if(item.getText().contains("drops")) {
//	    		  item.click();
//	    		  break;
		
	    	  }
		   
	   }
	public static void convertCurrence() {
		driver.get("https://www.xe.com/");
		 String c="125.3";
	WebElement textAmount=driver.findElement(By.xpath("//*[@id=\"amount\"]"));
	 WebElement submintButton=driver.findElement(By.xpath("//*[@type=\"submit\"]"));
		textAmount.clear();
	 textAmount.sendKeys(c);
	 submintButton.click();
	 WebElement result=driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/section/div[2]/div/main/form/div[2]/div[1]/p[2]"));
	 String string=result.getText();
	 System.out.println(string);

	}
	}

	


