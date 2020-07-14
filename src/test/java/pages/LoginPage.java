package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage {

    private By email = By.xpath(".//input[@placeholder='Email']");
    private By loginBtn = By.xpath(".//button[contains(text(),'Войти')]");
    private By password = By.xpath(".//input[@placeholder='Пароль']");
    private By error = By.xpath(".//span[contains(text(),'Неверный логин или пароль')]");
    private By regBtn = By.xpath(".//p[contains(text(),'Регистрация')]");

    private Logger logger = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage setEmail(){
        driver.findElement(email).click();
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys("test@mail.com");
        driver.findElement(password).clear();
        logger.info("Введен email");

        return new LoginPage(driver);
    }

    public WebElement checkLoginBtn(){
        logger.info("Проверка активности кнопки Войти");

        return driver.findElement(loginBtn);
    }

    public LoginPage setPassword(){
        driver.findElement(password).sendKeys("test123");
        logger.info("Введен пароль");

        return new LoginPage(driver);
    }

    public String checkErrorMessage(){
        driver.findElement(loginBtn).click();
        WebElement element = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(error));
        logger.info("Проверка текста ошибки");

        return driver.findElement(error).getText();
    }

    public RegistrationPage openRegPage(){
        driver.findElement(regBtn).click();
        logger.info("Открыта страница регистрации");

        return new RegistrationPage(driver);
    }
}
