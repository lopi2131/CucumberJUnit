package glue;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.LoginPage;
import pages.MainPage;
import pages.NewArrivalsPage;
import pages.RegistrationPage;
import utils.BaseHooks;

public class Stepdefs extends BaseHooks {

    NewArrivalsPage newArrivalsPage = new NewArrivalsPage(driver);
    MainPage mainPage = new MainPage(driver);
    LoginPage loginPage = new LoginPage(driver);
    RegistrationPage registrationPage = new RegistrationPage(driver);

    @cucumber.api.java.en.Given("TSUM main page is open")
    public void tsumMainPageIsOpen() {
        mainPage.open();
    }

    @cucumber.api.java.en.Then("Language is Russian")
    public void languageIsRussian() {
        Assert.assertTrue(mainPage.checkLang().toLowerCase().contains("ru"));
        mainPage.setLocation();
        mainPage.setNewArrivals();
    }

    @Given("Catalog new arrivals is open")
    public void catalogNewArrivalsIsOpen() {
        Assert.assertEquals(newArrivalsPage.checkTab().toLowerCase(), "новинки для женщин");
    }

    @Then("Title equals New arrivals for women")
    public void titleEqualsNewArrivalsForWomen() {
        Assert.assertEquals(newArrivalsPage.getTitle(), "Новинки для женщин");
    }

    @And("Sorted by brand selected")
    public void sortedByBrandSelected() {
        newArrivalsPage.setSortByBrand();
    }

    @Then("Displayed products of the selected brand")
    public void displayedProductsOfTheSelectedBrand() {
        Assert.assertEquals(newArrivalsPage.checkBrandProduct().toLowerCase(), "gucci");
    }

    @And("Sorted by price up selected")
    public void sortedByPriceUpSelected() {
        newArrivalsPage.setSortByPriceUp();
    }

    @Then("Displayed products of the selected price up")
    public void displayedProductsOfTheSelectedPriceUp() {
        int firstPrice = Integer.parseInt(newArrivalsPage.checkSortByPriceUp().get(0).getText().replaceAll("[^0-9]", ""));
        int secondPrice = Integer.parseInt(newArrivalsPage.checkSortByPriceUp().get(1).getText().replaceAll("[^0-9]", ""));
        Assert.assertTrue("Проверка, что список отсортирован по возрастанию цены", secondPrice > firstPrice);
    }

    @And("Sorted by price down selected")
    public void sortedByPriceDownSelected() {
        newArrivalsPage.setSortByPriceDown();
    }

    @Then("Displayed products of the selected price down")
    public void displayedProductsOfTheSelectedPriceDown() {
        int firstPrice = Integer.parseInt(newArrivalsPage.checkSortByPriceUp().get(1).getText().replaceAll("[^0-9]", ""));
        int secondPrice = Integer.parseInt(newArrivalsPage.checkSortByPriceUp().get(2).getText().replaceAll("[^0-9]", ""));
        Assert.assertTrue("Проверка, что список отсортирован по убыванию цены", firstPrice > secondPrice);
    }

    @And("Man clothes selected")
    public void manClothesSelected() {
        newArrivalsPage.setManClothes();
    }

    @Then("Displayed main page")
    public void displayedMainPage() {
        Assert.assertEquals("Проверка, что открыта главная страница", "Модный интернет-магазин одежды", newArrivalsPage.checkMainPageDesc());
    }

    @Given("Login page open")
    public void loginPageOpen() {
        newArrivalsPage.openLoginPage();
    }

    @And("Only email has introduced")
    public void onlyEmailHasIntroduced() {
        loginPage.setEmail();
    }

    @Then("Login button is not enabled")
    public void loginButtonIsNotEnabled() {
        Assert.assertFalse(loginPage.checkLoginBtn().isEnabled());
    }

    @Given("Email and Password have introduced")
    public void emailAndPasswordHaveIntroduced() {
        loginPage.setPassword();
    }

    @And("Login button is enabled")
    public void loginButtonIsEnabled() {
        Assert.assertTrue(loginPage.checkLoginBtn().isEnabled());
    }

    @Then("Login forbidden")
    public void loginForbidden() {
        Assert.assertEquals("Проверка ошибки при неверном пароле", loginPage.checkErrorMessage(), "Неверный логин или пароль");
    }

    @Given("Registration page is open")
    public void registrationPageIsOpen() {
        loginPage.openRegPage();
    }

    @And("Email have introduced")
    public void emailHaveIntroduced() {
        registrationPage.setEmail();
    }

    @Then("Register button is not enabled")
    public void registerButtonIsNotEnabled() {
        Assert.assertFalse(registrationPage.checkLoginBtn().isEnabled());
    }

    @Given("Wrong email has introduced")
    public void wrongEmailHasIntroduced() {
        registrationPage.setWrongEmail();
    }

    @And("Password has introduced")
    public void passwordHasIntroduced() {
        registrationPage.setPassword();
    }

    @Then("Registration forbidden")
    public void registrationForbidden() {
        Assert.assertEquals("Проверка ошибки при неверном Email", registrationPage.checkErrorMessage(), "Указан некорректный email");
    }
}
