package tests;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTestSuite extends baseClass {

    @BeforeSuite
    public void globalSetup() {
        setUp();
    }

    @AfterSuite
    public void globalTearDown() {
//        tearDown();
    }
}