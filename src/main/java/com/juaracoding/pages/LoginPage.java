package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utils.Utils;
import jdk.jshell.execution.Util;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement btnLogin;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement userSlideRight;

    @FindBy(xpath = "//a[@id='logout_sidebar_link']")
    private WebElement btnLogout;

    @FindBy(xpath = "//*[@id='header_container']/div[1]/div[2]/div")  //span[@]
    private WebElement valid;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtInvalid;


    public void loginUser(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
    }

    public void clearFields() {
        Utils.delay(5);
        username.clear();
        password.clear();
    }

    public void setBtnLogin(){
        btnLogin.click();
    }

    public void logout(){
        userSlideRight.click();
        btnLogout.click();
    }

    public String getValidLogin(){
        return valid.getText();
    }

    public String getTxtInvalidUsernamePassword(){
        return txtInvalid.getText();
    }

    public String getTxtInvalidUsername(){
        return txtInvalid.getText();
    }

    public String getTxtInvalidPassword(){
        return txtInvalid.getText();
    }

    public String getTxtLockedOutUser(){
        return txtInvalid.getText();
    }


}
