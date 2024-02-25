package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class CustomersPage {

    WebDriver driver;

    By sortFirstName = By.xpath("//a[contains(@ng-click,'fName')]");
    By listFirstName = By.xpath("//tr[contains(@ng-repeat,'cust in Customers')]//child::td[1]");

    public CustomersPage(final WebDriver webDriver) {
        try {
            PageFactory.initElements(webDriver, this);
            this.driver = webDriver;
        } catch (IllegalStateException e) {
            throw new RuntimeException();
        }
    }
    public void clickSortByFirstName(){
        driver.findElement(sortFirstName).click();
    }

    public void deleteCustomer() {
        List<String> listCustomers = getListFirstName();
        String averageFirstName = findFirstName(listCustomers);
        deleteCustomerByName(averageFirstName);
    }

    public List<String> getListFirstName() {
        return driver.findElements(listFirstName)
                .stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public String findFirstName(List<String>list){
        double avrLength = list.stream()
                .mapToInt(String::length)
                .average()
                .orElse(0.0);

        return list.stream()
                .min(Comparator.comparingDouble(name -> Math.abs(name.length() - avrLength))).get();
    }
    public void deleteCustomerByName(String name) {
        String xpath = "//td[text()='" + name + "']/following-sibling::td/child::button";
        driver.findElement(By.xpath(xpath)).click();
    }

}
