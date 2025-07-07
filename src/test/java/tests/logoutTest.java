package tests;

import org.testng.annotations.Test;
import pages.logoutPage;


public class logoutTest extends BaseTestSuite {

    @Test
    public void testLogoutFunctionality() {
        logoutPage logout = new logoutPage(driver);
        logout.performLogout();
    }
}
