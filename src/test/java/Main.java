import manager.DriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Main {

    WebDriver driver = DriverManager.getDriver();

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

    @Test
    public void atividade21() {
        System.out.println("*** ATIVIDADE 21 ***");
        driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");

        WebElement contactForm = driver.findElement(By.cssSelector("#task-table tbody tr:nth-child(4)"));
        System.out.println(contactForm.getText());

        DriverManager.endSession();
    }

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


}
