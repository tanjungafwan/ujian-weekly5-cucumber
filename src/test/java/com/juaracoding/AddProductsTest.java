package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddProducts;
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
import org.testng.Assert;

public class AddProductsTest {
    private static WebDriver driver;
    private static ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();
    private static AddProducts addProduct = new AddProducts();

    public AddProductsTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @BeforeAll
    public static void setUp(){
        DriverSingleton.getInstance("firefox");
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();
        addProduct = new AddProducts();
    }

    @AfterAll
    public static void finish(){
        Utils.delay(5);
        DriverSingleton.closeObjectsInstance();
    }

    @Given("User logged in")
    public void user_logged_in(){
        driver.get("https://www.saucedemo.com/");
        loginPage.loginUser("standard_user","secret_sauce");
        loginPage.setBtnLogin();
        extentTest.log(LogStatus.PASS,"User logged in");
    }

    @When("I click the add to cart button for backpack")
    public void i_click_the_add_to_cart_button_for_backpack(){
        addProduct.addBackPack();
        extentTest.log(LogStatus.PASS,"I click the add to cart button for backpack");
    }

    @And("I click the add to cart button for bike light")
    public void i_click_the_add_to_cart_button_for_bike_light(){
        addProduct.addBikeLight();
        extentTest.log(LogStatus.PASS,"I click the add to cart button for bike light");
    }

    @Then("I click cart confirmation button")
    public void i_click_cart_confirmation_button(){
        addProduct.checkCart();
        extentTest.log(LogStatus.PASS,"I click cart confirmation button");
    }

}
