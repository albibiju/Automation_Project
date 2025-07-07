package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class registerPage {
	
	   WebDriver driver;

	    public registerPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    private By registerNavButton    = By.xpath("//li[@id='menu-item-321']//a[normalize-space()='Register']");
	    private By firstName = By.name("billing_first_name");
	    private By lastName = By.name("billing_last_name");
	    private By mobile = By.name("billing_phone");
	    private By email = By.name("email");
	    private By password = By.xpath("//div[@class='wpb_wrapper']//input[@id='reg_password']");
	    private By repeatPassword = By.xpath("//div[@class='wpb_wrapper']//input[@id='reg_password2']");
	    private By registerButton = By.xpath("//div[@class='wpb_wrapper']//button[@name='register'][normalize-space()='Sign up']");
	    
	    public void clickRegisterNav() {
	        driver.findElement(registerNavButton).click();
	    }
	    
	    public void enterFirstName(String fname) {
	        driver.findElement(firstName).sendKeys(fname);
	    }

	    public void enterLastName(String lname) {
	        driver.findElement(lastName).sendKeys(lname);
	    }

	    public void enterMobile(String mob) {
	        driver.findElement(mobile).sendKeys(mob);
	    }

	    public void enterEmail(String mail) {
	        driver.findElement(email).sendKeys(mail);
	    }

	    public void enterPassword(String pass) {
	        driver.findElement(password).sendKeys(pass);
	    }

	    public void enterRepeatPassword(String rpass) {
	        driver.findElement(repeatPassword).sendKeys(rpass);
	    }

	    public void clickRegister() {
	        driver.findElement(registerButton).click();
	    }

}
