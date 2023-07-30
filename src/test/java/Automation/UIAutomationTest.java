package Automation;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class UIAutomationTest {
    @Test
    public void verifyAppleIphone() {
        try {
            WebDriverManager.edgedriver().setup();
            WebDriver driver = new EdgeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.amazon.in/");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
            driver.findElement(By.id("nav-search-submit-button")).click();
            Boolean display = driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone')]")).isDisplayed();
            Assert.assertTrue(display,"First result contains the text 'Apple iPhone'");
            driver.quit();
        }
        catch (Exception e){

        }
    }

}
