package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }
    public void navigate(){
        driver.navigate().to("https://workshop.matixerp.com/pages/login");
        driver.manage().window().maximize();
        // يستنى انه يعمل لوجين الاول
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //this for all project

    }
    public void loginValidUser(String domain , String userName , String password) {

        driver.findElement(By.xpath("//input[@formcontrolname=\"domain\"]")).sendKeys(domain);
        driver.findElement(By.xpath("//input[@autocomplete=\"username\"]")).sendKeys(userName);
        driver.findElement(By.xpath("//input[@autocomplete=\"current-password\"]")).sendKeys(password);

    }
    public void loginButton(){
        driver.findElement(By.xpath("//button[@class=\"btn bg-gradient-secondary w-100 my-4 mb-2\"]")).click();
    }
   public void assertToLogin(){
      // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      // wait.until(ExpectedConditions.elementToBeSelected(driver.findElement("//h6[@class=\"text-white text-capitalize ps-3\" and text()=\" الاختصارات \"]")));
       Assert.assertTrue(driver.findElement(By.xpath(
                "//h6[@class=\"text-white text-capitalize ps-3\" and text()=\" الاختصارات \"]")).isDisplayed());
    }
    public void goToSalesModule(){

        WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href=\"/page/receivables/dashboard\"]/span[@class=\"menu-title ng-tns-c101-0\" and text()=\"المبيعات\"]")));
        driver.findElement(By.xpath("//a[@href=\"/page/receivables/dashboard\"]/span[@class=\"menu-title ng-tns-c101-0\" and text()=\"المبيعات\"]")).click();
    }

}
