import core.Driver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

import static org.junit.jupiter.api.TestInstance.*;

public class BaseTest {

    protected WebDriver driver;
    private static final String baseUrl = "https://intita.itatests.com";

    protected MainPage mainPage;


    @BeforeEach
    public void init() {
        driver = Driver.getDriver();
        mainPage = new MainPage(driver)
                .openMainPage();
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }


}
