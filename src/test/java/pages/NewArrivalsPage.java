package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NewArrivalsPage extends AbstractPage {

    private By title = By.xpath(".//h1[contains(text(),'Новинки для женщин')]");
    private By tab = By.xpath(".//span[contains(text(),'Новинки для женщин')]");
    private By newArrivals = By.xpath(".//a[@class='header__link header__link_type_nav' and @title='Новинки']");
    private By brandList = By.xpath(".//div[contains(text(),'Бренд')]");
    private By search = By.xpath("//input[@placeholder='Поиск по брендам']");
    private By gucci = By.xpath(".//a[@href='/catalog/sel/new-arrivals-women/?brand=165201' and contains(text(),'Gucci')]");
    private By bandProduct = By.xpath(".//p[@class='product__brand']");
    private By gucciList = By.xpath(".//a[@href='/product/5500857-khlopkovyi-svitshot-gucci-fioletovyi/' and @class='product__image-wrapper product__image-wrapper-gallery']");
    private By sortList = By.xpath("//div[@class='select__current']");
    private By priceUp = By.xpath(".//span[contains(text(),'по возрастанию цены')]");
    private By productPrice = By.xpath(".//span[@class='price ng-star-inserted']");
    private By priceDown = By.xpath(".//span[contains(text(),'по убыванию цены')]");
    private By manClothesBtn = By.xpath(".//span[contains(text(),'Мужское') and @class='header__gender ng-star-inserted']");
    private By mainPageDesc = By.xpath(".//h1[contains(text(),'Модный интернет-магазин одежды')]");
    private By loginBtn = By.xpath(".//a[contains(text(),'Личный кабинет')]");

    private Logger logger = LogManager.getLogger(NewArrivalsPage.class);

    public NewArrivalsPage(WebDriver driver) {
        super(driver);
    }

    public String checkTab() {
        WebElement element = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(newArrivals));
        logger.info("Открыта вкладка Новинки");
        ;

        WebElement element2 = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(tab));

        System.out.println(driver.findElement(tab).getText());

        return driver.findElement(tab).getText();
    }

    public String getTitle() {
        logger.info("Получен заголовок страницы");
        WebElement element = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(title));
        System.out.println(driver.findElement(title).getText());

        return driver.findElement(title).getText();
    }

    public NewArrivalsPage setSortByBrand() {
        driver.findElement(brandList).click();
        driver.findElement(search).sendKeys("Gucci");
        WebElement element = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.elementToBeClickable(gucci));
        element.click();
        logger.info("Выбрана сортировка по бренду Gucci");

        return new NewArrivalsPage(driver);
    }

    public String checkBrandProduct() {
        WebElement element = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOfElementLocated(gucciList));
        List<WebElement> products = driver.findElements(bandProduct);
        logger.info("Проверка, что в списке отображаются товары бренда Gucci");

        return products.get(0).getText();
    }

    public NewArrivalsPage setSortByPriceUp() {
        driver.findElement(sortList).click();
        driver.findElement(priceUp).click();
        logger.info("Выбрана сортировка по возрастанию цены");

        return new NewArrivalsPage(driver);
    }

    public List<WebElement> checkSortByPriceUp() {
        WebElement element = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.elementToBeClickable(productPrice));
        List<WebElement> products = driver.findElements(productPrice);
        logger.info("Создан список товаров, отсортированных по возрастанию цены");

        return products;
    }

    public NewArrivalsPage setSortByPriceDown() {
        driver.findElement(sortList).click();
        driver.findElement(priceDown).click();
        logger.info("Выбрана сортировка по убыванию цены");

        return new NewArrivalsPage(driver);
    }

    public List<WebElement> checkSortByPriceDown() {
        WebElement element = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.elementToBeClickable(productPrice));
        List<WebElement> products = driver.findElements(productPrice);
        logger.info("Создан список товаров, отсортированных по убыванию цены");

        return products;
    }

    public NewArrivalsPage setManClothes() {
        driver.findElement(manClothesBtn).click();
        logger.info("Выбрана мужская одежда");

        return new NewArrivalsPage(driver);
    }

    public String checkMainPageDesc() {
        logger.info("Получено описание с главной страницы");

        return driver.findElement(mainPageDesc).getText();
    }

    public LoginPage openLoginPage() {
        driver.findElement(loginBtn).click();
        logger.info("Открыта страница авторизации");

        return new LoginPage(driver);
    }
}
