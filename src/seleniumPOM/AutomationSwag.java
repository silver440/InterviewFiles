package seleniumPOM;

import java.util.concurrent.TimeUnit;

import javax.security.auth.login.LoginContext;

import org.apache.commons.math3.analysis.function.Inverse;
import org.apache.poi.hpbf.model.MainContents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import pages.InventoryPage;
import pages.MainPage;

public class AutomationSwag {
	static WebDriver driver;
	static InventoryPage inventoryPage;
	static MainPage mainPage;
	static FluentWait wait;
	
	

	public static void main(String[] args) throws InterruptedException {
		init();
		logIn();
		logOut();
		
		
	}
	public static void init () {
		System.setProperty("webdriver.chrome.driver","c:\\selenium\\chromedriver.exe");
    	driver=new ChromeDriver();
    	driver.manage().window().maximize();
    	driver.get("https://www.saucedemo.com/");
    	inventoryPage=PageFactory.initElements(driver, InventoryPage.class);
    	mainPage=PageFactory.initElements(driver, MainPage.class);
	}	
	public static void logIn() {
		mainPage.setuserName();
		mainPage.setPsw();
		mainPage.clickLog();
	}
	public static void logOut() throws InterruptedException {
		inventoryPage.addItem1();
		inventoryPage.addItem2();
		inventoryPage.addItem3();
		inventoryPage.clickMenu1();
		Thread.sleep(1000);
		inventoryPage.logOut();
		driver.close();
	}

	
	}

	


