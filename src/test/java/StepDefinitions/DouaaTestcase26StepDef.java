package StepDefinitions;

import Pages.DouaaPOM26;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class DouaaTestcase26StepDef {
    DouaaPOM26 da = new DouaaPOM26();
    @Then("the Proper and good UI should be displayed on the Register Account page")
    public void theProperAndGoodUIShouldBeDisplayedOnTheRegisterAccountPage() {
        Assert.assertTrue(da.getMyAccount().getText().equals("Account"));
    }
}

