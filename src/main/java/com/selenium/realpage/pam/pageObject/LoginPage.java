package com.selenium.realpage.pam.pageObject;

import com.selenium.realpage.common.manager.ReaderManager;
import com.selenium.realpage.dataTypes.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    // Login Elements
    @FindBy(how = How.ID, using = "fAELogin")
    private WebElement loginForm;

    @FindBy(how = How.ID, using = "_ctl6_tbUserName")
    private WebElement usernameField;

    @FindBy(how = How.ID, using = "_ctl6_tbPassword")
    private WebElement passwordField;

    @FindBy(how = How.ID, using = "_ctl6_btnLogin")
    private WebElement loginButton;

    @FindBy(how = How.ID, using = "_ctl6_cbPersist")
    private WebElement rememberCheckbox;

    @FindBy(how = How.ID, using = "lnkforgotpwd")
    private WebElement lossPasswordLink;

    @FindBy(how = How.CSS, using = "a[href='Logoff.aspx']")
    private WebElement signOutlink;


    // message
    @FindBy(how = How.CSS, using = ".woocommerce-error li")
    private WebElement errorMessage;

    @FindBy(how = How.ID, using = "raul-header-user-handle")
    private WebElement myAccauntMessage;

    public void EnterUser(String userName) {
        usernameField.sendKeys(userName);
    }

    public void EnterPassword(String userPassword) {
        passwordField.sendKeys(userPassword);
    }

    /**
     * Get the response in case the system shows an error en the login o Register process
     * @return = return a message the system shows
     */
    public String getErrorMessage(){
        return errorMessage.getText();
    }

    public void goToURL(){
        driver.get(ReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

    public void clickOnLogin() {
        loginButton.click();
    }

    public void clickOnSingOutLink(){
        signOutlink.click();
    }

    public boolean getAttribute(){
        return passwordField.getAttribute("type").equals("password");
    }
    public String getMessage() {
        return myAccauntMessage.getText();
    }

    public void fill_Login(TestData testData){
        EnterUser(testData.userName);
        EnterPassword(testData.password);
    }

    public Object getLoginForm() {
        return loginForm;
    }
}
