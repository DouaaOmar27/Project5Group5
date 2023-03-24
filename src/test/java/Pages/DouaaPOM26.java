package Pages;

import UtilityPacage.BasicDriver;
import UtilityPacage.MyMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DouaaPOM26 extends MyMethods {
    public DouaaPOM26() { PageFactory.initElements(BasicDriver.getDriver(), this);

    }

    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement myAccount;

    @FindBy(xpath = "//span[text()='My Account']/../..//a[text()='Register']")
    private WebElement registerUnderMyAccount;

    public WebElement getMyAccount() {
        return myAccount;
    }

    public WebElement getRegisterUnderMyAccount() {
        return registerUnderMyAccount;
    }
}

