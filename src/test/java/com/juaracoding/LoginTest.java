package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class LoginTest {

//    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    private static WebDriver driver;
    private static ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();

    public LoginTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @BeforeAll
    public static void setUp(){
        DriverSingleton.getInstance("firefox");
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();
    }

    @AfterAll
    public static void finish(){
        Utils.delay(5);
        DriverSingleton.closeObjectsInstance();
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page(){
        driver.get("https://www.saucedemo.com/");
        extentTest.log(LogStatus.PASS,"I am on the login page");
    }

    @When("I enter valid username and password")
    public void i_enter_valid_username_and_password(){
        loginPage.loginUser("standard_user","secret_sauce");
        extentTest.log(LogStatus.PASS,"I enter valid username and password");
    }

    @And("I click the login button")
    public void i_click_the_login_button(){
        loginPage.setBtnLogin();
        extentTest.log(LogStatus.PASS,"I click the login button");
    }

    @Then("I should see the products page")
    public void i_should_see_the_products_page(){
        Assert.assertEquals(loginPage.getValidLogin(),"Swag Labs");
        extentTest.log(LogStatus.PASS,"I should see the products page");
    }

    @When("I am logout")
    public void i_am_logout(){
        loginPage.logout();
        extentTest.log(LogStatus.PASS,"I am logout");
    }

    @And("I enter invalid username and password")
    public void i_enter_invalid_username_and_password(){
        loginPage.loginUser("invalid","invalid");
        extentTest.log(LogStatus.PASS,"I enter invalid username and password");
    }

    @Then("Show message invalid credentials")
    public void show_message_invalid_credentials(){
        Assert.assertEquals(loginPage.getTxtInvalidUsernamePassword(),"Epic sadface: Username and password do not match any user in this service");
        extentTest.log(LogStatus.PASS,"Show message invalid credentials");
    }

    @When("I enter valid password and blank username")
    public void i_enter_valid_password_and_blank_username(){
        loginPage.clearFields();
        loginPage.loginUser("","secret_sauce");
        extentTest.log(LogStatus.PASS,"I enter valid password and blank username");
    }

    @Then("I should see the message invalid credentials blank username")
    public void i_should_see_the_message_invalid_credentials_blank_username(){
        Assert.assertEquals(loginPage.getTxtInvalidUsername(),"Epic sadface: Username is required");
        extentTest.log(LogStatus.PASS,"I should see the message invalid credentials blank username");
    }

    @When("I enter valid username and blank password")
    public void i_enter_valid_username_and_blank_password(){
        loginPage.clearFields();
        loginPage.loginUser("standard_user","");
        extentTest.log(LogStatus.PASS,"I enter valid username and blank password");
    }

    @Then("I should see the message invalid credentials blank password")
    public void i_should_see_the_message_invalid_credentials_blank_password(){
        Assert.assertEquals(loginPage.getTxtInvalidPassword(),"Epic sadface: Password is required");
        extentTest.log(LogStatus.PASS,"I should see the message invalid credentials blank password");
    }

    @When("I enter valid locked out username and valid password")
    public void i_enter_valid_locked_out_username_and_valid_password(){
        loginPage.clearFields();
        loginPage.loginUser("locked_out_user","secret_sauce");
        extentTest.log(LogStatus.PASS,"I enter valid locked out username and valid password");
    }

    @Then("I should see the message invalid credentials locked out user")
    public void i_should_see_the_message_invalid_credentials_locked_out_user(){
        Assert.assertEquals(loginPage.getTxtLockedOutUser(),"Epic sadface: Sorry, this user has been locked out.");
        loginPage.clearFields();
        extentTest.log(LogStatus.PASS,"I should see the message invalid credentials locked out user");
    }
}
