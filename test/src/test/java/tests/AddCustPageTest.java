package tests;

import helpers.Generator;
import org.junit.Test;
import pages.AddCustPage;

import static org.junit.Assert.assertTrue;

public class AddCustPageTest extends BaseTest {

    @Test
    public void formFillingOnTheAddCustPage() {
        AddCustPage page = managerPage.addCustButtonClick();
        Generator.generatePostCodeAndName();

        page.setFirstName(Generator.firstName);
        page.setSecondName("Last Name");
        page.setPostCodeField(Generator.postCode);
        page.clickAddButton();

        assertTrue(page.getaAlertText().contains("Customer added successfully with customer id :"));
        page.acceptAlert();
    }


}
