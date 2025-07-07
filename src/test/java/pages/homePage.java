package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {

    private WebDriver driver;

    public homePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By logo = By.xpath("//div[contains(@class,'col-lg-2 col-md-2 text-center home-icon-ima')]//a");
    private final By footerLogo = By.xpath("/html/body/footer/div/div[1]/div[1]/a/img");

    
    public void navigateToHomePage() {
        driver.get("https://theedibles.in/"); 
    }
    
    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean isLogoDisplayed() {
        return driver.findElement(logo).isDisplayed();
    }

    public boolean isSecureConnection() {
        return driver.getCurrentUrl().startsWith("https://");
    }
    
    public void scrollToFooter() {
        WebElement footerElement = driver.findElement(footerLogo);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", footerElement);
    }

    public boolean isFooterLogoDisplayed() {
        return driver.findElement(footerLogo).isDisplayed();
    }
}
