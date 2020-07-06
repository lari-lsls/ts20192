package pages;

import manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeftNavMenu {

    /*
     Page representation
     */

    private WebDriver driver;
    private WebDriverWait wait;

    // Nav Menu
    private By navMenuSelector = By.cssSelector("#navbar-brand-centered");
    private By inputFormsBtnSelector = By.cssSelector(".nav > li:nth-child(1)");
    private By datePickerBtnSelector = By.cssSelector(".nav > li:nth-child(2)");
    private By tableBtnSelector = By.cssSelector(".nav > li:nth-child(3)");

    // Nav sub menu
    private By navSubMenu = By.cssSelector(".dropdown-menu");
    private By tableSortSearchBtn = By.cssSelector("li:nth-child(4)");

    /*
     Page services
     */

    public LeftNavMenu(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getWait();
    }

    // Nav menu

    public void clickOnInputFormButton() {
        findButtonFromNavMenu(inputFormsBtnSelector).click();
    }

    public void clickOnDatePickerButton() {
        findButtonFromNavMenu(datePickerBtnSelector).click();
    }

    public void clickOnTableButton() {
        findButtonFromNavMenu(tableBtnSelector).click();
    }

    public TableSortSearchPage goToTableSortAndSearch() {
        this.clickOnTableButton();
        this.wait.until(ExpectedConditions.presenceOfElementLocated(tableSortSearchBtn));
        WebElement tableSubMenu = this.findButtonFromNavMenu(tableBtnSelector).findElement(navSubMenu);
        tableSubMenu.findElement(tableSortSearchBtn).click();
        return new TableSortSearchPage(driver);
    }

    /*
     Utils
     */

    private WebElement findButtonFromNavMenu(By btnSelector) {
        WebElement navMenu = driver.findElement(navMenuSelector);
        return navMenu.findElement(btnSelector);
    }














//
//    // Nav sub menu
//    private By navSubMenu = By.cssSelector(".dropdown-menu");
//    private By tableSortSearchBtn = By.cssSelector("li:nth-child(4)");


//    // Nav menu
//    public void clickOnInputFormButton() {
//        this.findButtonFromNavMenu(inputFormsBtnSelector).click();
//    }
//
//    public void clickOnDatePickerMenuButton() {
//        this.findButtonFromNavMenu(datePickerBtnSelector).click();
//    }
//
//    public void clickOnTableButton() {
//        this.findButtonFromNavMenu(tableBtnSelector).click();
//    }
//
//    // Nav sub menus
//
//    public TableSortSearchPage goToTableSortAndSearch() {
//        this.clickOnTableButton();
//        wait.until(ExpectedConditions.presenceOfElementLocated(tableSortSearchBtn));
//        WebElement tableSubMenu = this.findButtonFromNavMenu(tableBtnSelector).findElement(navSubMenu);
//        tableSubMenu.findElement(tableSortSearchBtn).click();
//        return new TableSortSearchPage(driver);
//    }
//
//    /*
//     Utils
//     */
//
//    private WebElement findButtonFromNavMenu(By buttonSelector){
//        WebElement navMenu = driver.findElement(navMenuSelector);
//        return navMenu.findElement(buttonSelector);
//    }

}
