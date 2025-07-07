package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.loginPage;

public class loginTest extends BaseTestSuite {

    private loginPage LoginPage;

    @Test
    public void testUserLogin() {
    	LoginPage = new loginPage(getDriver());
        LoginPage.clickLoginNav();
        LoginPage.enterEmail("testab@gmail.com");
        LoginPage.enterPassword("Test@1234");
        LoginPage.clickLoginButton();
        
        Assert.assertTrue(LoginPage.isLogoutVisible(), "Login failed!!!");
        System.out.println("Login successful");
    }
    


}
