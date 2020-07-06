package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import manager.DriverManager;

public class Hooks {

    @Before(order = 1)
    public void firstBeforeScenario() {
        System.out.println("BEFORE1");
        DriverManager.getDriver();
    }

    @Before(order = 2)
    public void secondBeforeScenario() {
        System.out.println("BEFORE2");
    }

    @After(order = 3)
    public void firstAfterScenario() {
        System.out.println("AFTER1");
        DriverManager.endSession();
    }

    @After(order = 2)
    public void secondAfterScenario() {
        System.out.println("AFTER2");
    }

    @After(order = 1, value = "@especialAfter")
    public void thirdAfterScenarioB() {
        System.out.println("AFTER3 ONLY FOR @especialAfter");
    }

}
