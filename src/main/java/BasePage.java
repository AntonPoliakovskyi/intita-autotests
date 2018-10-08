import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {


    private static final By coursesBtn = By.cssSelector("#menulist > ul > li:nth-child(1) > a");

    public WebDriver driver;
    public WebDriverWait wait;



    public BasePage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void clickCourses(){
        driver.findElement(coursesBtn).click();
    }
}
