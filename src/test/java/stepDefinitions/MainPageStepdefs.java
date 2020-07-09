package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pages.MainPage;
import utils.BaseHooks;


public class MainPageStepdefs extends SpringIntegrationTest{

    @Autowired
    MainPage mainPage;



    @Given("TSUM main page is open")
    public void tsumMainPageIsOpen() {
        mainPage.open();
    }

    @Then("Language is Russian")
    public void languageIsRussian() {
        Assert.assertEquals(mainPage.checkLang().toLowerCase(), "ru");
    }

    @Then("Location is Samara")
    public void locationIsSamara() {
        System.out.println("123");
    }
}

