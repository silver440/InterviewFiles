package alertPractice;

import javax.tools.Diagnostic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ParameterDefinition.Initial;

public class Practice {
 static WebDriver driver;
 
	public static void main(String[] args) throws InterruptedException {
	initial();
	}
 public  static void initial() throws InterruptedException {
	 System.setProperty("webdriver.chrome.driver","c:\\selenium\\chromedriver.exe");
 	driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(1000);
     String url="https://practice.automationtesting.in/";
    driver.get(url);
 }
}
