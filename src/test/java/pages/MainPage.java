package pages;

import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage {
    private By langBtn = By.xpath(".//span[contains(text(),'RU')]");
    private By newArrivals = By.xpath(".//a[@class='header__link header__link_type_nav' and @title='Новинки']");
    private By confirmLocation = By.xpath("//button[@class='ui-button ui-button_block ui-button_theme_quite-black']");

    private Logger logger = LogManager.getLogger(MainPage.class);
    private ServerConfig cfg = ConfigFactory.create(ServerConfig.class);

    Actions builder = new Actions(driver);

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open() {
        driver.get(cfg.url());
        logger.info("Открыта страница ЦУМ");

        return this;
    }

    public String checkLang() {
        logger.info("Проверка языка интерфейса");

        return driver.findElement(langBtn).getText();
    }

    public MainPage setLocation() {
        driver.findElement(confirmLocation).click();

        return new MainPage(driver);
    }

    public NewArrivalsPage setNewArrivals() {
        WebElement arrivals = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(newArrivals));
        builder.moveToElement(arrivals).click().build().perform();
        logger.info("Переход во вкладку Новинки");

        return new NewArrivalsPage(driver);
    }
}
