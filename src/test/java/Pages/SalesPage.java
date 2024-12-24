package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.module.Input;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SalesPage {
    WebDriver driver;

    public SalesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void cashSalesPage(){
        driver.findElement(By.xpath("//a[@href=\"/page/receivables/cashsales\"]")).click();
    }
    public void addCashInvoice() {
        driver.findElement(By.xpath("//button[@class=\"btn btn-success mb-0 ng-star-inserted\" and text()=\" إضافة \"]")).click();
    }

    public void selectBranch(String branch){
        WebElement branchDropDown = driver.findElement(By.name("Branch"));

        Select dropDown= new Select(branchDropDown);
        //String branchId = "dev";
        dropDown.selectByValue(branch);

        /*String selectedOption = dropDown.getFirstSelectedOption().getText();
        System.out.println("47" + selectedOption);*/
    }
    public void selectSalesman(String salesman){
        WebElement salesmanDropDown = driver.findElement(By.name("SalesMan"));

        Select dropDown= new Select(salesmanDropDown);
        dropDown.selectByValue(salesman);

    }
    public void selectItemCode(){

        // Click on the dropdown to open it
        WebElement itemDropDown = driver.findElement(By.name("itemcode0"));
        itemDropDown.click();

        // Wait for the option to become visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class=\"ng-star-inserted\" and text()=\" 3 | مرشوش فرنسي \"]")));
        option.click();

        // Locate the quantity input field by its ID, name, or other locator
        /*WebElement quantityField = driver.findElement(By.id("quantityFieldID"));

        // Clear any existing value and enter the desired quantity
        quantityField.clear();
        quantityField.sendKeys("10");

        // Optional: Assert the entered value
        Assert.assertEquals(quantityField.getAttribute("value"), "10");*/

    }
    public void AddSecondItem(){
        WebElement secondItem= driver.findElement(By.name("itemcode1"));
        secondItem.click();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement option=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[@class=\"ng-star-inserted\" and text()= \" 1 | معطر الشعر ماجيك غليتر للبنات - 120 مل \"]"))));
        option.click();

    }
    /*public void assertNegativeItem(){
       Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label=\"لا يمكن اتمام العمليه و الرصيد المتاح لهذا الصنف  \"]")).getText().contains("ا يمكن اتمام العمليه و الرصيد المتاح لهذا الصنف "));
    }*/

    public void deleteItem(){
        driver.findElement(By.xpath("//i[@class=\"fa fa-trash font-medium-3 m-0\"]")).click();
    }
    public void addTotalDiscountAndDelivery(){
       WebElement disc= driver.findElement(By.xpath("//input[@name=\"ovr_LocalDiscountPerc\"]"));
       disc.clear();
       disc.sendKeys("10");
       WebElement delivery= driver.findElement(By.xpath("//input[@name=\"ovr_LocalDeliveryFees\"]"));
       delivery.clear();
       delivery.sendKeys("14");
    }
    public void saveCashInvoice(){

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement option=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class=\"btn btn-success mr-2 mb-2\" and text()=\" حفظ \"]")));
        option.click();
    }
    public void assertionSave(){
        Assert.assertTrue(driver.findElement(By.xpath("//button[@class=\"btn btn-warning mr-2 mb-2 ng-star-inserted\"]")).isDisplayed());
    }
    public void addNewInvoice (){
        driver.findElement(By.xpath("//button[@class=\"btn btn-success mr-2 mb-2\" and text()=\" إنشاء جديد \"]")).click();

        //Assert.assertFalse(driver.findElement(By.xpath("//button[@class=\"btn btn-warning mr-2 mb-2 ng-star-inserted\" and text()=\" معاينة الطباعة \"]")).isEnabled());
    }

}
