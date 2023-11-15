package alertPractice;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Selectable {
	static WebDriver driver;
	

	public static void main(String[] args) {
		init();
		selectRow();
	}
	public static void init() {
		System.setProperty("webdriver.chrome.driver", "c:\\selenium\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String url="https://jqueryui.com/selectable/";
		driver.get(url);
	}
	public static void  selectRow() {
	List<WebElement > item=driver.findElements(By.xpath("//*[@id='selectable']/li"));
		//1,3,6,7 
	 int g= item.size();
	 System.out.println(g);
			 
		Actions actions =new Actions(driver);
	//	actions.keyDown(KeyEvent.VK_CONTROL);
	actions=actions.keyDown(Keys.CONTROL);
		for(int i=0; i<g; i++) {
			if(i==1 || i==3||i==4)
				continue;
			actions.click(item.get(i));
		}
           actions.keyUp(Keys.CONTROL).build().perform();
}
}