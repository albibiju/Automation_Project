package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class logoutPage {

    private WebDriver driver;

    public logoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private By logoutLink = By.linkText("Logout");

    public void performLogout() {
        driver.navigate().to("https://theedibles.in/my-account/edit-address/");
        driver.findElement(logoutLink).click();

    }
}
