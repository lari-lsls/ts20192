package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import manager.DriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.LeftNavMenu;
import pages.MainPage;
import pages.TableSortSearchPage;

public class StepDefinitions {

    private WebDriver driver = DriverManager.getDriver();
    private MainPage mainPage;
    private LeftNavMenu leftNavMenu;
    private TableSortSearchPage tableSortSearchPage;

    @Given("the user access the table sort and search page")
    public void accessTableSortSearchPage() {
        mainPage = new MainPage(driver);
        leftNavMenu = new LeftNavMenu(driver);
        mainPage.accessPage();
        tableSortSearchPage = leftNavMenu.goToTableSortAndSearch();
    }

    @Given("there are {int} employees in the company")
    public void createEmployees(int amountOfEmployees) {
        // Não vamos fazer nada nesse passo, mas ele existe para representar
        // a possibilidade de poder preparar dados aqui.
    }

    @When("the user search for a employees using the word {string}")
    public void searchForEmployee(String searchCriteria) {
        tableSortSearchPage.filterByCriteria(searchCriteria);
    }

    @Then("{int} employees are shown in the list")
    public void assertAmountFilteredEmployees(int expectedAmountEmployees) {
        int actualAmountEmployees = tableSortSearchPage.getAmountTableRows();
        Assert.assertEquals(
                "The amount of employees displayed after filtering is not the expected.",
                expectedAmountEmployees,
                actualAmountEmployees);
    }
}
