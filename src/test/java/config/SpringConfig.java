package config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pages.*;
import utils.Browsers;


@Configuration
@ComponentScan(basePackages = "config")
public class SpringConfig {

    private Logger logger = LogManager.getLogger(SpringConfig.class);

    @Bean
    public WebDriver driver() {
        logger.info("Драйвер поднят");

        return Browsers.valueOf(System.getProperty("browser").toUpperCase()).create();
    }

    @Bean
    public MainPage mainPage(WebDriver driver){

        return new MainPage(driver);
    }


}
