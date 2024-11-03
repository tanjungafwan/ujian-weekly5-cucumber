package com.juaracoding;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/main/resources/features/01Login.feature",
        "src/main/resources/features/02AddProducts.feature",
"src/main/resources/features/03CheckOutPage.feature"},
    glue = {"com.juaracoding"},
    plugin = {"pretty", "html:target/cucumber-reports.html","json:target/cucumber.json"})
public class TestRunner extends AbstractTestNGCucumberTests {

}
