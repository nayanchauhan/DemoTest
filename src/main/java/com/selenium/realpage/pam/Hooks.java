package com.selenium.realpage.pam;

import com.selenium.realpage.common.cucumber.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void beforeSteps(){
        System.out.println("Before");
    }

    @After
    public void afterSteps(){
        testContext.getDriverManager().closeDriver();
    }
}
