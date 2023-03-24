package TestNG;

import Pages.DouaaPOM26;
import UtilityPacage.ParallelDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase27TestNG extends ParallelDriver {
    DouaaPOM26 forTestCase27 = new DouaaPOM26();
    @Test

    void crossBrowsers(){

        driver.get("http://opencart.abstracta.us/index.php?route=common/home");
        forTestCase27.clickMethod(forTestCase27.getMyAccount());
        forTestCase27.clickMethod(forTestCase27.getRegisterUnderMyAccount());



    }


}
