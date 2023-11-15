package formPOM;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import formPage.MainForm;
import formPOM.UserInfo;
public class FormAutomate {
	static WebDriver driver;
	static MainForm mainForm;

	public static void main(String[] args) throws Exception {
		init();
		fillOutForm();
	
	}
	static void init() {
		System.setProperty("webdriver.chrome.driver","c:\\selenium\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
//		options.addArguments("ignore-ssl-errors=yes", "ignore-certificate-errors");		
		options.setAcceptInsecureCerts(true);
		driver= new ChromeDriver(options);
		
		driver.manage().window().maximize();
		String urlString="https://demoqa.com/automation-practice-form";
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(urlString);
	 mainForm = PageFactory.initElements(driver, MainForm.class);
	}
	
	static  void fillOutForm() throws Exception {
		String fpath = System.getProperty("user.dir");
		System.out.println(fpath);
		List<UserInfo>  users = Util.readInfoFromExcell(fpath +"\\src\\seleniumData\\Book1.xlsx");
		UserInfo user1=users.get(0);
	
	   mainForm.setFname(user1.getFrstName());
		mainForm.setLname(user1.getLstName());
		mainForm.setEmail(user1.getEmail());
		mainForm.setGender(user1.getGender());
		mainForm.setMobile(user1.getMobile());
		mainForm.setDOB(user1.getDOB());		
		mainForm.setAddr(user1.getAddr());
		mainForm.setState(user1.getState());
		mainForm.setCity(user1.getCity());
		mainForm.setSubject(user1.getSubject());
		mainForm.setPicLoc(user1.getPicLoc());
	}


}
