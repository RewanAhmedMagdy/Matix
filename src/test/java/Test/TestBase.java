package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class TestBase {
    WebDriver driver;

    @BeforeClass
    public void openBrowser(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /*@AfterClass
    public void closeBrowser() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.quit();
    }*/

}
