package automation.step_definition;

import automation.pages.LoginPage;
import automation.utilities.BrowserUtils;
import automation.utilities.ConfigurationReader;
import automation.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class login_stepDefinitions {

    LoginPage loginPage = new LoginPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
    }

    @When("user enters a valid username")
    public void user_enters_a_valid_username() {
        String username = ConfigurationReader.getProperty("student_username");
        loginPage.usernameInput.sendKeys(username);
    }
    @When("user enters a valid password")
    public void user_enters_a_valid_password() {
        String password = ConfigurationReader.getProperty("student_password");
        loginPage.passwordInput.sendKeys(password);
      //  Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage.signInBtn.click();
    }
    @Then("user should able to login")
    public void user_should_able_to_login() {
       // Driver.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        String actual = Driver.getDriver().getTitle();
        String expected = "Login - Library";
        Assert.assertEquals("Assertion Failed!!!", expected, actual);

    }

    @When("user enters username {string}")
    public void userEntersUsername(String username) {
        loginPage.usernameInput.sendKeys(username);
    }

    @When("user enters password {string}")
    public void userEntersPassword(String password) {
        loginPage.passwordInput.sendKeys(password, Keys.ENTER);

        String actual = Driver.getDriver().getTitle();
        String expected = "Login - Library";
        Assert.assertEquals("Assertion Failed!!!",expected, actual);
    }

    @When("I enter username {string}")
    public void i_enter_username(String username) {
        loginPage.usernameInput.sendKeys(username);

    }
    @When("I enter password {string}")
    public void i_enter_password(String password) {
        loginPage.passwordInput.sendKeys(password);
    }
    @When("click the sign in button")
    public void click_the_sign_in_button() {
        loginPage.signInBtn.click();
    }
    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
        String expected = "dashboard";
        wait.until(ExpectedConditions.urlContains(expected));
        String actual = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actual.contains(expected));
    }
    @Then("there should be {int} users")
    public void there_should_be_users(int numOfUsers) {
        String num = loginPage.userCount.getText();
        int numUsers = Integer.parseInt(num);

        wait.until(ExpectedConditions.visibilityOf(loginPage.userCount));

        Assert.assertEquals(numUsers, numOfUsers);


    }

    @When("I login using {string} and {string}")
    public void iLoginUsingAnd(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password, Keys.ENTER);

    }


    @Then("account holder name should be {string}")
    public void account_holder_name_should_be(String expectedUsername) {
        BrowserUtils.waitForVisibility(loginPage.accountUsername, 5);

        String actualAccountUsername = loginPage.accountUsername.getText();

        Assert.assertEquals("Account username is not as expected!"
                , expectedUsername, actualAccountUsername);

        Driver.closeDriver();
    }


}
