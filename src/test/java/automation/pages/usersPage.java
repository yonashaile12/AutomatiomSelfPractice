package automation.pages;

import automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class usersPage {

    public usersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//select[@name='tbl_users_length']")
    public WebElement showRecordsDropDowns;

    @FindBy(tagName = "th")
    public List<WebElement> tableHeaders;
}
