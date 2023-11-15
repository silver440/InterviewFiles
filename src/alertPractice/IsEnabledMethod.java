package alertPractice;

import java.sql.Driver;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import net.bytebuddy.asm.Advice.Enter;
import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial;

public class IsEnabledMethod {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
	init();
	isEnabled();
	//  checkBox();
	 //  selectedColor();
	//  selectList();
	}
	public static void init() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","c:\\selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
    	driver.get("https://www.google.com");
		Thread.sleep(1000);
		}
	static void isEnabled() {
		String actualTitle=driver.getTitle();
		String expectedTitle="Google";
		if(expectedTitle.equals(actualTitle)) {
			System.out.println("Version Successful-Correct title is displayed on the home webpage");
		}
		else {
			System.out.println("Verification failed");
		}
		WebElement searchBox=driver.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
		if(searchBox.isEnabled()) {
			System.out.println("Search box is enabled.Return"+searchBox.isEnabled());
		}else {
			System.out.println("Search box is disabled.Return "+searchBox.isEnabled());
		}
		WebElement sendText=driver.findElement(By.cssSelector("input[class='gLFyf gsfi']"));
		sendText.sendKeys("Selenium Tool");
		//Check that "Google search button " is enabled or not
		WebElement searchbutton=driver.findElement(By.cssSelector("div[class='CqAVzb lJ9FBc']>:last-child>:first-child"));
		 if(searchbutton.isEnabled()) {
			 System.out.println("yes"+searchbutton.isEnabled());
		 }
		 else {
			 System.out.println("no"+searchbutton.isEnabled());
		 }
		 driver.close();
			}
	static void checkBox() {
		String urlString="https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html"; 
		  driver.get(urlString); 
		  WebElement red=driver.findElement(By.xpath("//input[@name='color' and @value='red']"));
		  if(red.isEnabled()) {
			  System.out.println("yes"+red.isEnabled());
		  }
		  else {
			  System.out.println("no "+red.isEnabled());
		  }
	}
	static void selectedColor() {
		String urlString="https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html"; 
		  driver.get(urlString); 
		WebElement colorElement=driver.findElement(By.xpath("//input[@name='color' and @value='orange']"));
		colorElement.click();
		if(colorElement.isSelected()) {
			System.out.println("orange is selected");
		}else {
			System.out.println("orange is not seleced");
		}
			
		driver.close();
	}
	static void selectList() {
		String URL = "https://selenium08.blogspot.com/2019/11/dropdown.html"; 
		driver.get(URL);
		WebElement dropdown=driver.findElement(By.cssSelector("select[name='country']"));
	
		if(dropdown.isDisplayed()&& dropdown.isEnabled()) {
			System.out.println("Dropdown is enabled and displayed");
			}
		else {
			System.out.println("Dropdown is not visible");
			
		}
					Select selectdrop=new Select(dropdown);
					if(selectdrop.isMultiple()) {
						
					System.out.println("Drop down list accepts multiple list");
					}else {
						System.out.println("Drop down list doesnt eccept mutlitple list");
	} 
					int listSize= selectdrop.getOptions().size();
					selectdrop.selectByVisibleText("India");
					String getTeString=selectdrop.getFirstSelectedOption().getText();
					System.out.println(getTeString);
					driver.close();
	}

	
	
		
}