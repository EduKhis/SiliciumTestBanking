package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManagerPage {
    WebDriver driver;
    @FindBy(xpath = "//button[@ng-click='addCust()']")
    WebElement addCustButton;

    @FindBy(xpath = "//button[@ng-click='showCust()']")
    WebElement customersButton;

    public ManagerPage(final WebDriver webDriver) {
        try {
            PageFactory.initElements(webDriver, this);
            this.driver = webDriver;
        } catch (IllegalStateException e) {
            throw new RuntimeException();
        }
    }

    public AddCustPage addCustButtonClick() {
        addCustButton.click();
        return new AddCustPage(driver);
    }
    public CustomersPage customersButtonClick() {
        customersButton.click();
        return new CustomersPage(driver);
    }
}
