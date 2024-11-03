package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.AddProducts;
import com.juaracoding.pages.CheckOutPage;
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

public class CheckOutPageTest {
    private static WebDriver driver;
    private static ExtentTest extentTest;
    private static LoginPage loginPage = new LoginPage();
    private static AddProducts addProduct = new AddProducts();
    private static CheckOutPage checkOutPage = new CheckOutPage();

    public CheckOutPageTest(){
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @BeforeAll
    public static void setUp(){
        DriverSingleton.getInstance("firefox");
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();
        addProduct = new AddProducts();
        checkOutPage = new CheckOutPage();
    }

    @AfterAll
    public static void finish(){
        Utils.delay(5);
        DriverSingleton.closeObjectsInstance();
    }

    @Given("The user is on the checkout page")
    public void the_user_is_on_the_checkout_page(){
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        Utils.delay(10);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/checkout-step-one.html");
        Assert.assertEquals(checkOutPage.isOnCheckOutPage(),"Checkout: Your Information");
        extentTest.log(LogStatus.PASS,"The user is on the checkout page");
    }

    @And("The user enters their first name")
    public void the_user_enters_their_first_name(){
        checkOutPage.setFirstName("Rizki");
        extentTest.log(LogStatus.PASS,"The user is on the checkout page");
    }

    @And("The user enters their last name")
    public void the_user_enters_their_last_name(){
        checkOutPage.setLastName("Afwan");
        extentTest.log(LogStatus.PASS,"The user enters their last name");
    }

    @And("The user enters their zip code")
    public void the_user_enters_their_zip_code(){
        checkOutPage.setZipCode("12345");
        extentTest.log(LogStatus.PASS,"The user enters their zip code");
    }

    @And("The user clicks the continue button")
    public void the_user_clicks_the_continue_button(){
        checkOutPage.getContinueBtn();
        extentTest.log(LogStatus.PASS,"The user clicks the continue button");
    }

    @Then("The user should see valid information displayed")
    public void the_user_should_see_valid_information_displayed(){
        Assert.assertEquals(checkOutPage.inputValidInformation(),"Payment Information:");
        extentTest.log(LogStatus.PASS,"The user should see valid information displayed");
    }

    @When("The user clicks the finish button")
    public void the_user_clicks_the_finish_button(){
        checkOutPage.finish();
        extentTest.log(LogStatus.PASS,"The user clicks the finish button");
    }

    @Then("The user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage(){
        checkOutPage.backHome();
        extentTest.log(LogStatus.PASS,"The user should be redirected to the homepage");
    }

    @Given("The user is on the home page")
    public void the_user_is_on_the_home_page(){
        driver.get("https://www.saucedemo.com/inventory.html");
        Utils.delay(10);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(loginPage.getValidLogin(),"Swag Labs");
        extentTest.log(LogStatus.PASS,"The user is on the home page");
    }

    @And ("The user click the add to cart button for backpacks")
    public void the_user_click_the_add_to_cart_button_for_backpacks(){
        addProduct.addBackPack();
        extentTest.log(LogStatus.PASS,"The user click the add to cart button for backpack");
    }

    @And ("The user click cart confirmation buttons")
    public void the_user_click_cart_confirmation_button(){
        addProduct.checkCart();
        extentTest.log(LogStatus.PASS,"The user click cart confirmation buttons");
    }

    @And ("The user click the checkout buttons")
    public void the_user_click_the_checkout_buttons(){
        addProduct.checkOut();
        extentTest.log(LogStatus.PASS,"The user click the checkout buttons");
    }

    @And ("The user click the continue buttons")
    public void the_user_click_the_continue_buttons(){
        checkOutPage.getContinueBtn();
        extentTest.log(LogStatus.PASS,"The user click the continue buttons");
    }

    @Then("The user will get warning")
    public void the_user_will_get_warning(){
        checkOutPage.setFirstName("");
        Assert.assertEquals(checkOutPage.inputInvalidInformation(),"Error: First Name is required");
        extentTest.log(LogStatus.PASS,"The user will get warning");
    }
}
