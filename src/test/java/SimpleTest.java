import org.junit.jupiter.api.Test;

public class SimpleTest extends BaseTest {

    @Test
    public void test() throws InterruptedException {
        MainPage mainPage = new MainPage(driver, wait);
        mainPage.chooseLanguage(BasePage.Languages.EN);
        mainPage.clickCourses();

    }
}
