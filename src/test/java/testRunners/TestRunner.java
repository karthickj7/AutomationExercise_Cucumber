package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
//        features = {".\\Features\\"},
//        features = {".\\Features\\TC_001_RegisterUser.feature"},
//        features = {".\\Features\\TC_002_LoginValid.feature"},
//        features = {".\\Features\\TC_003_LoginInValid.feature"},
//        features = {".\\Features\\TC_004_LogoutUser.feature"},
//        features = {".\\Features\\TC_005_RegisterWithExistingMail.feature"},
//        features = {".\\Features\\TC_006_ContactUs.feature"},
//        features = {".\\Features\\TC_007_TestCase.feature"},
//        features = {".\\Features\\TC_008_VerifyProduct.feature",
//                    ".\\Features\\TC_009_SearchProduct.feature"},
//        features = {".\\Features\\TC_010_VerifySubscription.feature"},
//        features = {".\\Features\\TC_012_AddProductInCart.feature"},
        features = {".\\Features\\TC_013_VerifyProductQuantity.feature"},
        glue = "stepDefinitions",
        plugin = {
                "pretty", "html:Reports/myreport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        dryRun = false,
        monochrome = true,
        publish = true)
public class TestRunner {
}
