package ImportantCode;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.checkerframework.checker.units.qual.s;
import org.checkerframework.common.value.qual.StaticallyExecutable;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
public class DatePicker {
static WebDriver driver;

	public static void main(String[] args) {

	  init();
//	 dataPicker1();
//    datePicker2();
	  datePick3();
	}
static	public void init() {
	
	  
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
public void InsecureCertifiate_Chrome() {
	//DesiredCapabilities desiredCap=DesiredCapabilities.chrome();
//		   desiredCap.acceptInsecureCerts();
//		   desiredCap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
//		   desiredCap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//		   ChromeOptions cOptions=new ChromeOptions();
//		   cOptions.merge(desiredCap);
//		   WebDriverManager.ChromeDriver().setup();
//		   driver.get("URL");
	
	
	}
    static  public void dataPicker1() {
    	WebElement fieldDate = driver.findElement(By.id("dateOfBirthInput"));
		fieldDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		fieldDate.sendKeys("12/22/2010");
		fieldDate.sendKeys(Keys.chord(Keys.ENTER));
    	
    }
    static public void datePicker2() {
    	//month 
    	WebElement bd=driver.findElement(By.id("dateOfBirthInput")); bd.click();
    	WebElement month =driver.findElement(By.className("react-datepicker__month-select"));
    	Select sel_month=new Select(month);
    	sel_month.selectByValue("6");
    //year
    	WebElement year= driver.findElement(By.className("react-datepicker__year-select"));
    	Select sel_year= new Select(year);
    	sel_year.selectByVisibleText("2001");
    	//date
  List<WebElement> days= driver.findElements(By.xpath("//div[contains(@class,'react-datepicker__day--')]"));
      for(int i=0; i<days.size(); i++) {
    	  if(!days.get(i).getText().equals("15"))
    	  continue;
    	  if(days.get(i).getAttribute("class").contains("outside-month"))
    		  continue;
    	  days.get(i).click();
    	  break;
    	  
      }
    }
  static  public void datePick3() {
    	WebElement bd=driver.findElement(By.id("dateOfBirthInput")); 
    	bd.click();
    	WebElement month =driver.findElement(By.className("react-datepicker__month-select"));
    	Select sel_month=new Select(month);
    	sel_month.selectByValue("4");
    //year
    	WebElement year= driver.findElement(By.className("react-datepicker__year-select"));
    	Select sel_year= new Select(year);
    	sel_year.selectByVisibleText("2003");
    	//date
    	String myday="28";
  List<WebElement> days= driver.findElements(By.xpath("//div[contains(@class,'react-datepicker__day--')]"));
      for(WebElement day:days){
    	if(day.getText().equalsIgnoreCase(myday)) {
    		
    		  day.click();
    		  break;
    	  }
    }
System.out.println(driver.findElement(By.xpath("//input[@id='dateOfBirthInput']")).getAttribute("value"));
}
}