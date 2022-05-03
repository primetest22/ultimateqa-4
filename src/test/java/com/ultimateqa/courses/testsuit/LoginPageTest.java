package com.ultimateqa.courses.testsuit;

import com.ultimateqa.courses.pages.HomePage;
import com.ultimateqa.courses.pages.LoginPage;
import com.ultimateqa.courses.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //click on login
        homePage.clickOnLoginLink();
        String expectedMessage = "Welcome Back!";
        String actualMessage = loginPage.getWelcomeText();
        //validate text
        Assert.assertEquals(expectedMessage, actualMessage, "Welcome back text not displayed");

    }

    @Test
    public void verifyTheErrorMessage() {

        homePage.clickOnLoginLink();
        loginPage.enterEmail("123.com");
        loginPage.enterPassword("123");
        loginPage.clickOnLoginButton();
        String expectedDisplay = "Invalid email or password.";

        String actualDisplay = loginPage.getErrorMessage();
        Assert.assertEquals(expectedDisplay, actualDisplay, "error message");


    }

}
