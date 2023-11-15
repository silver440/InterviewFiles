package alertPractice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ListofValue {
 static WebDriver driver;
	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 String urlString="https://selenium08.blogspot.com/2019/11/dropdown.html";
		 driver.get(urlString);
		 WebElement dropdown=driver.findElement(By.xpath("//select[@name='Month']"));
		 		Select selectdrop=new Select(dropdown);
		 	List<WebElement>getOptions=selectdrop.getOptions();
		 List<String>list=new ArrayList<String>();
		 for(WebElement element:getOptions) {
			 list.add(element.getText());
		 }
		 System.out.println(list);
		Iterator<String>itr=list.iterator();
	   while (itr.hasNext()) {
		String string = (String) itr.next();
		System.out.println(string);
		
	}
		driver.close(); 
			
			 
		 }
		 
	}
	
	


