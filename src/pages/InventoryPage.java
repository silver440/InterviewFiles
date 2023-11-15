package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage {
	  @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-backpack\"]")
	      WebElement item1;
	  @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
	     WebElement item2;
	  @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-onesie\"]")
	      WebElement item3;
	  @FindBy(xpath = "//*[text()=\"Open Menu\"]")
	     WebElement menu1;
	  @FindBy(xpath = "//*[text()=\"Logout\"]")
	    WebElement logOut;
	  
	  
	  		//ACTIONS
	  public void addItem1() {
		  item1.click();
	  }
	  public void addItem2() {
		  item2.click();
	  }
	 public void addItem3() {
		 item3.click();
	 }
     public void clickMenu1() {
    	 menu1.click();
     }
     public void logOut() {
    	 logOut.click();
     }
}
