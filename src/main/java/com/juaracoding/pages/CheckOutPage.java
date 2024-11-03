package com.juaracoding.pages;
import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {

    private WebDriver driver;

    public CheckOutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class='title']")
    private WebElement checkOutInfo;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement zipCode;

    @FindBy(xpath = "//div[normalize-space()='Payment Information:']")
    private WebElement validInformation;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement btnContinue;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement btnFinish;

    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement btnBackHome;

    @FindBy(xpath = "//div[contains(@class, 'error-message-container')]//h3[contains(@data-test, 'error') and (contains(text(), 'First Name is required') or contains(text(), 'Postal Code is required'))]")
    private WebElement invalidInformation;

    /*public void inputInformation(String firstName, String lastName, String zipCode){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.zipCode.sendKeys(zipCode);
    }*/

    public void setFirstName(String firstName){
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        this.lastName.sendKeys(lastName);
    }

    public void setZipCode(String zipCode){
        this.zipCode.sendKeys(zipCode);
    }

    public void getContinueBtn(){
        btnContinue.click();
    }

    public void finish(){
        btnFinish.click();
    }

    public void backHome(){
        btnBackHome.click();
    }

    public String inputValidInformation(){
        return validInformation.getText();
    }

    public String isOnCheckOutPage(){
        return checkOutInfo.getText();
    }

    public String inputInvalidInformation(){
        return invalidInformation.getText();
    }

}
