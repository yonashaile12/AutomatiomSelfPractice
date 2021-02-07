package automation.step_definition;

import automation.pages.usersPage;
import automation.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class UsersTable_StepDefinition {
        usersPage userPage = new usersPage();
    @Then("table should have following column names:")
    public void table_should_have_following_column_names(List<String> expectedColumnNames) {
//        System.out.println("expectedColumnNames = " + expectedColumnNames);
        BrowserUtils.waitForVisibility(userPage.showRecordsDropDowns, 10);
        List<String> actualColumnNames = BrowserUtils.getElementsText(userPage.tableHeaders);
        Assert.assertEquals(expectedColumnNames, actualColumnNames);


    }

}
