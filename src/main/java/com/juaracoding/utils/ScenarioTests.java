package com.juaracoding.utils;

public enum ScenarioTests {

    // T1 - T10000
    // feature login
    T1("Successful login with valid credentials"),
    T2("Invalid login with invalid credentials"),
    T3("Valid login with blank email credentials"),
    T4("Valid login with blank password credentials"),
    T5("Valid login with locked out user"),
    // feature add products
    T6("Adding products to cart"),
    // feature check out products
    T7("Succesful checkout process"),
    T8("Unsuccesful checkout process");

    private String scenarioTestName;
    ScenarioTests(String value){
        scenarioTestName = value;
    }

    public String getScenarioTestName(){
        return scenarioTestName;
    }

}
