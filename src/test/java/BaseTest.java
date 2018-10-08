import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private static final String baseUrl = "https://intita.com/";

    @BeforeAll
    public static void setup(){
        //System.setProperty("webdriver.chrome.driver", "drivers" + File.separator + "chromedriver.exe");
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("mac"))
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/mac/chromedriver");
        else
            System.setProperty("webdriver.chrome.driver", "TBD");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterAll
    public static void teardown(){
        driver.quit();
    }

}
