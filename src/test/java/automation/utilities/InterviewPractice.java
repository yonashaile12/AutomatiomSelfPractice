package automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InterviewPractice {

    @Test
   public void test1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
        String actual = driver.getCurrentUrl().toLowerCase();

        String expected = "selenium";

        Assert.assertTrue(actual.contains( expected));


    }
}
