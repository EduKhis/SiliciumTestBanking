package tests;

import lombok.Value;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ManagerPage;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class BaseTest {
    private static WebDriver driver;
    protected static ManagerPage managerPage;


    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/ed_his/Downloads/chromedriver-win64/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.of(10, ChronoUnit.SECONDS));
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
        managerPage = new ManagerPage(driver);
    }

    //@AfterClass
    //public static void quit() {
    //    driver.quit();
    //}
}
