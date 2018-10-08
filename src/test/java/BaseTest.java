import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
    public static WebDriver driver;
    public static WebDriverWait wait;
    private final String baseUrl = "https://intita.com/";

    @BeforeAll
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anton_Poliakovskyi\\IdeaProjects\\intita-autotests\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://intita.com/");
    }

    @AfterAll
    public static void teardown(){
        driver.quit();
    }

}
