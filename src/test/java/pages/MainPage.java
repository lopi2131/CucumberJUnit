package pages;

import config.ServerConfig;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

public class MainPage extends AbstractPage {
    private final By langBtn = By.xpath(".//span[contains(text(),'RU')]");

    private final Logger logger = LogManager.getLogger(MainPage.class);
    private final ServerConfig cfg = ConfigFactory.create(ServerConfig.class);


    public MainPage(WebDriver driver) {super(driver);}


    public MainPage open() {
        driver.get(cfg.url());
        logger.info("Открыта страница ЦУМ");

        return this;
    }

    public String checkLang(){
        logger.info("Возвращает язык интерфейса");

        return driver.findElement(langBtn).getText();
    }

}
