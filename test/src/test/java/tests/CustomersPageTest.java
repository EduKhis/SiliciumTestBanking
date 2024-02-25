package tests;

import org.junit.Test;
import pages.CustomersPage;

import static org.junit.Assert.assertEquals;

public class CustomersPageTest extends BaseTest {

    @Test
    public void clickSortByFirstNameOnTheCustomersPage() {
        CustomersPage page = managerPage.customersButtonClick();

        page.clickSortByFirstName();

    }
    @Test
    public void deleteCustomer() {
        CustomersPage page = managerPage.customersButtonClick();
        int listSize = page.getListFirstName().size();

        page.deleteCustomer();
        assertEquals(listSize,page.getListFirstName().size()+1);
    }

}
