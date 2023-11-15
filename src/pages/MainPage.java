package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
	@FindBy(id="user-name")
        WebElement userName;
	@ FindBy(id="password")
	    WebElement psw;
	@FindBy(id="login-button")
	WebElement logIn;
	// actions 
	public void  setuserName() {
		 userName.sendKeys("standard_user");
		}
	public void setPsw() {
		psw.sendKeys("secret_sauce");
		}
	public void clickLog() {
		logIn.click();
	}
}
