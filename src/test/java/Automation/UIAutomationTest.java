package Automation;

import java.util.concurrent.TimeUnit;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class UIAutomationTest {
    public static void main(String[] args) {
        try {
            WebDriverManager.edgedriver().setup();

            WebDriver driver = new EdgeDriver();
            //       WebDriver driver = new ChromeDriver();

            driver.manage().window().maximize();
            driver.get("https://www.amazon.in/");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
            driver.findElement(By.id("nav-search-submit-button")).click();
            Boolean display = driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone')]")).isDisplayed();
            if (display = true) {
                System.out.println("First result contains the text 'Apple iPhone'");
            }

            driver.quit();
        }
        catch (Exception e){

        }
    }



}
