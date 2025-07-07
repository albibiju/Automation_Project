package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.planCheckoutPage;

public class planCheckoutTest extends BaseTestSuite {

    private planCheckoutPage PlanCheckoutPage;

    @Test
    public void testPlanSelectionToCheckout() throws InterruptedException {
    	PlanCheckoutPage = new planCheckoutPage(getDriver());
    	
        PlanCheckoutPage.clickSelectYourPlan();
        PlanCheckoutPage.chooseDietCategory();
         
        PlanCheckoutPage.selectGoal();
        
        PlanCheckoutPage.fillPersonalInfo("Test User", "25", "25/12/2000", "Male", "200", "90",
        "Moderately Active", "9876543210", "test@gmail.com");
        PlanCheckoutPage.fillDeliveryAddress("682021", "Kakkanad", "Kochi");
        
        PlanCheckoutPage.fillExtraDeliveryNotes(true);
        
        PlanCheckoutPage.fillHealthAndFoodDetails(
                "None", 
                "No major issues", 
                "Hard to follow diet on weekends", 
                "Vegetables, Chicken",
                true,
                "Jogging 30 minutes daily",
                "Gain lean muscle"
            );
        
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(35));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='place_order']")));
        
        PlanCheckoutPage.captureFullPageScreenshot("screenshots/product_summary.png");


    }
}


