package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends AbstractPage {

    private By email = By.xpath(".//input[@placeholder='Email']");
    private By regBtn = By.xpath(".//button[contains(text(),'Зарегистрироваться')]");
    private By password = By.xpath(".//input[@placeholder='Пароль']");
    private By error = By.xpath(".//span[contains(text(),'Указан некорректный email')]");

    private Logger logger = LogManager.getLogger(RegistrationPage.class);

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage setEmail(){
        driver.findElement(email).sendKeys("test123@mail.com");
        logger.info("Введен Email");

        return new RegistrationPage(driver);
    }

    public WebElement checkLoginBtn(){
        logger.info("Проверка активности кнопки Зарегистрироваться");

        return driver.findElement(regBtn);
    }

    public RegistrationPage setWrongEmail(){
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys("qwerty");
        logger.info("Введен Email");

        return new RegistrationPage(driver);
    }

    public RegistrationPage setPassword(){
        driver.findElement(password).sendKeys("test123");
        logger.info("Введен пароль");

        return new RegistrationPage(driver);
    }

    public String checkErrorMessage(){
        driver.findElement(regBtn).click();
        WebElement element = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(error));
        logger.info("Проверка текста ошибки");

        return driver.findElement(error).getText();
    }
}
