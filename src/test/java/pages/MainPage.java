package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    /*
     Page representation
     */

    private WebDriver driver;
    private String pageUrl = "https://www.seleniumeasy.com/test";
    private By siteNameSelector = By.cssSelector("#name-and-slogan .site-name");
    private By siteSloganSelector = By.cssSelector("#name-and-slogan .site-slogan");

    /*
     Page services
     */

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage accessPage() {
        driver.get(pageUrl);
        return this;
    }

    public String getSiteName() {
        return driver.findElement(this.siteNameSelector).getText();
    }

    public String getSiteSlogan() {
        return driver.findElement(this.siteSloganSelector).getText();
    }
}
