package alertPractice;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 

public class ScrollSideBar {
	static WebDriver driver;
	public static void main(String[]args) {
		System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	     String urlString="https://yahoo.com";
	     driver.get(urlString);
	     JavascriptExecutor js=(JavascriptExecutor)driver;
//	     js.executeScript("window.scrollBy(0,1000)");
	     js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

}
