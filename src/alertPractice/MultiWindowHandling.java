package alertPractice;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultiWindowHandling {
	static WebDriver driver;

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","c:\\selenium\\chromedriver.exe");
    	driver=new ChromeDriver();
		driver.manage().window().maximize();
		String urlString=("http://seleniumframework.com/Practiceform/");
		driver.get(urlString);
	
//		int iFrameSize=driver.findElements(By.tagName("iFrame")).size();
//		System.out.println("Total number of iFrame "+iFrameSize);
//		String getTiString=driver.getTitle();
//		System.out.println(getTiString);
	   
	       driver.findElement(By.id("button1")).click();
		driver.findElement(By.xpath("//*[@id='content']/div[2]/div[2]/div/div[1]/div/p[3]/button")).click();
		driver.findElement(By.xpath("//*[@id='content']/div[2]/div[2]/div/div[1]/div/p[4]/button")).click();

	
		 ArrayList<String>handles=new ArrayList<String>(driver.getWindowHandles());
		 System.out.println("window count"+handles.size());
		 int i=1;
		 for(String handle:handles) {
	       if(i==3)
	    	    i++;
	    	   continue;
		 }
		 driver.switchTo().window(handles.get(1));
	//	 driver.quit();
		 
}
	
}
