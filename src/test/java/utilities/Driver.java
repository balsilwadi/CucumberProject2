package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null){
            String browser = ConfigReader.getProperty("browser");

            switch(browser){
                case "chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case "IE" -> {
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                }
                case "headless" -> {
                    driver = new HtmlUnitDriver();
                }
            }
            if(!browser.equals("headless")){
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitWait")), TimeUnit.SECONDS);
            }
        } return driver;
    }

    public static void quitDriver(){
        driver.manage().deleteAllCookies();
        driver.quit();
        driver = null;
    }
}
