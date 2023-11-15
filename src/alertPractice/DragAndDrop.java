package alertPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		init();
		drag();
	

	}
	 static void init() throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver","c:\\selenium\\chromedriver.exe");
		   driver=new ChromeDriver();
		   driver.manage().window().minimize();
		     Thread.sleep(5000);
		   String urlString="https://selenium08.blogspot.com/2020/01/drag-drop.html";
		    driver.get(urlString);
		  
	 }
	 static void drag() {
		 WebElement draggable=driver.findElement(By.id("draggable"));
		 WebElement   droppable=driver.findElement(By.id("droppable"));
		 Actions actions=new Actions(driver);
		 actions.dragAndDrop(draggable, droppable);
		 actions.build().perform();
		 System.out.println("Drag and Drop action has been performed successfully");
	 }

}
