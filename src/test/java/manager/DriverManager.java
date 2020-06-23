package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            System.setProperty("webdriver.chrome.silentOutput", "true");
            Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void endSession() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
