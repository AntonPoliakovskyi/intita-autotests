package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    public static WebDriver getDriver() {
        WebDriver driver;
        String browser = IntitaProperties.getProperties().getProperty("browser");
        switch (browser) {
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
        }
        return driver;
    }
}
