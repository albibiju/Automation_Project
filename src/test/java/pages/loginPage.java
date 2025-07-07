package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class loginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By loginNavButton = By.xpath("//li[@id='menu-item-322']//a[normalize-space()='Sign In']");
    private By emailField     = By.xpath("//div[@class='wpb_wrapper']//input[@id='username']");
    private By passwordField  = By.xpath("//div[@class='wpb_wrapper']//input[@id='password']");
    private By loginButton    = By.xpath("//div[@class='wpb_wrapper']//button[@name='login'][normalize-space()='Sign In']");
    private By logoutButton   = By.xpath("//a[normalize-space()='Logout']");
    private By modalDialog    = By.cssSelector("div.signinmodal.show");  

    public void clickLoginNav() {
        try {
            if (isModalVisible()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='none';", driver.findElement(modalDialog));
            }
        } catch (NoSuchElementException ignored) {
        }

        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(loginNavButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginLink);
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailField)).sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
    }

    public boolean isLogoutVisible() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    private boolean isModalVisible() {
        try {
            return driver.findElement(modalDialog).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
