package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	

	@FindBy (xpath="//input[@name='username']")
	private WebElement textBox1;
	
	@FindBy (xpath="//input[@name='password']")
	private WebElement passBox;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginButton;
	
	
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	public void enterCred(String user,String pass ) {
		
		textBox1.sendKeys(user);
		passBox.sendKeys(pass);
		
	}
	
	public boolean isEnabled () {
		
		return loginButton.isEnabled();
	}
	
	public void clickButton () {
		
		loginButton.click();
	}


}
