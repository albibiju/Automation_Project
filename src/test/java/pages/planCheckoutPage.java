package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;
import java.io.File;
import java.io.IOException;

public class planCheckoutPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public planCheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


	private By selectYourPlanBtn = By.xpath("//*[@id=\"menu-item-1138\"]/a");
	private By dietCategory = By.xpath("//*[@id=\"main\"]/div/div[4]/div/div/div/div/div/div[1]/ul/li[4]/a");  
	private By planChooseBtn = By.xpath("//*[@id=\"low-crab-monthly\"]/div[2]/div/ul/li[4]/form/button");
	  
	private By goalOption = By.xpath("//label[@for='cloudways_exercise_setyourgoal_muscle-gain']");
	private By goalNextButton = By.xpath("//button[@id='action-next']");

	// Personal Details
    private By nameField = By.id("cloudways_info_name_field");
    private By ageField = By.id("cloudways_info_age_field");
    private By dobField = By.id("cloudways_info_dob_field");
    private By genderDropdown = By.id("cloudways_info_gender_field");
    private By heightField = By.id("cloudways_info_height_field");
    private By weightField = By.id("cloudways_info_weight_field");
    private By activityDropdown = By.id("cloudways_info_Physical_Activity_field");
    private By phoneField = By.id("cloudways_info_phone_field");
    private By emailField = By.id("cloudways_info_email_field");
    private By zipField = By.id("billing_postcode");
    private By streetAddressField = By.id("street_address");
    private By cityField = By.id("town_city");
    private By nextButton2 = By.id("action-next");
    
    // Extra Delivery Address
    private By extraAddressCheckbox = By.id("ship-to-different-address-checkbox"); 
    private By nextButton3 = By.id("action-next");
    
    // Health & Food Details
    private By foodAllergiesField = By.xpath("//*[@id=\"cloudways_food_allergies_field\"]");
    private By medicalConditionsField = By.xpath("//*[@id=\"cloudways_medical_conditions_field\"]");
    private By foodChallengeField = By.xpath("//*[@id=\"cloudways_food_lifestyle_field\"]");
    private By favoriteFoodsField = By.xpath("//*[@id=\"cloudways_foods_enjoy_field\"]");
    private By mealPlanGoalField = By.xpath("//*[@id=\"cloudways_goal_meal_field\"]");
    private By nextButton4 = By.id("action-next");

    private By exerciseYesRadio = By.id("cloudways_exercise_field_yes");
    private By exerciseNoRadio = By.id("cloudways_exercise_field_no");
    private By workoutDetailsField = By.id("cloudways_type_work_field");

    
    public void clickSelectYourPlan() {
        driver.findElement(selectYourPlanBtn).click();
    }

    public void chooseDietCategory() throws InterruptedException {
        driver.findElement(dietCategory).click();
        driver.findElement(planChooseBtn).click();
    }

    public void selectGoal() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            WebElement goal = wait.until(ExpectedConditions.elementToBeClickable(goalOption));
            goal.click();

            WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(goalNextButton));
            js.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
            js.executeScript("arguments[0].click();", nextBtn);

            wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
            System.out.println("Personal Info form loaded successfully.");

        } catch (Exception e) {
            System.out.println("Error in selectGoal: " + e.getMessage());
        }
    }


    public void fillPersonalInfo(String name, String age, String dob, String gender, String height, String weight, String activity, String phone, String email) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            WebElement nameElement = driver.findElement(nameField);
            js.executeScript("arguments[0].scrollIntoView(true);", nameElement);
            nameElement.sendKeys(name);

            driver.findElement(ageField).sendKeys(age);
            driver.findElement(dobField).sendKeys(dob);
            new Select(driver.findElement(genderDropdown)).selectByVisibleText(gender);
            driver.findElement(heightField).sendKeys(height);
            driver.findElement(weightField).sendKeys(weight);
            new Select(driver.findElement(activityDropdown)).selectByVisibleText(activity);
            driver.findElement(phoneField).sendKeys(phone);
            driver.findElement(emailField).sendKeys(email);

            System.out.println("Personal Info form filled successfully.");
        } catch (Exception e) {
            System.out.println("Error in fillPersonalInfo: " + e.getMessage());
        }
    }

    public void fillDeliveryAddress(String zip, String street, String city) {
        driver.findElement(zipField).clear();
        driver.findElement(zipField).sendKeys(zip);
        driver.findElement(streetAddressField).sendKeys(street);
        driver.findElement(cityField).sendKeys(city);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton2)).click();
    }

    public void fillExtraDeliveryNotes(boolean sameAddress) {
        try {
            if (sameAddress) {
                driver.findElement(extraAddressCheckbox).click();
            }

            WebElement nextBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton3));

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextBtn);

            wait.until(ExpectedConditions.elementToBeClickable(nextBtn));

            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextBtn);

        } catch (ElementClickInterceptedException e) {
            System.out.println("Click intercepted, retrying with JS click: " + e.getMessage());
            WebElement fallbackBtn = driver.findElement(nextButton3);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", fallbackBtn);
        } catch (Exception e) {
            System.out.println("Error in fillExtraDeliveryNotes: " + e.getMessage());
        }
    }

    public void fillHealthAndFoodDetails(
            String allergies, String conditions, String challenge, String foods,
            boolean doesExercise, String workoutDetails, String goal) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        try {
            WebElement allergiesField = wait.until(ExpectedConditions.visibilityOfElementLocated(foodAllergiesField));
            js.executeScript("arguments[0].scrollIntoView(true);", allergiesField);
            allergiesField.sendKeys(allergies);

            driver.findElement(medicalConditionsField).sendKeys(conditions);
            driver.findElement(foodChallengeField).sendKeys(challenge);
            driver.findElement(favoriteFoodsField).sendKeys(foods);

            if (doesExercise) {
                js.executeScript("arguments[0].click();", driver.findElement(exerciseYesRadio));
                driver.findElement(workoutDetailsField).sendKeys(workoutDetails);
            } else {
                js.executeScript("arguments[0].click();", driver.findElement(exerciseNoRadio));
            }

            driver.findElement(mealPlanGoalField).sendKeys(goal);
            WebElement nextBtn = wait.until(ExpectedConditions.elementToBeClickable(nextButton4));
            js.executeScript("arguments[0].scrollIntoView(true);", nextBtn);
            nextBtn.click();

        } catch (TimeoutException e) {
            System.out.println("Timeout waiting for Health and Food Details section: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General exception in fillHealthAndFoodDetails: " + e.getMessage());
        }
    }

    public void captureFullPageScreenshot(String filePath) throws InterruptedException {
    	Thread.sleep(10000);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File(filePath));
            System.out.println("Full page screenshot saved: " + filePath);
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: " + e.getMessage());
        }
    }
}

