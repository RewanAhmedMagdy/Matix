package Test;

import Pages.LoginPage;
import Pages.SalesPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
    LoginPage loginPage;
    SalesPage salesPage;

    @BeforeClass
    public void precondition(){
        loginPage =new LoginPage(driver);
        salesPage =new SalesPage(driver);

    }
    @Test
    public void navigate(){
        loginPage.navigate();
        loginPage.loginValidUser("erpdemo" , "Rewan" ,"T");
        loginPage.loginButton();
        loginPage.assertToLogin();
        loginPage.goToSalesModule();

        salesPage.cashSalesPage();
        salesPage.addCashInvoice();
        salesPage.selectBranch("47");
        salesPage.selectSalesman("27");
        salesPage.selectItemCode();
        salesPage.AddSecondItem();
        //salesPage.assertNegativeItem();
        salesPage.deleteItem();
        salesPage.addTotalDiscountAndDelivery();
        salesPage.saveCashInvoice();
        salesPage.assertionSave();
        salesPage.addNewInvoice();

    }


}
