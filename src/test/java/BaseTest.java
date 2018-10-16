import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    private static final String baseUrl = "https://intita.itatests.com/";

    @BeforeAll
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers" + File.separator + "chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver,5);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterAll
    public static void teardown(){
        driver.quit();
    }

}
