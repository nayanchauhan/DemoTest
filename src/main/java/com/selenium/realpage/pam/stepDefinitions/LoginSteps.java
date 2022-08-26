package com.selenium.realpage.pam.stepDefinitions;

import com.selenium.realpage.pam.pageObject.LoginPage;
import com.selenium.realpage.common.cucumber.TestContext;
import com.selenium.realpage.common.manager.ReaderManager;
import com.selenium.realpage.dataTypes.TestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    TestContext testContext;
    LoginPage loginPage;
    TestData testData;

    public LoginSteps(TestContext testContext) {
        this.testContext = testContext;
        loginPage = testContext.getPageManager().getLoginPage();
    }

    @Given("I am the main page")
    public void i_am_the_main_page() {
    }

    @When("I am in the login page")
    public void i_am_in_the_login_page() {
        loginPage.goToURL();
    }


    @And("Type my user and my pass for test {string}")
    public void type_my_user_and_my_pass_for_test(String testID) {
        testData = ReaderManager.getInstance().getJsonReader().getDataTestById(testID);
        loginPage.fill_Login(testData);
        loginPage.clickOnLogin();
    }

    @Then("The main page should be open")
    public void the_main_page_should_be_open() {
        Assert.assertEquals(testData.loginAssert,loginPage.getMessage());
    }

    @And("Type the user user and the pass password for test {string}")
    public void type_the_user_and_the_pass(String idTest) {
        ReaderManager.getInstance().getJsonReader().PathFile("\"TestData.json\"");
        testData = ReaderManager.getInstance().getJsonReader().getDataTestById(idTest);
        loginPage.fill_Login(testData);
        loginPage.clickOnLogin();

    }

    @Then("The system should show an error")
    public void the_system_should_show_the_error() {
        Assert.assertEquals(testData.loginAssert,loginPage.getErrorMessage());
    }

    @And("Type my password password for test {string}")
    public void type_my_password(String testId) {
        testData = ReaderManager.getInstance().getJsonReader().getDataTestById(testId);
        loginPage.fill_Login(testData);
    }

    @Then("The system should masked it")
    public void the_system_should_masked_it() {
        Assert.assertTrue(loginPage.getAttribute());
    }

    @And("Click on Sign out")
    public void click_on_sign_out() {
        loginPage.clickOnSingOutLink();
    }
    @And("Click on back button")
    public void click_on_back_button() {
        testContext.getDriverManager().navigateBack();
    }
    @Then("should redirect to login page")
    public void should_redirect_to_login_page() {
        Assert.assertNotNull(loginPage.getLoginForm());
    }
}
