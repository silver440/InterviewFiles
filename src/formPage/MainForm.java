package formPage;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

public class MainForm {
WebDriver driver;
 public MainForm(WebDriver driver) {
	 this.driver=driver;
 }
 @FindBy(id = "firstName")
	WebElement fName;
	@FindBy(id = "lastName")
	WebElement lName;
	@FindBy(id = "userEmail")
	WebElement Email;
	@FindBy(id = "gender-radio-1")
	WebElement male;
	@FindBy(id = "gender-radio-2")
	WebElement female;
	@FindBy(id = "gender-radio-3")
	WebElement other;
	@FindBy(id = "userNumber")
	WebElement Mobile;
	@FindBy(id="dateOfBirthInput")
	WebElement bd;
	@FindBy(className="react-datepicker__month-select")
	WebElement month;
	@FindBy(className="react-datepicker__year-select")
	WebElement year;
	@FindBys({@FindBy(xpath="//div[contains(@class,\"react-datepicker__day--\")]")})
	List<WebElement> days;
	@FindBy(id = "currentAddress")	
	WebElement Addr;
	@FindBy(id = "react-select-3-input")
	WebElement State;
	@FindBy(id = "react-select-4-input")
	WebElement City;
	@FindBy(id = "subjectsInput")
	WebElement Subject;
	@FindBy(id = "uploadPicture")
	WebElement PicLoc;

//Actions
public void setFname(String fn) {
	System.out.println(fn);
	System.out.println(fName.getAttribute("id"));
	fName.sendKeys(fn);
}

public void setLname(String ln) {
	lName.sendKeys(ln);
}

public void setEmail(String email) {
	Email.sendKeys(email);
}

public void setGender(String gn) {
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	if (gn.equalsIgnoreCase("female")) {
		// female.click();
		executor.executeScript("arguments[0].click()", female);
	} else if (gn.equalsIgnoreCase("male")) {
		// male.click();
		executor.executeScript("arguments[0].click()", male);
	} else if (gn.equalsIgnoreCase("other")) {
		// other.click();
		executor.executeScript("arguments[0].click()", other);
	}
}
public void setDOB(String dbirth) {
	String[] dob = dbirth.split("[/]"); // dob[0]=05 dob[1]=01

	String monthName = "";

	switch (dob[0]) {
	case "01":
		monthName = "January";
		break;
	case "02":
		monthName = "February";
		break;
	case "03":
		monthName = "March";
		break;
	case "04":
		monthName = "April";
		break;
	case "05":
		monthName = "May";
		break;
	case "06":
		monthName = "June";
		break;
	case "07":
		monthName = "July";
		break;
	case "08":
		monthName = "August";
		break;
	case "09":
		monthName = "September";
		break;
	case "10":
		monthName = "October";
		break;
	case "11":
		monthName = "November";
		break;
	case "12":
		monthName = "December";
		break;
	}

	String day = "";
	switch (dob[1]) {
	case "01":
		day = "1";
		break;
	case "02":
		day = "2";
		break;
	case "03":
		day = "3";
		break;
	case "04":
		day = "4";
		break;
	case "05":
		day = "5";
		break;
	case "06":
		day = "6";
		break;
	case "07":
		day = "7";
		break;
	case "08":
		day = "8";
		break;
	case "09":
		day = "9";
		break;
	default:
		day = dob[1];
		break;
	}
	
	bd.click();
	
	Select sel_month = new Select(month);
	sel_month.selectByVisibleText(monthName);

	Select sel_year = new Select(year);
	sel_year.selectByVisibleText(dob[2]);
	
	for (int i = 0; i < days.size(); i++) {
		if (!days.get(i).getText().equals(day))
			continue;
		if (days.get(i).getAttribute("class").contains("outside-month"))
			continue;
		days.get(i).click();
		break;
	}

}

public void setMobile(String mobile) {
	Mobile.sendKeys(mobile);
}

public void setAddr(String addr) {
	Addr.sendKeys(addr);
}

public void setState(String state) {
	State.sendKeys((state) + Keys.ENTER);
}

public void setCity(String city) {
	City.sendKeys((city) + Keys.ENTER);
}

public void setSubject(String subject) {
	Subject.sendKeys((subject) + Keys.ENTER);
}

public void setPicLoc(String picLoc) {
	PicLoc.sendKeys(picLoc);
}

}
