import core.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    private static WebDriver driver;
    private static final String baseUrl = "https://intita.itatests.com/";

    @BeforeAll
    public static void init() {
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterAll
    public static void teardown() {
        driver.quit();
    }

}
