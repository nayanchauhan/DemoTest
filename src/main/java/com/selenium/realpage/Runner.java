package com.selenium.realpage;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/features",
        glue= {
                "com/selenium/realpage/pam/example/stepDefinitions",
                "com/selenium/realpage/pam/stepDefinitions"
        },
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class Runner {
}
