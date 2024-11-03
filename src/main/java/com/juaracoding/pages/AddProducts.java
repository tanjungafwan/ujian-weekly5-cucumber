package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddProducts {

    private WebDriver driver;

    public AddProducts(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement btnAddBackPack;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement btnBikeLight;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement btnCart;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement itemCheckOut;

    /*public void addProduct(){
        btnAddBackPack.click();
        btnBikeLight.click();
    }*/

    public void addBackPack(){
        btnAddBackPack.click();
    }
    public void addBikeLight(){
        btnBikeLight.click();
    }

    public void checkCart(){
        btnCart.click();
    }

    public void checkOut(){
        itemCheckOut.click();
    }

}
