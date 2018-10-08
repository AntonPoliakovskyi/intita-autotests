import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleTest extends BaseTest {

    @Test
    public void test(){
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.clickCourses();
    }
}
