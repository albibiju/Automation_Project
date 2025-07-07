package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import pages.homePage;

public class homeTest extends BaseTestSuite {

    private homePage HomePage;

    @BeforeClass
    public void setUpPage() {
        HomePage = new homePage(getDriver());
    }

    // Title Verification
    @Test
    public void titleVerification() {
        String actualTitle = HomePage.getTitle();
        String expectedTitle = "Healthy Meals Online | Meal Kit Delivery Service - Kochi";
        Assert.assertEquals(actualTitle, expectedTitle, "Homepage title mismatch!");
        System.out.println("Title verified successfully.");
    }

    // URL Verification
    @Test
    public void urlVerification() {
        String expectedUrl = "https://theedibles.in/";
        String actualUrl = HomePage.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "Homepage URL mismatch!");
        System.out.println("URL verified successfully.");
    }

    // Logo Verification
    @Test
    public void logoVerification() {
        Assert.assertTrue(HomePage.isLogoDisplayed(), "Logo is not visible on homepage.");
        System.out.println("Logo is displayed correctly on homepage.");
    }

    // Secure Connection Verification
    @Test
    public void websiteIsSecure() {
        Assert.assertTrue(HomePage.isSecureConnection(), "Site is not using HTTPS.");
        System.out.println("Secure connection verified.");
    }
    
    // Scroll Verification
    @Test
    public void verifyPageScrollability() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();

        Number initialScrollNum = (Number) js.executeScript("return window.pageYOffset;");
        double initialScroll = initialScrollNum.doubleValue();

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        try {
            Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Number finalScrollNum = (Number) js.executeScript("return window.pageYOffset;");
        double finalScroll = finalScrollNum.doubleValue();

        Assert.assertTrue(finalScroll > initialScroll, "Page did not scroll.");
        System.out.println("Scrolling verified");

        HomePage.scrollToFooter();
        Assert.assertTrue(HomePage.isFooterLogoDisplayed(), "Footer not visible after scroll.");
        System.out.println("Footer Logo is visible after scrolling.");
    }

    
}