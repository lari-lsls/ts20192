package pages;

import manager.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TableSortSearchPage {

    /*
     Page representation
     */

    private WebDriver driver;
    private WebDriverWait wait;

    private By tableTitleSelector = By.cssSelector(".text-left h2");
    private By searchInputSelector = By.cssSelector("#example_filter input");
    private By tableRowsSelector = By.cssSelector("#example tbody tr");
    private By showingMessageSelector = By.id("example_info");

    /*
     Page services
     */

    public TableSortSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = DriverManager.getWait();
    }

    public String getTableTitle(){
        return driver.findElement(tableTitleSelector).getText();
    }

    public int getAmountTableRows(){
        return driver.findElements(tableRowsSelector).size();
    }

    public void filterByCriteria(String criteria) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputSelector));
        driver.findElement(searchInputSelector).sendKeys("London");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(showingMessageSelector, "filtered"));
    }

}
