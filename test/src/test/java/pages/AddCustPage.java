package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class AddCustPage {
    WebDriver driver;

    By firstNameField = By.xpath("//input[@ng-model='fName']");
    By secondNameField = By.xpath("//input[@ng-model='lName']");
    By postCodeField = By.xpath("//input[@ng-model='postCd']");
    By addCustomerButton = By.xpath("//div[@class='form-group']/following-sibling::button");

    public AddCustPage(final WebDriver webDriver) {
        try {
            PageFactory.initElements(webDriver, this);
            this.driver = webDriver;
        } catch (IllegalStateException e) {
            throw new RuntimeException();
        }
    }
    public void setFirstName(String firstName) {
        this.driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void setSecondName(String secondName) {
        this.driver.findElement(secondNameField).sendKeys(secondName);
    }
    public void setPostCodeField(String postCode) {
        this.driver.findElement(postCodeField).sendKeys(postCode);
    }
    public void clickAddButton(){
        driver.findElement(addCustomerButton).click();

    }
    public String getaAlertText()  {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.switchTo().alert().getText();
    }
    public void acceptAlert()  {
        driver.switchTo().alert().accept();

    }
}
