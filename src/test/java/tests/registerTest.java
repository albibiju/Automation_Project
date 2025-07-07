package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.registerPage;

public class registerTest extends baseClass {
	
    registerPage RegisterPage;

    @BeforeMethod
    public void setup() {
        setUp(); 
//        addwait(); 
        RegisterPage = new registerPage(getDriver());
    }

    @Test
    public void testUserRegistration() {
    	RegisterPage.clickRegisterNav();
    	RegisterPage.enterFirstName("First");
    	RegisterPage.enterLastName("Last");
    	RegisterPage.enterMobile("9876543210");
    	RegisterPage.enterEmail("testab@gmail.com");
    	RegisterPage.enterPassword("Test@1234");
    	RegisterPage.enterRepeatPassword("Test@1234");
    	RegisterPage.clickRegister();
    }


}
