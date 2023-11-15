package seleniumTest;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumUtility.Utill;

public class DemoqaExcell {
	static WebDriver driver;
	 static String hobbies="";

	public static void main(String[] args) throws Exception {
		init();
		fillOutForm();

	}
	public static void init() {
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
    public static void fillOutForm() throws Exception {
    	String path=System.getProperty("user.dir");
    	System.out.println(path);

 // userInfo user1=seleniumUtility.Util.readInfoFromExcell	(path+"\\src\\seleniumData\\Book1.xlsx");
    	
    //	add new code for multiple row in excell
  	List<userInfo>users=Utill.readInfoFromExcell	(path+"\\src\\seleniumData\\Book1.xlsx");
    	for(int i=0; i<users.size(); i++) {
 		userInfo user1=users.get(i);
    	
    	WebElement fname=driver.findElement(By.id("firstName"));
  	  ((JavascriptExecutor ) driver).executeScript("arguments[0].scrollIntoView(true);",fname);
  	  fname.sendKeys(user1.getFrsName());
  	
  	  WebElement lname=driver.findElement(By.id("lastName"));
	  ((JavascriptExecutor ) driver).executeScript("arguments[0].scrollIntoView(true);",lname);
	  lname.sendKeys(user1.getLstNname());
	  
	  WebElement email=driver.findElement(By.id("userEmail"));
  	  ((JavascriptExecutor ) driver).executeScript("arguments[0].scrollIntoView(true);",email);
  	  email.sendKeys(user1.getEmail());
  	  
  	 List<WebElement> genderElement=driver.findElements(By.name("gender"));
	  int elementSize=  genderElement.size(); 
  //	  System.out.println(elementSize); 
	  JavascriptExecutor executor=(JavascriptExecutor)driver;
  	  for(int ii=0; ii<elementSize;ii++) {
  		  if(genderElement.get(ii).getAttribute("value").equalsIgnoreCase(user1.getGender())) {
  		 
  		   executor.executeScript("arguments[0].click()", genderElement.get(ii));
    }
   
}
  	 WebElement  fieldPhone=driver.findElement(By.id("userNumber"));
	 fieldPhone.sendKeys(user1.getMobile());
	 //05/23/1997 Excel file days doesnt not match with element days value
	 
	 String []dob=user1.getDob().split("[/]");
	 String monthName="";
	 switch (dob[0]) {
	case "01":
		monthName= "January";
		break;
	case "02":
	monthName="February";
	break;
	case "03":
		monthName="March";
		break;
	case"04":
		monthName="April";
		break;
	case "05":
		monthName="May";
		break;
	case "06":
		monthName="June";
		break;
	case "07":
		monthName="July";
		break;
	case "08":
		monthName="August";
		break;
	case "09":
		monthName="September";
		break;
	case "10":
		monthName="October";
		break;
	case"11":
		monthName="November";
		break;
	case "12":
		monthName="December";
		break;
		}
	 // we have to match excell number with element excell(08) element (8)
	 String date="";
	 switch (dob[1]) {
	case "01":date="1";	break;case "02":date="2";break;
	case "03":date="3";break;
	case "04": date="4";	break; case "05": date="5"; break;
	case "06": date="6"; break; case "07": date ="7"; break;
	case "08": date="8"; break; case "09": date="9"; break;	
	default:  date=dob[1];
	break;
	}
	//month 
 	WebElement bd=driver.findElement(By.id("dateOfBirthInput")); bd.click();
 	WebElement month =driver.findElement(By.className("react-datepicker__month-select"));
 	Select sel_month=new Select(month);
 	 sel_month.selectByVisibleText(monthName);
 //year
 	WebElement year= driver.findElement(By.className("react-datepicker__year-select"));
 	Select sel_year= new Select(year);
 	sel_year.selectByVisibleText(dob[2]);
 	//date
List<WebElement> days= driver.findElements(By.xpath("//div[contains(@class,'react-datepicker__day--')]"));
   for(int y=0; y<days.size(); y++) {
 	  if(!days.get(y).getText().equals("15"))
 	  continue;
 	  if(days.get(y).getAttribute("class").contains("outside-month"))
 		  continue;
 	  days.get(y).click();
 	  break;
 	  
   }
 
	 
//	 WebElement fieldDate = driver.findElement(By.id("dateOfBirthInput"));
//		fieldDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//		fieldDate.sendKeys("12/22/2010");
//		fieldDate.sendKeys(Keys.chord(Keys.ENTER));
//		
	driver.findElement(By.id("subjectsInput")).sendKeys(user1.getSubject()+Keys.ENTER);
	 
List<WebElement> hbsList=driver.findElements(By.xpath("//*[@id='hobbiesWrapper']/div[2]/div"));
hobbies = user1.getHobbies();
hobbies = hobbies.replace("Reading", "2");
hobbies = hobbies.replace("reading", "2");
// if(hobbies.contains("sports"))
hobbies = hobbies.replace("Sports", "1");
hobbies = hobbies.replace("sports", "1");
// if(hobbies.contains("music"))
hobbies = hobbies.replace("Music", "3");
hobbies = hobbies.replace("music", "3");
for(int j=0; j<hbsList.size();j++) {
	    	System.out.println(hbsList.get(i).getText());  
	    	   if(hbsList.get(j).getText().contains(user1.getHobbies())) {
	    		  // Thread.sleep(2000);
//	    		   JavascriptExecutor executor=(JavascriptExecutor)driver;
//	    		   executor.executeScript("arguments[0].click()",hbsList.get(i));
	    		   hbsList.get(j).click();
	    	   }
	       }
	  
    driver.findElement(By.id("uploadPicture")).sendKeys(user1.getPicLoad());
	   driver.findElement(By.xpath("//*[@id='currentAddress']")).sendKeys(user1.getAddress());
	   
	   driver.findElement(By.xpath(" //*[@id='react-select-3-input']")).sendKeys(user1.getState()+Keys.ENTER);
		
		driver.findElement(By.xpath("//*[@id='react-select-4-input']")).sendKeys(user1.getCity()+Keys.ENTER);	  
		 WebDriverWait wait = new WebDriverWait(driver,10);
		 
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submit")));
         driver.findElement(By.id("submit")).click();
//  driver.findElement(By.id("submit")).submit();
 // 	Thread.sleep(2000);
//driver.findElement(By.id("closeLargeModal")).click();
//	Thread.sleep(2000);
  
    }
	  
    }
    }
