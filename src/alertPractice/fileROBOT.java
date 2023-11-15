package alertPractice;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class fileROBOT {
	 static WebDriver driver;
	 

	public static void main(String[] args) throws AWTException {
		System.setProperty("webdriver.chrome.driver","c:\\selenium\\chromedriver.exe");
    	driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	String urlString=("https://demoqa.com/upload-download");
    	driver.get(urlString);
 //  	driver.findElement(By.id("uploadFile")).sendKeys("c:\\sham\\test.txt");
        Robot  robot=new Robot();
    	driver.findElement(By.id("uploadFile")).click();
    	robot.keyPress(0);
    	
	}

}
