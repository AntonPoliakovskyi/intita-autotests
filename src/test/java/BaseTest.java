import core.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class BaseTest {
    protected WebDriver driver;

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
