package automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InterviewPractice {

    public static void main(String[] args) {
        Assert.assertTrue(InterviewPractice.test1().contains("selenium"));
    }

   public static String test1() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys("Selenium", Keys.ENTER);
        String actual = driver.getCurrentUrl().toLowerCase();

        return actual;
    }
}
