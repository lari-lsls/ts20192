import manager.DriverManager;
import pages.URL;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LeftNavMenu;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {

    WebDriver driver = DriverManager.getDriver();
    WebDriverWait wait = DriverManager.getWait();

    @Ignore
    @Test
    public void atividade20() throws InterruptedException{
        System.out.println("*** ATIVIDADE 20 ***");
        driver.get("https://www.seleniumeasy.com/test/input-form-demo.html");

        WebElement contactForm = driver.findElement(By.cssSelector("#contact_form"));
        WebElement firstName = contactForm.findElement(By.cssSelector(".form-group input"));
        WebElement hostingYes = contactForm.findElement(By.cssSelector(".form-group:nth-of-type(10) .radio input"));
        WebElement sendBtn = contactForm.findElement(By.cssSelector(".form-group:last-child button"));
        WebElement selector = contactForm.findElement(By.cssSelector(".form-group:nth-of-type(7) select option:nth-child(2)"));

        firstName.sendKeys("Mary Angels");
        hostingYes.click();
        //selector.sendKeys("Alaska");
        selector.click();
        Thread.sleep(2000);
        sendBtn.click();
        Thread.sleep(2000);

        DriverManager.endSession();
    }

    @Ignore
    @Test
    public void atividade21() {
        System.out.println("*** ATIVIDADE 21 ***");
        driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");

        WebElement contactForm = driver.findElement(By.cssSelector("#task-table tbody tr:nth-child(4)"));
        System.out.println(contactForm.getText());

        DriverManager.endSession();
    }

    @Ignore
    @Test
    public void atividade22() {
        System.out.println("*** ATIVIDADE 22 ***");
        driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");

        WebElement thirdColumnHead = driver.findElement(By.cssSelector("#task-table thead th:nth-child(3)"));
        List<WebElement> thirdColumnBody = driver.findElements(By.cssSelector("#task-table tbody tr td:nth-child(3)"));

        System.out.println("HEADER 3: " + thirdColumnHead.getText());
        for (WebElement columnData : thirdColumnBody){
            System.out.println(columnData.getText());
        }

        DriverManager.endSession();
    }

    @Ignore
    @Test
    public void atividade23() throws InterruptedException {
        System.out.println("*** ATIVIDADE 23 ***");
        driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");

        WebElement filterBtn = driver.findElement(By.cssSelector(".filterable .panel-heading button"));
        WebElement filters = driver.findElement(By.cssSelector(".filterable table .filters"));
        WebElement userNameFilter = filters.findElement(By.cssSelector("th:nth-child(2) input"));
        WebElement lastNameFilter = filters.findElement(By.cssSelector("th:nth-child(4) input"));

        filterBtn.click();
        userNameFilter.sendKeys("jaco");
        lastNameFilter.sendKeys("k");
        Thread.sleep(1000);

        WebElement firstRow = driver.findElement(By.cssSelector(".filterable tbody tr:not([style='display: none;'])"));
        System.out.println(firstRow.getText());

        Thread.sleep(2000);
        DriverManager.endSession();

    }

    @Ignore
    @Test
    public void atividade24() throws InterruptedException {
        System.out.println("*** ATIVIDADE 24 ***");
        driver.get("https://www.cesar.school");

        WebElement docBody = driver.findElement(By.tagName("body"));
        WebElement toolbar = driver.findElement(By.className("toolbar-container"));

        //findElement seguido por findElements
        List<WebElement> toolbarLinksElements = toolbar.findElements(By.cssSelector(".pull-left a"));

        //getAttribute
        for (WebElement linkElement : toolbarLinksElements){
            System.out.print("Link for " + linkElement.getText().replace("|", "") + ":");
            System.out.println(linkElement.getAttribute("href"));
        }

        //sendKeys
        docBody.sendKeys(Keys.CONTROL, Keys.END);

        //isDisplayed
        System.out.println("Is the toolbar displayed? " + toolbar.isDisplayed());

        //isEnabled
        System.out.println("Is the first link enabled? " + toolbarLinksElements.get(0).isEnabled());

        Thread.sleep(2000);
        DriverManager.endSession();

    }

    @Ignore
    @Test
    public void atividade25() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");

        try {
            driver.findElement(By.cssSelector(".doesnotexist"));
        } catch(Exception e){
            System.out.println("EXCEPTION: " + e.getClass());
        }

        DriverManager.endSession();
    }

    @Ignore
    @Test
    public void atividade26() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");

        try {
            driver.findElement(By.cssSelector("#block_top_menu .submenu-container"));
        } catch(Exception e){
            System.out.println("EXCEPTION: " + e.getClass());
        }

        DriverManager.endSession();
    }

    @Ignore
    @Test
    public void atividade27() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.MINUTES);
        driver.get("http://automationpractice.com/index.php");

        try {
            driver.findElement(By.cssSelector("#block_top_menu .menu-content"));
        } catch(Exception e){
            System.out.println("EXCEPTION: " + e.getClass());
        }

        DriverManager.endSession();
    }

    @Ignore
    @Test
    public void atividade28() {
        driver.get("http://automationpractice.com/index.php");
        By elementNotVisibleSelector = By.cssSelector("#block_top_menu .submenu-container");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementNotVisibleSelector));
        driver.findElement(elementNotVisibleSelector);

//        try {
//            DriverManager.getWait().until(ExpectedConditions.visibilityOfElementLocated(elementNotVisibleSelector));
//            driver.findElement(elementNotVisibleSelector);
//        } catch(Exception e){
//            System.out.println("EXCEPTION: " + e.getClass());
//        }

        DriverManager.endSession();
    }

    @Ignore
    @Test
    public void atividade29() {
        WebDriverWait wait2 = new WebDriverWait(driver, 20);
        driver.get("https://www.seleniumeasy.com/test/ajax-form-submit-demo.html");

        WebElement nameInput = driver.findElement(By.cssSelector("#title"));
        WebElement commentInput = driver.findElement(By.id("description"));
        WebElement submitBtn = driver.findElement(By.id("btn-submit"));
        By tempImgSelector = By.cssSelector("#submit-control img");
        By successMessage = By.cssSelector("#submit-control");

        nameInput.sendKeys("thats the name");
        commentInput.sendKeys("thats the comment");
        submitBtn.click();

        wait2.until(ExpectedConditions.stalenessOf(driver.findElement(tempImgSelector)));
        System.out.println("SUCCESS MSG: " + driver.findElement(successMessage).getText());

        DriverManager.endSession();
    }

    @Ignore
    @Test
    public void atividade30() {
        driver.get("https://www.seleniumeasy.com/test");

        WebElement botaoTableMenu = driver.findElement(By.cssSelector("#navbar-brand-centered .nav > li:nth-child(3)"));
        WebElement botaoTableSortSearch = botaoTableMenu.findElement(By.cssSelector(".dropdown-menu > li:nth-child(4)"));
        By seletorSearchInput = By.cssSelector("#example_filter input");
        By seletorLinhasTabela = By.cssSelector("#example tbody tr");
        By seletorMensagemShowing = By.cssSelector("#example_info");

        botaoTableMenu.click();
        botaoTableSortSearch.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(seletorSearchInput));
        driver.findElement(seletorSearchInput).sendKeys("London");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(seletorMensagemShowing, "filtered"));

        int quantidadeLinhasAtual = driver.findElements(seletorLinhasTabela).size();
        int quantidadeLinhasEsperada = 7;

        Assert.assertEquals(
                "A quantidade de linhas da tabela não é igual a esperada.",
                quantidadeLinhasEsperada,
                quantidadeLinhasAtual);

        DriverManager.endSession();

    }

    @Ignore
    @Test
    public void atividade32() {
        // Setup
        //MainPage mainPage = new MainPage(driver);
        LeftNavMenu leftNavMenu = new LeftNavMenu(driver);
        String expectedTableTitle = "Table Sort And Search Demo";

        // Given
        //mainPage.accessPage();
        //driver.get("https://www.seleniumeasy.com/test");
        driver.get(URL.MAIN_PAGE);

        // When
        String currentTableTitle = leftNavMenu.goToTableSortAndSearch().getTableTitle();

        // Then
        Assert.assertEquals(expectedTableTitle, currentTableTitle);

        // End session
        DriverManager.endSession();
    }
}
