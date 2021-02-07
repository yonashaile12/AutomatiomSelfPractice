package automation.step_definition;

import automation.pages.BasePage;
import automation.pages.LoginPage;
import automation.pages.usersPage;
import automation.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class showRecords_stepDefinitions {
   LoginPage loginPage = new LoginPage();
    Select select;
    usersPage usersPage = new usersPage();

    @When("I click on {string} link")
    public void i_click_on_link(String link) {

        BrowserUtils.waitForVisibility(loginPage.dashBoardPageLink, 5);
        switch (link.toLowerCase()){
            case "dashboard":
                loginPage.dashBoardPageLink.click();
                break;
            case "users":
                loginPage.usersPageLink.click();
                break;
            case "books":
                loginPage.booksPageLink.click();
                break;
        }
    }

    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer expected) {
        BrowserUtils.waitForVisibility(usersPage.showRecordsDropDowns, 5);
        select = new Select(usersPage.showRecordsDropDowns);
        System.out.println(select.getFirstSelectedOption().getText());
        String actual = select.getFirstSelectedOption().getText();
        Assert.assertEquals(expected+"", actual);
    }
    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> options) {

//        System.out.println("options.size() = " + options.size());
//        System.out.println("options = " + options);
        select = new Select(usersPage.showRecordsDropDowns);
        List<WebElement> webElements = select.getOptions();

        List<String> actualTexts = BrowserUtils.getElementsText(webElements);
        Assert.assertEquals(options, actualTexts);


    }

}
