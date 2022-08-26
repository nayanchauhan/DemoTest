package com.selenium.realpage.common.manager;

import com.selenium.realpage.common.enums.DriverType;
import com.selenium.realpage.common.enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverManager {
    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;

    public DriverManager() {
        driverType = ReaderManager.getInstance().getConfigReader().getBrowser();
        environmentType = ReaderManager.getInstance().getConfigReader().getEnvironment();
    }

    public WebDriver getDriver(){

        if (driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    private WebDriver createDriver() {
        switch (environmentType){
            case LOCAL:
                driver = createLocalDriver();
                break;
            case REMOTE:
                driver = createRemoteDriver();
                break;
        }
        return driver;
    }

    private WebDriver createLocalDriver() {
        switch (driverType){
            case CHROME:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case INTERNETEXPLORER:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }
        if (ReaderManager.getInstance().getConfigReader().getBrowserWindowSize()){
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ReaderManager.getInstance().getConfigReader().getImplicitlyWait()));
        return driver;
    }

    private WebDriver createRemoteDriver() {
        throw new RuntimeException("RemoteWebDriver is not yet implemented");
    }

    public Alert switchToAlert(){
        return driver.switchTo().alert();
    }

    public void switchToIframeBy(Integer id){
        driver.switchTo().frame(id);
    }

    public void switchToIframeBy(String name){
        driver.switchTo().frame(name);
    }

    public void navigateBack(){
        driver.navigate().back();
    }

    public void closeDriver(){
        driver.quit();
    }
}
